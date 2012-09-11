package spx.net;

import java.util.HashMap;

import spx.core.Settings;
import aigilas.management.Commands;

public class Server extends Thread {
	private boolean isRunning = true;
	private HashMap<Integer, HashMap<Commands, Boolean>> _playerStatus = new HashMap<>();
	private int _rngSeed = (int) System.currentTimeMillis();
	private Message _message = Message.Empty();
	private Integer _turnCount = 0;
	private boolean[] _readyCheckIn = { true, true, true, true };

	private ClientManager clients;

	public Server() {
		setName("Server");
		clients = new ClientManager();
		for (int ii = 0; ii < Message.PlayerMax; ii++) {
			_playerStatus.put(ii, new HashMap<Commands, Boolean>());
			for (Commands command : Commands.values()) {
				_playerStatus.get(ii).put(command, false);
			}
		}
	}

	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			pollForNewMessages();
			broadCastGameState();
		}
	}

	private void pollForNewMessages() {
		_message = clients.readMessage();
		if (_message != null) {
			if (Settings.Get().serverVerbose)
				System.out.println("SERVER: Message received: " + _message.MessageType);
			switch (_message.MessageType) {
				case CONNECT:
					System.out.println("SERVER: New client connection");
					SendMessage(Message.CreateInit(clients.size() - 1, _rngSeed), _message.LocalPort);
					if (Settings.Get().serverVerbose)
						System.out.println("SERVER: Accepted new connection");
					_turnCount = 0;
					break;
				case CHECK_STATE:
					InitPlayer(_message.PlayerIndex, _message.Command);
					_message.IsActive = _playerStatus.get(_message.PlayerIndex).get(_message.Command);
					if (Settings.Get().serverVerbose)
						System.out.println(String.format("SERVER: Check extends  CMD(%s) PI(%s) AC(%s)", _message.PlayerIndex, _message.Command, _playerStatus.get((int) _message.PlayerIndex).get(_message.Command)));
					SendMessage(_message, _message.LocalPort);
					break;

				case MOVEMENT:
					InitPlayer(_message.PlayerIndex, _message.Command);
					if (Settings.Get().serverVerbose)
						System.out.println(String.format("SERVER: Moves:  CMD(%s) PI(%s) AC(%s)", _message.PlayerIndex, _message.Command, _message.IsActive));
					_playerStatus.get(_message.PlayerIndex).put(_message.Command, _message.IsActive);
					break;

				case START_GAME:
					System.out.println("SERVER: Announcing game commencement.");
					Announce(_message);
					break;

				case PLAYER_COUNT:
					if (Settings.Get().serverVerbose)
						System.out.println("SERVER: PLAYER COUNT");
					SendMessage(Message.CreatePlayerCount(clients.size()), _message.LocalPort);
					break;

				case READY_FOR_NEXT_TURN:
					if (Settings.Get().serverVerbose)
						System.out.println("SERVER: Received ready signal from client");
					_readyCheckIn[_message.PlayerIndex] = true;
					break;

				case HEART_BEAT:
					_readyCheckIn[_message.PlayerIndex] = true;
					break;
				default:
					if (Settings.Get().serverVerbose)
						System.out.println("SERVER: Unknown message");
					break;
			}
		}
	}

	private void InitPlayer(int playerIndex, Commands command) {
		if (!_playerStatus.containsKey(playerIndex)) {
			_playerStatus.put(playerIndex, new HashMap<Commands, Boolean>());
		}
		if (!_playerStatus.get(playerIndex).containsKey(command)) {
			_playerStatus.get(playerIndex).put(command, false);
		}
	}

	public boolean IsOnlyInstance() {
		return clients.isOnlyInstance();
	}

	private void broadCastGameState() {
		int readyCount = 0;
		for (int ii = 0; ii < _readyCheckIn.length; ii++) {
			readyCount += _readyCheckIn[ii] ? 1 : 0;
		}
		if (readyCount >= clients.size()) {
			if (Settings.Get().serverVerbose)
				System.out.println("SERVER: Announcing player input status.");
			Announce(Message.CreatePlayerState(_playerStatus, _turnCount++, _rngSeed));
			for (int ii = 0; ii < _readyCheckIn.length; ii++) {
				_readyCheckIn[ii] = false;
			}
		}
	}

	private void Announce(Message contents) {
		clients.announce(contents);
	}

	private void SendMessage(Message contents, int localPort) {
		contents.LocalPort = localPort;
		clients.send(contents);
	}

	public void Close() {
		isRunning = false;
		System.out.println("SERVER: Shutting down");
	}
}

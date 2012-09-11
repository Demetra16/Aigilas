package aigilas.states;

import spx.entities.EntityManager;
import spx.net.Client;
import spx.states.State;
import aigilas.dungeons.DungeonFactory;

public class GameplayState implements State {
	public GameplayState() {
		System.out.println("Generating the dungeon...");
		EntityManager.Reset();
		DungeonFactory.Start();
		Client.Get().DungeonHasLoaded();
	}

	@Override
	public void Update() {
		EntityManager.Update();
	}

	@Override
	public void LoadContent() {
		EntityManager.LoadContent();
	}

	@Override
	public void Draw() {
		EntityManager.Draw();
	}
}

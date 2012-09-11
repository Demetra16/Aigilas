package aigilas.statuses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aigilas.creatures.CreatureAction;
import aigilas.creatures.ICreature;
import aigilas.creatures.StatBuff;
import aigilas.entities.Elements;

public class IStatus {
	protected List<CreatureAction> _prevents = new ArrayList<>();

	protected boolean _wasPassed = false;
	protected int _strength = 0;
	protected int _maxStrength = 100;
	protected boolean _isActive = true;
	protected ICreature _target;
	protected StatBuff _buff = null;
	protected boolean _buffMax = false;
	protected List<Elements> _blockedElements = new ArrayList<>();

	protected HashMap<StatusComponent, List<Status>> _passables = new HashMap<>();

	protected IStatus(ICreature target) {
		_strength = _maxStrength;
		_target = target;
		Setup();
	}

	public boolean IsActive() {
		return _isActive;
	}

	public boolean Prevents(CreatureAction action) {
		for (CreatureAction prevent : _prevents) {
			if (prevent == action) {
				return true;
			}
		}
		return false;
	}

	public boolean IsElementBlocked(Elements element) {
		for (Elements blocked : _blockedElements) {
			if (blocked == element) {
				return true;
			}
		}
		return false;
	}

	public void PassOn(ICreature target, StatusComponent componentType) {
		if (_passables.containsKey(componentType)) {
			for (Status contagion : _passables.get(componentType)) {
				StatusFactory.Apply(target, contagion);
			}
			_wasPassed = _passables.containsKey(componentType);
		}

	}

	protected void Add(Status statusId, StatusComponent componentType) {
		if (!_passables.containsKey(componentType)) {
			_passables.put(componentType, new ArrayList<Status>());
		}
		_passables.get(componentType).add(statusId);
	}

	public void Update() {
		if (_isActive) {
			_strength--;
			if (_strength <= 0) {
				Cleanup();
				_isActive = false;
			}
		}
	}

	public void Act() {

	}

	private void CycleBuff() {
		if (_buff != null) {
			_target.AddBuff(_buff, _buffMax);
		}
	}

	public void Setup() {
		CycleBuff();
	}

	public void Cleanup() {
		CycleBuff();
	}
}

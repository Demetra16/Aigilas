package aigilas.statuses.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatBuff;
import aigilas.creatures.StatType;
import aigilas.statuses.IStatus;

public class ManaUpStatus extends IStatus {
	public ManaUpStatus(ICreature target)

	{
		super(target);

		_buff = new StatBuff(StatType.MANA, 20f);
		Setup();
	}
}

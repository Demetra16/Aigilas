package aigilas.statuses.impl;

import aigilas.creatures.CreatureAction;
import aigilas.creatures.ICreature;
import aigilas.statuses.IStatus;

public class MuteStatus extends IStatus {
	public MuteStatus(ICreature target)

	{
		super(target);

		_prevents.add(CreatureAction.SkillUsage);
	}
}

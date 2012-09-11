package aigilas.statuses.impl;

import aigilas.creatures.CreatureAction;
import aigilas.creatures.ICreature;
import aigilas.statuses.IStatus;

public class BlindStatus extends IStatus {
	public BlindStatus(ICreature target)

	{
		super(target);

		_prevents.add(CreatureAction.WontHitNonTargets);
	}
}

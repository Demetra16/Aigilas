package aigilas.statuses.impl;

import aigilas.creatures.ICreature;
import aigilas.entities.Elements;
import aigilas.statuses.IStatus;

public class PreventMentalUsageStatus extends IStatus {
	public PreventMentalUsageStatus(ICreature target)

	{
		super(target);

		_blockedElements.add(Elements.MENTAL);
	}
}

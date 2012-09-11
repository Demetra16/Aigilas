package aigilas.statuses.impl;

import aigilas.creatures.ICreature;
import aigilas.entities.Elements;
import aigilas.statuses.IStatus;

public class PreventDarkUsageStatus extends IStatus {
	public PreventDarkUsageStatus(ICreature target)

	{
		super(target);

		_blockedElements.add(Elements.DARK);
	}
}

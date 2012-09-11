package aigilas.statuses.impl;

import aigilas.creatures.ICreature;
import aigilas.entities.Elements;
import aigilas.statuses.IStatus;

public class PreventLightUsageStatus extends IStatus {
	public PreventLightUsageStatus(ICreature target)

	{
		super(target);

		_blockedElements.add(Elements.LIGHT);
	}
}

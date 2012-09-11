package aigilas.strategies.impl;

import spx.bridge.ActorType;
import aigilas.creatures.ICreature;
import aigilas.strategies.IStrategy;

public class NullStrategy extends IStrategy {

	public NullStrategy(ICreature parent, ActorType... targetTypes)

	{
		super(parent, null);

		for (ActorType targetType : targetTypes) {
			_targets.AddTargetTypes(targetType);
		}
	}

	@Override
	public void Act() {

	}
}

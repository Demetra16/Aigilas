package aigilas.strategies.impl;

import spx.core.RNG;
import aigilas.creatures.ICreature;
import aigilas.strategies.IStrategy;
import aigilas.strategies.Strategy;

public class ConfusedStrategy extends IStrategy {
	public ConfusedStrategy(ICreature parent)

	{
		super(parent, Strategy.Confused);

	}

	@Override
	public void Act() {
		_parent.MoveIfPossible(RNG.Rand.nextInt(3) - 1, RNG.Rand.nextInt(3) - 1);
	}
}

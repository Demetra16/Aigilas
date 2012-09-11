package aigilas.strategies.impl;

import spx.bridge.ActorType;
import spx.core.Point2;
import spx.core.RNG;
import spx.entities.CoordVerifier;
import aigilas.creatures.ICreature;
import aigilas.strategies.IStrategy;
import aigilas.strategies.Strategy;

public class StraightLineRotateStrategy extends IStrategy {
	private Point2 _direction = new Point2(0, 1);

	public StraightLineRotateStrategy(ICreature parent, ActorType... targetTypes)

	{
		super(parent, Strategy.StraightLineRotate);

		for (ActorType targetType : targetTypes) {
			_targets.AddTargetTypes(targetType);
		}
	}

	private Point2 target = new Point2(0, 0);

	@Override
	public void Act() {
		_parent.MoveIfPossible(_direction.PosX, _direction.PosY);
		target.Reset(_direction.PosX + _parent.GetLocation().PosX, _direction.PosY + _parent.GetLocation().PosY);
		if (CoordVerifier.IsBlocked(target) && _parent.IsCooledDown()) {
			_direction.SetX(RNG.Rand.nextInt(3) - 1);
			_direction.SetY(RNG.Rand.nextInt(3) - 1);
		}
	}
}

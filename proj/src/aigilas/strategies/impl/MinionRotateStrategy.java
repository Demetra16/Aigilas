package aigilas.strategies.impl;

import spx.core.Point2;
import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.strategies.IStrategy;
import aigilas.strategies.Strategy;

public class MinionRotateStrategy extends IStrategy {
	public MinionRotateStrategy(ICreature parent)

	{
		super(parent, Strategy.MinionRotate);
		// TODO pass master into strategy to copy targets here.
		parent.SetSkillVector(new Point2(1, 0));
	}

	@Override
	public void Act() {
		if (_parent.IsCooledDown()) {
			_parent.SetSkillVector(_parent.GetSkillVector().RotateClockwise());
			_parent.UseActiveSkill();
			_parent.ApplyDamage(5, null, false);
			_parent.Set(StatType.MOVE_COOL_DOWN, 0);
		}
	}
}

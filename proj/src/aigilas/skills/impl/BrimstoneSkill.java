package aigilas.skills.impl;

import spx.core.Point2;
import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillFactory;
import aigilas.skills.SkillId;

public class BrimstoneSkill extends ISkill {
	private Point2 _direction = new Point2(0, 0);

	public BrimstoneSkill()

	{
		super(SkillId.ACID_NOZZLE, AnimationType.STATIONARY);

		AddCost(StatType.MANA, 10);

	}

	@Override
	public void Activate(ICreature source) {
		for (int ii = -1; ii < 2; ii++) {
			for (int jj = -1; jj < 2; jj++) {
				if (ii != 0 || jj != 0) {
					_direction.Reset(ii, jj);
					source.SetSkillVector(_direction);
					SkillFactory.Create(SkillId.FIREBALL).Activate(source);

				}

			}

		}

	}

}

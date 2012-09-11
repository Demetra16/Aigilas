package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;
import aigilas.statuses.Status;
import aigilas.statuses.StatusFactory;

public class DartSkill extends ISkill {
	public DartSkill()

	{
		super(SkillId.DART, AnimationType.RANGED);

		AddCost(StatType.MANA, 10);
		Add(Elements.DARK);

	}

	@Override
	public void Affect(ICreature target)

	{
		StatusFactory.Apply(target, Status.Poison);
		target.ApplyDamage(5, _source);

	}

}

package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;

public class AbsorbSkill extends ISkill {
	public AbsorbSkill()

	{
		super(SkillId.ABSORB, AnimationType.RANGED);

		Add(Elements.LIGHT);
		AddCost(StatType.MANA, 10);

	}

	@Override
	public void Affect(ICreature target)

	{
		target.ApplyDamage(10, _source);
		_source.ApplyDamage(-10);
		target.ApplyDamage(10, _source, true, StatType.MANA);
		_source.ApplyDamage(-10, _source, true, StatType.MANA);

	}

}

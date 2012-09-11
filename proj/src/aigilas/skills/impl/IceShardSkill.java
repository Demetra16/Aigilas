package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;

public class IceShardSkill extends ISkill {
	public IceShardSkill()

	{
		super(SkillId.ICE_SHARD, AnimationType.CLOUD);

		Add(Elements.WATER);
		AddCost(StatType.MANA, 0);

	}

	@Override
	public void Affect(ICreature target)

	{
		target.ApplyDamage(10, _source, true);

	}

}

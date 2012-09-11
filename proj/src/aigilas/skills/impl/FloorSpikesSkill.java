package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;

public class FloorSpikesSkill extends ISkill {
	public FloorSpikesSkill()

	{
		super(SkillId.FLOOR_SPIKES, AnimationType.STATIONARY, Float.MAX_VALUE, true);

		AddCost(StatType.MANA, 20);
		Add(Elements.EARTH);

	}

	@Override
	public void Affect(ICreature target)

	{
		target.ApplyDamage(80, _source);

	}

}

package aigilas.skills.impl;

import spx.entities.IEntity;
import aigilas.creatures.CreatureFactory;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;

public class VaporImplantSkill extends ISkill {
	public VaporImplantSkill()

	{
		super(SkillId.VAPOR_IMPLANT, AnimationType.RANGED);

		AddCost(StatType.MANA, 10);
		Add(Elements.PHYSICAL, Elements.AIR);

	}

	@Override
	public void Affect(IEntity target)

	{
		CreatureFactory.CreateMinion(SkillId.VAPOR_CLOUD, _source, null, target.GetLocation());

	}

}

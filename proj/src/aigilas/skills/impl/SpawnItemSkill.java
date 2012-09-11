package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.items.ItemFactory;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;

public class SpawnItemSkill extends ISkill {
	public SpawnItemSkill()

	{
		super(SkillId.SPAWN_ITEM, AnimationType.SELF);

		Add(Elements.EARTH);
		AddCost(StatType.MANA, 10);

	}

	@Override
	public void Activate(ICreature source) {
		super.Activate(source);
		ItemFactory.CreateRandomPlain(source.GetLocation());

	}

}

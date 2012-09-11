package aigilas.skills.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.skills.AnimationType;
import aigilas.skills.ISkill;
import aigilas.skills.SkillId;
import aigilas.statuses.Status;

public class ColdShoulderSkill extends ISkill {
	public ColdShoulderSkill()

	{
		super(SkillId.COLD_SHOULDER, AnimationType.SELF);

		Add(Elements.FIRE);
		AddCost(StatType.MANA, 10);

	}

	@Override
	public void Activate(ICreature source) {
		super.Activate(source);
		ApplyToPlayers(Status.ColdShoulder);

	}

}

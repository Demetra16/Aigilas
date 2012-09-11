package aigilas.creatures;

import spx.bridge.ActorType;
import aigilas.entities.Elements;
import aigilas.management.SpriteType;
import aigilas.skills.SkillId;

public class Gluttony extends AbstractCreature {
	public Gluttony() {
		super(ActorType.GLUTTONY, SpriteType.GLUTTONY);
		Compose(Elements.MENTAL);
		Strengths(StatType.STRENGTH, StatType.STRENGTH);
		Add(SkillId.PLAGUE);
	}
}

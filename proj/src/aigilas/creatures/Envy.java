package aigilas.creatures;

import spx.bridge.ActorType;
import aigilas.entities.Elements;
import aigilas.management.SpriteType;
import aigilas.skills.SkillId;

public class Envy extends AbstractCreature {
	public Envy() {
		super(ActorType.ENVY, SpriteType.ENVY);
		Compose(Elements.WATER);
		Strengths(StatType.STRENGTH, StatType.STRENGTH);
		Add(SkillId.HYPOTHERMIA);
	}
}

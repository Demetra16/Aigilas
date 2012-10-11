package aigilas.creatures.impl;

import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.management.SpriteType;
import aigilas.skills.SkillId;
import sps.bridge.ActorType;

public class Sloth extends BaseEnemy {
    public Sloth() {
        super(ActorType.SLOTH, SpriteType.SLOTH);
        Compose(Elements.EARTH);
        Strengths(StatType.STRENGTH, StatType.STRENGTH);
        add(SkillId.SERPENT_SUPPER);
    }
}
package aigilas.creatures.impl;

import aigilas.creatures.StatType;
import aigilas.entities.Elements;
import aigilas.management.SpriteType;
import aigilas.skills.SkillId;
import sps.bridge.ActorType;

public class Greed extends BaseEnemy {
    public Greed() {
        super(ActorType.GREED, SpriteType.GREED);
        Compose(Elements.AIR);
        Strengths(StatType.STRENGTH, StatType.STRENGTH);
        add(SkillId.BOIL);
    }
}
package aigilas.skills.behaviors;

import aigilas.creatures.BaseCreature;
import aigilas.management.SpriteType;
import aigilas.skills.AnimationType;
import aigilas.skills.BaseSkill;
import spx.core.Point2;

public class RotateBehavior extends SkillBehavior {
    public RotateBehavior(SpriteType effectGraphic, BaseSkill parentSkill) {
        super(effectGraphic, AnimationType.ROTATE, parentSkill);
    }

    @Override
    public void activate(BaseCreature target) {
        _sideEffects.Generate(target.getLocation(), new Point2(0, 0), target);
    }
}

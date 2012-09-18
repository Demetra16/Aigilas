package aigilas.skills;

import aigilas.creatures.BaseCreature;
import aigilas.entities.SkillEffect;
import aigilas.management.SpriteType;
import spx.core.Point2;
import spx.entities.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class SideEffects {
    protected final BaseSkill _parent;

    protected final AnimationType _animation;
    protected final List<SkillEffect> _effectGraphics = new ArrayList<>();
    protected SpriteType _effectSprite = SpriteType.SKILL_EFFECT;
    protected final float _effectStrength;
    protected boolean _isPersistent = false;

    public SideEffects(SpriteType effectGraphic, AnimationType animation, BaseSkill parent) {
        _parent = parent;
        _effectStrength = parent.getStrength();
        _effectSprite = effectGraphic;
        _animation = animation;
    }

    public void Generate(Point2 gridLocation, Point2 velocity, BaseCreature source) {
        SkillEffect effect = new SkillEffect(gridLocation, velocity, source, _parent);
        _effectGraphics.add(effect);
        EntityManager.addObject(effect);
    }

    public SkillEffect getFirstGraphic() {
        if (_effectGraphics.size() > 0)
            return _effectGraphics.get(0);
        return null;
    }

    public SpriteType getSpriteType() {
        return _effectSprite;
    }

    public AnimationType getAnimationType() {
        return _animation;
    }
}

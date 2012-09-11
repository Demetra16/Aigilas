package aigilas.skills.animations;

import spx.core.Point2;
import aigilas.creatures.ICreature;
import aigilas.entities.SkillEffect;

public class RangedAnimation extends SkillAnimation {
	@Override
	public void Animate(SkillEffect skill, ICreature source, Point2 velocity) {
		if (!skill.Move(velocity.X, velocity.Y)) {
			skill.Cleanup(skill);
		}
	}
}

package aigilas.skills.animations;

import spx.core.Point2;
import aigilas.creatures.ICreature;
import aigilas.entities.SkillEffect;

public class SelfAnimation extends SkillAnimation {
	@Override
	public void Animate(SkillEffect skill, ICreature source, Point2 velocity) {
		skill.UpdateLocation(source.GetLocation());
	}
}

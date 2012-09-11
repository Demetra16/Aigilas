package aigilas.classes;

import aigilas.creatures.Stats;
import aigilas.skills.SkillId;

public class WrathAcolyte extends CreatureClass {
	public WrathAcolyte() {
		super(new Stats(5, 10, 1, 5, 0, 0, 1, 0, 0, 0));
		Add(1, SkillId.STRENGTH_UP);
		Add(1, SkillId.MANA_UP);
		Add(1, SkillId.FLAME_HAMMER);
		Add(2, SkillId.GUSH);
		Add(3, SkillId.SOUL_CRUSH);
		Add(4, SkillId.COMBUST);
		Add(5, SkillId.HORRIFY);
	}
}

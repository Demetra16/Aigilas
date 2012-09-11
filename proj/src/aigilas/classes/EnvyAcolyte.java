package aigilas.classes;

import aigilas.creatures.Stats;
import aigilas.skills.SkillId;

public class EnvyAcolyte extends CreatureClass {
	public EnvyAcolyte() {
		super(new Stats(5, 10, 1, 5, 0, 0, 1, 0, 0, 0));
		Add(1, SkillId.CONFUSION);
		Add(2, SkillId.WEAK_KNEEES);
		Add(3, SkillId.VENOM_FIST);
		Add(4, SkillId.ABSORB);
		Add(5, SkillId.MUTINY);
	}
}

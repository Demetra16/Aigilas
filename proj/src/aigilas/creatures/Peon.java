package aigilas.creatures;

import spx.bridge.ActorType;
import aigilas.entities.Elements;

public class Peon extends AbstractCreature {
	public Peon() {
		super(ActorType.PEON);
		Weaknesses(StatType.STRENGTH, StatType.HEALTH, StatType.MOVE_COOL_DOWN);
		Compose(Elements.EARTH);
	}
}

package aigilas.creatures;

import spx.bridge.ActorType;
import aigilas.entities.Elements;
import aigilas.management.SpriteType;
import aigilas.strategies.Strategy;
import aigilas.strategies.StrategyFactory;

public class Serpent extends AbstractCreature {
	public Serpent() {
		super(ActorType.SERPENT, SpriteType.SLOTH);
		Compose(Elements.EARTH);
		Strengths(StatType.HEALTH, StatType.HEALTH, StatType.HEALTH);
		_strategy = StrategyFactory.Create(Strategy.ConfusedAndDying, this);
	}
}

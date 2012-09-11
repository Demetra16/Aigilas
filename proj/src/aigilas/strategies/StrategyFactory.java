package aigilas.strategies;

import spx.bridge.ActorType;
import aigilas.creatures.ICreature;
import aigilas.strategies.impl.AttackSelfStrategy;
import aigilas.strategies.impl.AttackStrategy;
import aigilas.strategies.impl.ConfusedAndDyingStrategy;
import aigilas.strategies.impl.ConfusedStrategy;
import aigilas.strategies.impl.ControlledByPlayer;
import aigilas.strategies.impl.FleeStrategy;
import aigilas.strategies.impl.MinionCloudStrategy;
import aigilas.strategies.impl.MinionFireStrategy;
import aigilas.strategies.impl.MinionOneUseStrategy;
import aigilas.strategies.impl.MinionRotateStrategy;
import aigilas.strategies.impl.NullStrategy;
import aigilas.strategies.impl.StraightLineRotateStrategy;
import aigilas.strategies.impl.StraightLineStrategy;
import aigilas.strategies.impl.TestBotStrategy;

public class StrategyFactory {
	public static IStrategy Create(Strategy strategy, ICreature target, ActorType... actorTypes) {
		if (strategy == null) {
			return new NullStrategy(target);
		}
		switch (strategy) {
			case Attack:
				return new AttackStrategy(target, ActorType.PLAYER);
			case AttackSelf:
				return new AttackSelfStrategy(target);
			case Confused:
				return new ConfusedStrategy(target);
			case ConfusedAndDying:
				return new ConfusedAndDyingStrategy(target);
			case ControlledByPlayer:
				return new ControlledByPlayer(target);
			case Flee:
				return new FleeStrategy(target, ActorType.PLAYER);
			case MinionCloud:
				return new MinionCloudStrategy(target);
			case MinionExplode:
				return new MinionOneUseStrategy(target);
			case MinionFire:
				return new MinionFireStrategy(target);
			case MinionOneUse:
				return new MinionOneUseStrategy(target);
			case MinionRotate:
				return new MinionRotateStrategy(target);
			case Mutiny:
				return new AttackStrategy(target, ActorType.NONPLAYER);
			case StraightLineRotate:
				return new StraightLineRotateStrategy(target);
			case StraightLine:
				return new StraightLineStrategy(target);
			case TestBot:
				return new TestBotStrategy(target);
			default:
				try {
					throw new Exception("An undefined strategy was passed into the strategy factory: " + strategy);
				}
				catch (Exception e) {

					e.printStackTrace();
				}
				return null;
		}
	}
}

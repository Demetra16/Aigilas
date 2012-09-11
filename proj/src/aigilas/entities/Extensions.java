package aigilas.entities;

import spx.bridge.EntityType;
import spx.entities.IEntity;
import aigilas.creatures.ICreature;

public class Extensions {
	public static ICreature IsCreature(IEntity entity) {
		if (entity.GetEntityType() == EntityType.ACTOR) {
			return (ICreature) entity;
		}
		return null;
	}
}

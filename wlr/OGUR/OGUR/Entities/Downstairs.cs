﻿using OGUR.Creatures;
using OGUR.Dungeons;
using SPX.Core;
using SPX.Entities;
using SPX.Sprites;

namespace OGUR.Entities
{
    public class Downstairs : Entity
    {
        public Downstairs(Point2 location)
        {
            Initialize(location, SpriteType.DOWNSTAIRS, EntityType.DOWNSTAIRS,ZDepth.Stairs);
        }
        private int GetTargetLocation()
        {
            return Location.Depths;
        }
        private ICreature player;
        public override void Update()
        {
            player = EntityManager.GetTouchingPlayer(this);
            if (player != null)
            {
                if (player.IsInteracting())
                {
                    player.PerformInteraction();
                    DungeonFactory.GetNextFloor(GetTargetLocation());

                }
            }
        }
    }
}
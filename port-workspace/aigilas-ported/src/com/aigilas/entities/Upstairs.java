package com.aigilas.entities;
    public class Upstairs  extends  Entity
    {
        public Upstairs(Point2 location)
        {
            Initialize(location, SpriteType.UPSTAIRS, com.aigilas.EntityType.UPSTAIRS,com.aigilas.Depth.Stairs);
        }

        ICreature player;
@Override
        {
            player = (Player)EntityManager.GetTouchingCreature(this);
            if(player!=null)
            {
                if (player.IsInteracting())
                {
                    player.PerformInteraction();
                    try {
                }    
            }
        }
    }
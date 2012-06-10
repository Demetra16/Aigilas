﻿using SPX.States;
using SPX.Entities;
using Aigilas.Creatures;
using Aigilas.Dungeons;
using SPX.Core;
using System;

namespace Aigilas.States
{
    public class GameplayState : State
    {
        public GameplayState()
        {
            EntityManager.Reset();
            CreatureFactory.ResetPlayerCount();
            DungeonFactory.Start();
            Console.WriteLine(Input.GetPlayerCount());
        }
        public void Update()
        {
            EntityManager.Update();
        }
        public void LoadContent()
        {
            EntityManager.LoadContent();
        }
        public void Draw()
        {
            EntityManager.Draw();
        }
    }
}
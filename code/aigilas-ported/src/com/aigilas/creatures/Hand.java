package com.aigilas.creatures;
public     class Hand extends  AbstractCreature
    {
        public Hand(){
            Strengths(StatType.STRENGTH, StatType.STRENGTH);
            _isBlocking = false;
            _strategy = StrategyFactory.Create(Strategy.StraightLine, this);
        }
    }
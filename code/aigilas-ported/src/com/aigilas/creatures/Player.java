package com.aigilas.creatures;
    public class Player  extends  AbstractCreature
    {
        private static List<Color> __colors = Arrays.asList(Color.Red,Color.Green,Color.Blue,Color.White);
        public Player(int playerIndex){
            _graphic.SetColor(__colors.get(_playerIndex));
            _strategy = StrategyFactory.Create(Strategy.ControlledByPlayer, this);
            _baseStats = new Stats(100f, 100f, 1f, 10f, 11f, 10f, 35f, 50f, 6.0f, 6, 1);
            _maxStats = new Stats(_baseStats);
            AssignGod(God.Get(GodId.GLUTTONY));
            Compose(Elements.PHYSICAL);
        }
    }
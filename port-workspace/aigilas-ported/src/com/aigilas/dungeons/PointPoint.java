package com.aigilas.dungeons;
    class PointPoint
    {
        public int X;
        public int Y;
        private boolean _isHorizontal;

        public PointPoint(int x, int y, boolean destroyHorizontal)
        {
            Construct(x,y,destroyHorizontal);
        }
        public boolean isHorizontal()
        {
            return _isHorizontal;
        }
    }
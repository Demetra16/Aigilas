package com.aigilas.dungeons;import com.xna.wrapper.*;import java.util.*;
    class PointPoint
    {
        public int X;
        public int Y;
        private boolean _isHorizontal;

        public PointPoint(int x, int y, boolean destroyHorizontal)
        {
            Construct(x,y,destroyHorizontal);
        }        public PointPoint(int x, int y)        {            Construct(x,y,false);        }        private void Construct(int x, int y, boolean destroyHorizontal)        {        	X = x;            Y = y;            _isHorizontal = destroyHorizontal;        }        
        public boolean isHorizontal()
        {
            return _isHorizontal;
        }
    }

package com.aigilas.dungeons;
    public class Room
    {
        public int Height, Width, X, Y, BottomSide, RightSide;
        public Point2 Center;
        public List<Point2> Corners = new ArrayList<Point2>();

        public Room(int height, int width, int x, int y)
        {
            Height = height;
            Width = width;
            X = x;
            Y = y;
            BottomSide = Y + Height;
            RightSide = X + Width;
            Corners.add(new Point2(X, Y));
            Corners.add(new Point2(RightSide, Y));
            Corners.add(new Point2(RightSide, BottomSide));
            Corners.add(new Point2(X, BottomSide));
            Center = new Point2(RightSide/2, BottomSide/2);
        }

        public boolean IsBad()
        {
            if (BottomSide > DungeonFactory.BlocksHigh)
            {
                return true;
            }
            if (RightSide > DungeonFactory.BlocksWide)
            {
                return true;
            }
            return false;
        }

        public boolean Collides(Room target)
            if (target.IsPointInsideBoundingBox(Center))
            {
                return true;
            }
            return IsPointInsideBoundingBox(target.Center);
        }

        public boolean IsPointInsideBoundingBox(Point2 target)
            if (target.X > X && target.Y > Y && target.X < RightSide && target.Y < BottomSide)
            {
                return true;
            }
            return false;
        }
    }
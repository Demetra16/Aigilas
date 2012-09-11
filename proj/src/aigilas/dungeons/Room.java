package aigilas.dungeons;

import java.util.ArrayList;
import java.util.List;

import spx.core.Point2;
import spx.core.Settings;

public class Room {
	public int Height, Width, X, Y, BottomSide, RightSide;
	public Point2 Center;
	public List<Point2> Corners = new ArrayList<Point2>();

	public Room(int height, int width, int x, int y) {
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
		Center = new Point2(RightSide / 2, BottomSide / 2);
	}

	public boolean IsBad() {
		if (BottomSide > Settings.Get().tileMapHeight) {
			return true;
		}
		if (RightSide > Settings.Get().tileMapWidth) {
			return true;
		}
		return false;
	}

	public boolean Collides(Room target) {
		for (Point2 corner : target.Corners) {
			if (IsPointInsideBoundingBox(corner)) {
				return true;
			}
		}
		for (Point2 corner : Corners) {
			if (target.IsPointInsideBoundingBox(corner)) {
				return true;
			}
		}
		if (target.IsPointInsideBoundingBox(Center)) {
			return true;
		}
		return IsPointInsideBoundingBox(target.Center);
	}

	public boolean IsPointInsideBoundingBox(Point2 target) {
		if (target.X > X && target.Y > Y && target.X < RightSide && target.Y < BottomSide) {
			return true;
		}
		return false;
	}
}

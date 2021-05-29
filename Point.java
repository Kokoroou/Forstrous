package enemy;

import java.util.ArrayList;
import java.lang.Math;

public class Point {
	protected int cost;
	protected Point cameFrom;
	protected Point next;
	protected ArrayList<Point> adjacent = new ArrayList<Point>();
	protected int MapX, MapY;
	public Point(int x, int y) {
		this.MapX = x; 
		this.MapY = y;
	}
	
	public int getX() {
		return MapX;
	}

	public void setX(int x) {
		this.MapX = x;
	}

	public int getY() {
		return MapY;
	}

	public void setY(int y) {
		this.MapY = y;
	}

	protected double distance(Point a) {
		return Math.sqrt((a.MapX - this.MapX)*(a.MapX - this.MapX) + (a.MapY - this.MapY)*(a.MapY - this.MapY));
	}
	
	protected int heuristic(Point a) {
		return Math.abs(a.MapX - this.MapX) + Math.abs(a.MapY - this.MapY);
	}
	
	protected void addadj() {
	if (arr[x][y+1] == 0) adjacent.add(new Point(x, y+1));
	if (arr[x+1][y] == 0) adjacent.add(new Point(x+1, y));
	if (arr[x][y-1] == 0) adjacent.add(new Point(x, y-1));
	if (arr[x-1][y] == 0) adjacent.add(new Point(x-1, y));
	}
}

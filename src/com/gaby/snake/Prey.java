package com.gaby.snake;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

//need constructors?
//what happens when it gets eaten?

public abstract class Prey {

	private int direction;
	private Point location;
	

	
	public Point getLocation() {
		return location;

	}
	
	public void setLocation(Point location) {
		this.location = location;

	}
	
	public int getDirection() {
	return direction;
}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void Move() {

	}

	public void draw(GC gc) {

}
	

	public void incX() {
		location.x++;
	}

	public void incY() {
		location.y++;
	}

	public void decX() {
		location.x--;
	}

	public void decY() {
		location.y--;
	}
	
}



package com.gaby.snake;

import org.eclipse.swt.graphics.Point;

public class SnakeLocation {

	
	private Point location;
	
	public SnakeLocation(int y, int x) {
		super();
		location = new Point(x, y);
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
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
	
	//todo: add code to determine if snake is at margins
}

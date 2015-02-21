package com.gaby.snake;

import org.eclipse.swt.graphics.Point;

public class SnakeLocation {

	//private int y;
	//private int x;
	private Point location;
	
	public SnakeLocation(int y, int x) {
		super();
		location = new Point(x, y);
	}

	public synchronized Point getLocation() {
		return location;
	}

	public synchronized void setLocation(Point location) {
		this.location = location;
	}

	public synchronized void incX() {
		location.x++;
	}
	
	public synchronized void incY() {
		location.y++;
	}
	
	public synchronized void decX() {
		location.x--;
	}
	
	public synchronized void decY() {
		location.y--;
	}
	
	//todo: add code to determine if snake is at margins
}

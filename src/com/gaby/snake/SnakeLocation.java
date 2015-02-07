package com.gaby.snake;

import org.eclipse.swt.graphics.Point;

public class SnakeLocation {

	private int y;
	private int x;
	
	public SnakeLocation(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	synchronized public int  getY() {
		return y;
	}

	synchronized public void  setY(int y) {
		this.y = y;
	}

	synchronized public int getX() {
		return x;
	}

	synchronized public void setX(int x) {
		this.x = x;
	}
	
	synchronized public Point getXY(){
		return new Point(x,y);
	}
	
	synchronized public void incX(){
		x++;
	}
	
	synchronized public void incY(){
		y++;
	}
	
	synchronized public void decX(){
		x--;
	}
	
	synchronized public void decY(){
		y--;
	}
	
}

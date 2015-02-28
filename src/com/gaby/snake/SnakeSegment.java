package com.gaby.snake;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class SnakeSegment {

	private Image segment;
	private Point loc;
	private int height;
	private int width;
	
	public Image getSegment() {
		return segment;
	}
	public void setSegment(Image segment) {
		this.segment = segment;
	}
	
	public SnakeSegment(int height, int width, Image segment) {
		super();
		this.segment = segment;
		this.height = height;
		this.width = width;
	}
	
	
}

package com.gaby.snake;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

public class SnakeHead {
	private Image upSnakehead;
	private Image downSnakehead;
	private Image leftSnakehead;
	private Image rightSnakehead;
	private Rectangle rect;

	private int x;
	private int y;
	private int direction;
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;

	public SnakeHead(int x, int y, Device display) {
		super();
		this.x = x;
		this.y = y;
		direction = UP;
		rect = SnakeDriver.rect;

		upSnakehead = new Image(display,
				"C:/workspace/Snake/images/upsnakehead.gif");
		downSnakehead = new Image(display,
				"C:/workspace/Snake/images/downsnakehead.gif");
		leftSnakehead = new Image(display,
				"C:/workspace/Snake/images/leftsnakehead.gif");
		rightSnakehead = new Image(display,
				"C:/workspace/Snake/images/rightsnakehead.gif");
	}

	public void Move() {
		switch (direction) {
		case UP:
			y--;
			break;
		case DOWN:
			y++;
			break;
		case LEFT:
			if (x == 0) {
				direction = RIGHT;
			} else {
				x--;
			}
			;
			break;
		case RIGHT:
		default:
			if (x == rect.width - 80) {
				direction = LEFT;
			} else {
				x++;
			}
			;
			break;
		}
	}

	public void setXY(MouseEvent e) {
		if (e.x < rect.width/3)
		//&& e.y>rect.height/3
		//&& e.y<rect.height*(2/3))
		{
			direction = LEFT;
		}

		else if (e.x >= rect.width*(2/3))
		//&& e.y>rect.height/3
		//&& e.y<rect.height*(2/3))
		{
			direction = RIGHT;
		}

		else if (e.y < rect.height/3)
		// && e.x>rect.width-((2/3)*Snake.rect.width)
		// && e.x<Snake.rect.width-((1/3)*Snake.rect.width ))
		{
			direction = UP;
		}

		else if (e.y > rect.height*(2/3))
		// && e.x>rect.width-((2/3)*Snake.rect.width)
		// && e.x<Snake.rect.width-((1/3)*Snake.rect.width ))
		{
			direction = DOWN;
		}


	}


	public void draw(PaintEvent e) 
	{
		GC gc = e.gc;

		switch (direction) {
		case UP:
			gc.drawImage(upSnakehead, x, y);
			break;
		case DOWN:
			gc.drawImage(downSnakehead, x, y);
			break;
		case LEFT:
			gc.drawImage(leftSnakehead, x, y);
			break;
		case RIGHT:
		default:
			gc.drawImage(rightSnakehead, x, y);
			break;
		}

	}

	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
}

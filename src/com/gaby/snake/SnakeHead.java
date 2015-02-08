package com.gaby.snake;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class SnakeHead {
	private Image upSnakehead;
	private Image downSnakehead;
	private Image leftSnakehead;
	private Image rightSnakehead;
	private Rectangle rect;
	private SnakeLocation snakelocation;
	private int direction;
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;

	public SnakeHead(int x, int y, Device display) {
		super();
		snakelocation = new SnakeLocation(x,y);
		direction = UP;
		rect = SnakeDriver.rect;

		upSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/upsnakehead.gif");
		downSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/downsnakehead.gif");
		leftSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/leftsnakehead.gif");
		rightSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/rightsnakehead.gif");
	}

	public synchronized void  Move() {
		switch (direction) {
		case UP:
			if (snakelocation.getY() == 0) {
				direction = DOWN;
			} else {
				snakelocation.decY();
			}
			;
		case DOWN:
			if (snakelocation.getY() == rect.height) {
				direction = UP;
			} else {
				snakelocation.incY();
			}
			;
		case LEFT:
			if (snakelocation.getX() == 0) {
				direction = RIGHT;
			} else {
				snakelocation.decX();
			}
			;
			break;
		case RIGHT:
		default:
			if (snakelocation.getX() == rect.width - 80) {
				direction = LEFT;
			} else {
				snakelocation.incX();
			}
			;
			break;
		}
	}

	public void  setXY(MouseEvent e) {
		if (e.x < rect.width/3)
		//&& e.y>rect.height/3
		//&& e.y<rect.height*(2/3))
		{
			if (direction < 3){
				direction++;
				
			}
				
			else
				direction = 0;
		}

		else if (e.x >= rect.width*(2/3))
		//&& e.y>rect.height/3
		//&& e.y<rect.height*(2/3))
		{
			if (direction < 3) {
				direction--;
			} else
				direction = 0;
			//direction = RIGHT;
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
		Point p = snakelocation.getXY();
		switch (direction) {
		
		case UP:
			gc.drawImage(upSnakehead, p.x,p.y);
			break;
		case DOWN:
			gc.drawImage(downSnakehead, p.x,p.y);
			break;
		case LEFT:
			gc.drawImage(leftSnakehead, p.x,p.y);
			break;
		case RIGHT:
		default:
			gc.drawImage(rightSnakehead, p.x,p.y);
			break;
		}

	}


}

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
<<<<<<< HEAD
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
=======
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int STOP = 4;
	public static Buttons buttons;
>>>>>>> 8a185ebfb6fcb694e3b372a5faceb1f7e2880156

	public SnakeHead(int x, int y, Device display) {
		super();
		snakelocation = new SnakeLocation(x, y);
		direction = UP;
		rect = SnakeDriver.rect;
		buttons = new Buttons(rect);

		upSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/upsnakehead.gif");
		downSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/downsnakehead.gif");
		leftSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/leftsnakehead.gif");
		rightSnakehead = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/rightsnakehead.gif");
	}

	public synchronized void checkDirection(MouseEvent e) {
		int button = buttons.getButton(e.x, e.y);
		switch (direction) {
		case UP:
<<<<<<< HEAD
=======
		case DOWN:
			switch (button) {
			case Buttons.UP:
			case Buttons.DOWN:
				break;
			case Buttons.LEFT:
				direction = LEFT;
				break;
			case Buttons.RIGHT:
				direction = RIGHT;
				break;
			}
			break;

		case LEFT:
		case RIGHT:
			switch (button) {
			case Buttons.UP:
				direction = UP;
				break;
			case Buttons.DOWN:
				direction = DOWN;
				break;
			case Buttons.LEFT:
			case Buttons.RIGHT:
				break;
			}

			break;

		}

	}

	public synchronized void Move() {

		switch (direction) {
		case UP:
>>>>>>> 8a185ebfb6fcb694e3b372a5faceb1f7e2880156
			if (snakelocation.getY() == 0) {
				direction = DOWN;
			} else {

				snakelocation.decY();
			}
			break;

		case DOWN:
			if (snakelocation.getY() == rect.height) {
				direction = UP;
			} else {
				snakelocation.incY();
			}

			break;
		case LEFT:
			if (snakelocation.getX() == 0) {
				direction = DOWN;
			} else {
				snakelocation.decX();
			}

			break;
		case RIGHT:
			if (snakelocation.getX() == rect.height) {
				direction = UP;
			} else {
				snakelocation.incX();
			}
			break;
		}
	}

<<<<<<< HEAD
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
=======
	public void draw(PaintEvent e) {
>>>>>>> 8a185ebfb6fcb694e3b372a5faceb1f7e2880156
		GC gc = e.gc;
		Point p = snakelocation.getXY();
		switch (direction) {

		case UP:
			gc.drawImage(upSnakehead, p.x, p.y);
			break;
		case DOWN:
			gc.drawImage(downSnakehead, p.x, p.y);
			break;
		case LEFT:
			gc.drawImage(leftSnakehead, p.x, p.y);
			break;
		case RIGHT:
		default:
			gc.drawImage(rightSnakehead, p.x, p.y);
			break;
		}

	}

}

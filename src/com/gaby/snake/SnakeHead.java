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
	public SnakeLocation snakelocation;
	private int direction;


	public static final int UP = 0;

	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	public static final int STOP = 4;
	public static Buttons buttons;

	// public Point location;

	public SnakeHead(int x, int y, Device display) {
		super();

		// location = new Point(x, y);
		snakelocation = new SnakeLocation(x, y);
		direction = UP;
		rect = SnakeDriver.rect;
		buttons = new Buttons(rect);

		upSnakehead = new Image(display,
				"images/upsnakehead.gif");
		downSnakehead = new Image(display,
				"images/downsnakehead.gif");
		leftSnakehead = new Image(display,
				"images/leftsnakehead.gif");
		rightSnakehead = new Image(display,
				"images/rightsnakehead.gif");

	}

	public synchronized void checkDirection(MouseEvent e) {
		int button = buttons.getButton(e.x, e.y);
		switch (direction) {
		case UP:

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

		Point loc = snakelocation.getLocation();
		switch (direction) {
		case UP:

			if (loc.y == 0) {
				direction = RIGHT;
			} else {

				snakelocation.decY();
			}
			break;

		case DOWN:
			if (loc.y == rect.height) {
				direction = LEFT;
			} else {
				snakelocation.incY();
			}

			break;
		case LEFT:
			if (loc.x == 0) {
				direction = UP;
			} else {
				snakelocation.decX();
			}

			break;
		case RIGHT:
			if (loc.x == rect.width) {
				direction = DOWN;
			} else {
				snakelocation.incX();
			}
			break;
		}
	}

	public void setXY(MouseEvent e) {
		if (e.x < rect.width / 3)
		// && e.y>rect.height/3
		// && e.y<rect.height*(2/3))
		{
			if (direction < 3) {
				direction++;

			}

			else
				direction = 0;
		}

		else if (e.x >= rect.width * (2 / 3))
		// && e.y>rect.height/3
		// && e.y<rect.height*(2/3))
		{
			if (direction < 3) {
				direction--;
			} else
				direction = 0;
			// direction = RIGHT;
		}

		else if (e.y < rect.height / 3)
		// && e.x>rect.width-((2/3)*Snake.rect.width)
		// && e.x<Snake.rect.width-((1/3)*Snake.rect.width ))
		{
			direction = UP;
		}

		else if (e.y > rect.height * (2 / 3))
		// && e.x>rect.width-((2/3)*Snake.rect.width)
		// && e.x<Snake.rect.width-((1/3)*Snake.rect.width ))
		{
			direction = DOWN;
		}

	}

//	public Image draw(PaintEvent e) {
//
//		GC gc = e.gc;
//		Point p = snakelocation.getLocation();
//		switch (direction) {
//
//		case UP:
//			gc.drawImage(upSnakehead, p.x, p.y);
//			return upSnakehead;
//		case DOWN:
//			gc.drawImage(downSnakehead, p.x, p.y);
//			return downSnakehead;
//		case LEFT:
//			gc.drawImage(leftSnakehead, p.x, p.y);
//			return leftSnakehead;
//		case RIGHT:
//		default:
//			gc.drawImage(rightSnakehead, p.x, p.y);
//			return rightSnakehead;
//		}
//
//	}
	
	public void draw(GC gc) {

		Point p = snakelocation.getLocation();
		switch (direction) {

		case UP:
			gc.drawImage(upSnakehead, p.x, p.y);
			//return upSnakehead;
			break;
		case DOWN:
			gc.drawImage(downSnakehead, p.x, p.y);
			//return downSnakehead;
			break;
		case LEFT:
			gc.drawImage(leftSnakehead, p.x, p.y);
			//return leftSnakehead;
			break;
		case RIGHT:
		default:
			gc.drawImage(rightSnakehead, p.x, p.y);
			//return rightSnakehead;
			break;
		}

	}

	public int getDirection() {
		return direction;
	}
}

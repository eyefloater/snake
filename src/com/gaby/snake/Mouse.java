package com.gaby.snake;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.gdip.Rect;
import org.eclipse.swt.widgets.Display;

import java.util.Random;

//need a constructor??
//how to automate movement?
//what happens to it when eaten?

public class Mouse extends Prey {

	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int STOP = 4;

	private static Image upmouse;
	private static Image downmouse;
	private static Image leftmouse;
	private static Image rightmouse;
	private static Rectangle mouseRect;
	private static Rectangle rect;

	private Random rand;

	public Mouse() {
		super();
		rand = new Random();
		setLocation(new Point(0, 0));
		setLocation();
		
		setDirection(UP);
		Display display = Display.getCurrent();
		

		if (upmouse == null) {
			upmouse = new Image(display, "images/upmouse.gif");
			mouseRect = upmouse.getBounds();
		}
		if (downmouse == null) {
			downmouse = new Image(display, "images/downmouse.gif");
		}
		if (leftmouse == null) {
			leftmouse = new Image(display, "images/leftmouse.gif");
		}
		if (rightmouse == null) {
			rightmouse = new Image(display, "images/rightmouse.gif");
		}

	}


	public void setLocation() {
		rect = SnakeDriver.rect;
		setLocation(new Point(rand.nextInt(rect.width), rand.nextInt(rect.height)));
	}


	public void Move() {
		Point location = getLocation();
		Rectangle rect = SnakeDriver.rect;
		switch (getDirection()) {
		case UP:

			if (location.y <= 0) {
				setDirection(RIGHT);
			} else {

				decY();
			}
			break;

		case DOWN:
			if (location.y >= rect.height - mouseRect.height) {
				setDirection(LEFT);
			} else {
				incY();
			}

			break;
		case LEFT:
			if (location.x <= 0) {
				setDirection(UP);
			} else {
				decX();
			}

			break;
		case RIGHT:
			if (location.x >= rect.width - mouseRect.width) {
				setDirection(DOWN);
			} else {
				incX();
			}
			break;
		}
	}

	public void draw(GC gc) {
		Point p = getLocation();
		switch (getDirection()) {

		case UP:
			gc.drawImage(upmouse, p.x, p.y);
			break;
		case DOWN:
			gc.drawImage(downmouse, p.x, p.y);
			break;
		case LEFT:
			gc.drawImage(leftmouse, p.x, p.y);
			break;
		case RIGHT:
		default:
			gc.drawImage(rightmouse, p.x, p.y);
			break;
		}

	}



}
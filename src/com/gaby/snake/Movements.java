package com.gaby.snake;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

class Movements extends Thread {

	private SnakeHead turnsnake;
	//private int mouseX;
	//private int mouseY;
	private Canvas canvas;

	public Movements(Canvas canvas, SnakeHead turnsnake) {
		super("movethread");
		this.canvas = canvas;
		this.turnsnake = turnsnake;
	}

//	public void setMouse(int x, int y) {
//		this.mouseX = x;
//		this.mouseY = y;
//	}

	public void run() {
		System.out.println("i'm running");
		while (true) {
			turnsnake.Move();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					canvas.redraw();
				}
			});
		}
	}

}
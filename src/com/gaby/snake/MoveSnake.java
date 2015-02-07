package com.gaby.snake;

import org.eclipse.swt.widgets.Display;

class MoveSnake extends Thread {

	private SnakeHead turnsnake;

	public MoveSnake(SnakeHead turnsnake) {
		super("movethread");
		this.turnsnake = turnsnake;

	}

	public void run() {
		System.out.println("i'm running");
		while (true) {
			turnsnake.Move();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					SnakeDriver.canvas.redraw();
				}
			});
		}
	}

}
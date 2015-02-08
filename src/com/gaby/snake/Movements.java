package com.gaby.snake;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

class Movements extends Thread {

	private SnakeHead turnsnake;
	private int mouseX;
	private int mouseY;

	public Movements(SnakeHead turnsnake) {
		super("movethread");
		this.turnsnake = turnsnake;

	}
	
	

	public void setMouse(int x, int y) {
		this.mouseX = x;
		this.mouseY = y;
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
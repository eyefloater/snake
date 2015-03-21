package com.gaby.snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SnakeGame {

	public Rectangle rect;
	public Image background;

	private Snake snake;
	public static Movements movesnake;

	public GC gcImage;
	public Image offImage;
	private Canvas canvas;

	public SnakeGame(Display display, Shell shell, Canvas _canvas) {
		this.canvas = _canvas;
		this.rect = canvas.getBounds();
		shell.setBackgroundImage(background);
		shell.setBackgroundMode(SWT.INHERIT_FORCE);

		background = new Image(display, "images/backgroundgrass.jpg");

		Image body = new Image(display, "images/segment.jpg");
		snake = new Snake(body, rect);
		offImage = new Image(display, canvas.getBounds());
		gcImage = new GC(offImage);

		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				//System.out.println("in");
				gcImage.drawImage(background, 0, 0);
				snake.getHead().draw(gcImage);
				/**
				 * Draw the off-screen image to the screen
				 * 
				 */
				e.gc.drawImage(offImage, 0, 0);

			}
		});

		canvas.addMouseListener(new MouseListener() {

			public void mouseDown(MouseEvent e) {

				// snakehead.setXY(e);

				snake.getHead().checkDirection(e);

				canvas.redraw();
			}

			public void mouseUp(MouseEvent e) {

				// snakehead.setXY(e);
			}

			public void mouseDoubleClick(MouseEvent e) {
				// System.out.println("Mouse Double click at: "+e.x);
			}

		});


		movesnake = new Movements(canvas, snake.getHead());
		movesnake.start();
	}
}
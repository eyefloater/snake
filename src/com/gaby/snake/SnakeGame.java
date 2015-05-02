package com.gaby.snake;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SnakeGame {

	private static SnakeGame instance;
	public Canvas canvas;
	public Rectangle rect;
	public Image background;

	static Snake snake;
	public static Movements movesnake;

	public GC gcImage;
	public Image offImage;

	private SnakeGame(Display display, Shell shell, final Canvas canvas) {
		
		this.rect = canvas.getBounds();
		shell.setBackgroundImage(background);
		shell.setBackgroundMode(SWT.INHERIT_FORCE);

		background = new Image(display, "images/backgroundgrass.jpg");

		Image body = new Image(display, "images/segment.jpg");
		snake = new Snake(body);
		offImage = new Image(shell.getDisplay(), canvas.getBounds());
		gcImage = new GC(offImage);

		Point loc = snake.getHead().snakelocation.getLocation();
		snake.getHead().draw(gcImage);

		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				// snakehead.draw(e);
				gcImage.drawImage(background, 0, 0);

				/**
				 * get the new image location, This method is synchronized so if
				 * the update thread is modifying the location, this thread (the
				 * UI thread) will wait until the updating thread releases the
				 * lock
				 */

				Point loc = snake.getHead().snakelocation.getLocation();
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

		// }

		movesnake = new Movements(snake.getHead());
		movesnake.start();

	}
	
	public static synchronized SnakeGame getSnakeGameInstance(Display display, Shell shell, Canvas canvas) {
		if (instance == null)
			instance = new SnakeGame(display, shell, canvas);
		return instance;
	}
}
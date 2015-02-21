package com.gaby.snake;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.gaby.snake.configuration.SnakeConf;
import com.gaby.snake.parsers.ConfigParser;

public class SnakeDriver {

	public static Canvas canvas;
	static SnakeHead snakehead;
	// private static Food food;
	public static Movements movesnake;
	public static Rectangle rect;
	public static Image background;
	public static GC gcImage;
	public static Image offImage;// = new Image(shell.getDisplay(),
									// canvas.getBounds());

	public static void main(String[] args) {

		SnakeConf sc = new ConfigParser().parseXMLFromStream();

		Display display = Display.getDefault();

		Shell shell = new Shell(display);
		rect = new Rectangle(100, 100, 600, sc.getHeight());

		shell.setBounds(rect);
		shell.setText("SNAKE");
		shell.setLayout(new FillLayout());
		canvas = new Canvas(shell, SWT.NO_BACKGROUND | SWT.COLOR_DARK_CYAN);

		Display.getCurrent();
		// Color blue = display.getSystemColor(SWT.COLOR_GREEN);
		// Color listBackground =
		// display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		background = new Image(display,
				"C:/Users/admin/Documents/GitHub/snake/images/backgroundgrass.jpg");
		shell.setBackgroundImage(background);
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		snakehead = new SnakeHead(200, 300, display);
		// food = new Food(200,-5, display);
		shell.open();
		offImage = new Image(shell.getDisplay(), canvas.getBounds());
		gcImage = new GC(offImage);

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
				// Point loc = getImageLoc();
				Point loc = snakehead.snakelocation.getLocation();
				gcImage.drawImage(snakehead.draw(e), loc.x, loc.y);

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

				snakehead.checkDirection(e);

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

		movesnake = new Movements(snakehead);
		movesnake.start();
		// keeps shell open until user closes it
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	private static void createContents(Shell shell) {
		// shell.setLayout(new FillLayout());

		// Create a canvas
		// canvas = new Canvas(shell, SWT.NONE);

		// Create a paint handler for the canvas
		// canvas.addPaintListener(new PaintListener() {
		// public void paintControl(PaintEvent e) {
		// //snakehead.draw(e);
		// gcImage.drawImage(background, 0, 0);
		//
		// /**
		// * get the new image location, This method is synchronized so if
		// * the update thread is modifying the location, this thread (the
		// * UI thread) will wait until the updating thread releases the
		// * lock
		// */
		// //Point loc = getImageLoc();
		// Point loc = snakehead.snakelocation.getLocation();
		// gcImage.drawImage(snakehead.draw(e), loc.x, loc.y);
		//
		// /**
		// * Draw the off-screen image to the screen
		// *
		// */
		// e.gc.drawImage(offImage, 0, 0);
		//
		// }
		// });
		//
		// canvas.addMouseListener(new MouseListener() {
		//
		// public void mouseDown(MouseEvent e) {
		//
		// // snakehead.setXY(e);
		//
		// snakehead.checkDirection(e);
		//
		// canvas.redraw();
		// }
		//
		// public void mouseUp(MouseEvent e) {
		//
		// // snakehead.setXY(e);
		// }
		//
		// public void mouseDoubleClick(MouseEvent e) {
		// // System.out.println("Mouse Double click at: "+e.x);
		// }
		//
		// });
		//
		// }
	}
}
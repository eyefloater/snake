package com.gaby.snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SnakeDriver {
	
	public static Canvas canvas;
	static SnakeHead snakehead;
	//private static Food food;
	public static Movements movesnake;
	public static Rectangle rect;
	public static Image background; 
	
	public static void main(String[] args) {

		Display display = Display.getDefault();

		Shell shell = new Shell(display);
		rect = new Rectangle(100, 100, 600, 600);
		
		shell.setBounds(rect);
		shell.setText("SNAKE");
		createContents(shell);
		Display.getCurrent();
		//Color blue = display.getSystemColor(SWT.COLOR_GREEN);
		//Color listBackground = display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		background = new Image(display,
				"C:/workspace/Snake/images/backgroundgrass.jpg");
		shell.setBackgroundImage (background);
		 shell.setBackgroundMode(SWT.INHERIT_FORCE);  
		snakehead = new SnakeHead(200, 300, display);
		//food = new Food(200,-5, display);
		shell.open();
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
		shell.setLayout(new FillLayout());

		// Create a canvas
		canvas = new Canvas(shell, SWT.NONE);

		// Create a paint handler for the canvas
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				snakehead.draw(e);
				

			}
		});

		canvas.addMouseListener(new MouseListener() {

			public void mouseDown(MouseEvent e) {

				snakehead.setXY(e);
				canvas.redraw();
			}

			public void mouseUp(MouseEvent e) {

				snakehead.setXY(e);
			}

			public void mouseDoubleClick(MouseEvent e) {
				// System.out.println("Mouse Double click at: "+e.x);
			}

		});

	}
}
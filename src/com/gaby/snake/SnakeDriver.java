package com.gaby.snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

//import com.gaby.snake.configuration.SnakeConf;
//import com.gaby.snake.parsers.ConfigParser;

public class SnakeDriver {

	public static Canvas canvas;
	public static Display display;
	public static Rectangle rect;
	public static GC gcImage;
	public static Image offImage;
	public static Shell shell;
	public static Image logo;
	private static HttpCommunicator httpcommunicator;

	public static void main(String[] args) {

		// SnakeConf sc = new ConfigParser().parseXMLFromStream();

		Display display = Display.getDefault();
		rect = new Rectangle(100, 100, 600, 600);
		shell = new Shell(display);

		// sc.getHeight());

		shell.setBounds(rect);
		shell.setText("SNAKE");

		shell.setLayout(new FormLayout());

		canvas = new Canvas(shell, SWT.NO_BACKGROUND);
		canvas.setVisible(false);
		createLayout(shell);
		shell.open();
		// SnakeGame snakegame = new SnakeGame(display, shell, canvas);

		// keeps shell open until user closes it
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public static void createLayout(Shell parent) {

		Image logo = new Image(display, "images/logo.png");

		// create a FormLayout and set its margin
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;


		Label loginImage = new Label(parent, SWT.CENTER);
		loginImage.setImage(logo);
		loginImage.pack();
		FormData fd = new FormData();
		fd.top = new FormAttachment(0, 50);
		fd.left = new FormAttachment(0, 150);
		fd.bottom = new FormAttachment(0, 250);
		fd.right = new FormAttachment(0, 350);
		loginImage.setLayoutData(fd);

		Label userLabel = new Label(parent, SWT.LEFT);
		userLabel.setText("user");
		fd = new FormData();
		fd.top = new FormAttachment(loginImage, 10, SWT.BOTTOM);
		fd.bottom = new FormAttachment(loginImage, 30, SWT.BOTTOM);
		fd.left = new FormAttachment(loginImage, 0, SWT.LEFT);
		fd.right = new FormAttachment(loginImage, 60, SWT.LEFT);
		userLabel.setLayoutData(fd);

		Text user = new Text(parent, SWT.NONE);
		fd = new FormData();
		fd.top = new FormAttachment(userLabel, 0, SWT.TOP);
		fd.bottom = new FormAttachment(userLabel, 0, SWT.BOTTOM);
		fd.left = new FormAttachment(userLabel, 5, SWT.LEFT);
		fd.right = new FormAttachment(userLabel, 120, SWT.RIGHT);
		user.setLayoutData(fd);

		Label passwordLabel = new Label(parent, SWT.LEFT);
		passwordLabel.setText("password");
		FormData formData = new FormData();
		formData.top = new FormAttachment(userLabel, 10, SWT.BOTTOM);
		formData.bottom = new FormAttachment(userLabel, 30, SWT.BOTTOM);
		formData.left = new FormAttachment(userLabel, 0, SWT.LEFT);
		formData.right = new FormAttachment(userLabel, 0, SWT.RIGHT);
		passwordLabel.setLayoutData(formData);

		Text password = new Text(parent, SWT.NONE);
		fd = new FormData();
		fd.top = new FormAttachment(passwordLabel, 0, SWT.TOP);
		fd.bottom = new FormAttachment(passwordLabel, 0, SWT.BOTTOM);
		fd.left = new FormAttachment(passwordLabel, 0, SWT.LEFT);
		fd.right = new FormAttachment(passwordLabel, 120, SWT.RIGHT);
		password.setLayoutData(fd);

		Button button = new Button(parent, SWT.PUSH);
		button.setText("LOGIN");
		fd = new FormData();
		fd.top = new FormAttachment(password, 10, SWT.BOTTOM);
		fd.bottom = new FormAttachment(password, 30, SWT.BOTTOM);
		fd.left = new FormAttachment(password, 0, SWT.LEFT);
		fd.right = new FormAttachment(password, 0, SWT.RIGHT);
		button.setLayoutData(fd);

		// set layout for parent
		parent.setLayout(layout);

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				System.out.println("CLICK");
				httpcommunicator = new HttpCommunicator();
				String response = httpcommunicator.get("test");
				int k = 0;

			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

}

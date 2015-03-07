package com.gaby.snake;

import java.awt.GridLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
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
		//shell.setLayout(new RowLayout());
		

		canvas = new Canvas(shell, SWT.NO_BACKGROUND);
		canvas.setVisible(false);
		createLayout(shell);
		shell.open();
		//SnakeGame snakegame = new SnakeGame(display, shell, canvas);

		// keeps shell open until user closes it
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public static void createLayout(Shell parent) {

		Image logo = new Image(display, "images/logo.png");

	   	 //ROW LAYOUT
		 RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		 rowLayout.center = true;
		 rowLayout.marginTop = 0;
	     rowLayout.marginBottom = 10;
	   	 rowLayout.marginLeft = 200;
	       //rowLayout.marginRight = 5;
	       rowLayout.spacing = 15;
	       shell.setLayout(rowLayout);
	            
	        Label loginImage = new Label(parent, SWT.RIGHT);
			loginImage.setImage(logo);
			loginImage.pack();
			RowData fd = new RowData();
			loginImage.setLayoutData(new RowData(200, 200));

			Label userLabel = new Label(parent, SWT.CENTER);
			fd = new RowData();
			userLabel.setText("User");
			userLabel.setLayoutData(new RowData(100, 15));
			
			Text user = new Text(parent, SWT.LEFT);
			fd = new RowData();
			user.setLayoutData(new RowData(100, 20));

			Label passwordLabel = new Label(parent, SWT.CENTER);
			fd = new RowData();
			passwordLabel.setText("Password");
			passwordLabel.setLayoutData(new RowData(100, 15));

			Text password = new Text(parent, SWT.LEFT);
			fd = new RowData();
			password.setLayoutData(new RowData(100, 20));

			Button button = new Button(parent, SWT.PUSH);
			button.setText("LOGIN");
			button.setLayoutData(new RowData(100, 20));

	        
	        
//	 	//FORM LAYOUT (NOT WORKING)
//		FormLayout layout = new FormLayout();
//		layout.marginHeight = 5;
//		layout.marginWidth = 5;
//
//
//		Label loginImage = new Label(parent, SWT.CENTER);
//		loginImage.setImage(logo);
//		loginImage.pack();
//		FormData fd = new FormData();
//		fd.top = new FormAttachment(0, 50);
//		fd.left = new FormAttachment(0, 150);
//		fd.bottom = new FormAttachment(0, 250);
//		fd.right = new FormAttachment(0, 350);
//		loginImage.setLayoutData(fd);
//
//		Label userLabel = new Label(parent, SWT.LEFT);
//		userLabel.setText("User");
//		fd = new FormData();
//		fd.top = new FormAttachment(loginImage, 10, SWT.BOTTOM);
//		fd.bottom = new FormAttachment(loginImage, 30, SWT.BOTTOM);
//		fd.left = new FormAttachment(loginImage, 0, SWT.LEFT);
//		fd.right = new FormAttachment(loginImage, 50, SWT.LEFT);
//		userLabel.setLayoutData(fd);
//
//		Text user = new Text(parent, SWT.LEFT);
//		fd = new FormData();
//		fd.top = new FormAttachment(userLabel, 0, SWT.TOP);
//		fd.bottom = new FormAttachment(userLabel, 0, SWT.BOTTOM);
//		fd.left = new FormAttachment(userLabel, 0, SWT.LEFT);
//		fd.right = new FormAttachment(userLabel, 100, SWT.RIGHT);
//		user.setLayoutData(fd);
//
//		Label passwordLabel = new Label(parent, SWT.LEFT);
//		passwordLabel.setText("Password");
//		fd = new FormData();
//		fd.top = new FormAttachment(userLabel, 10, SWT.BOTTOM);
//		fd.bottom = new FormAttachment(userLabel, 30, SWT.BOTTOM);
//		fd.left = new FormAttachment(userLabel, 0, SWT.LEFT);
//		fd.right = new FormAttachment(userLabel, 50, SWT.RIGHT);
//		passwordLabel.setLayoutData(fd);
//
//		Text password = new Text(parent, SWT.LEFT);
//		fd = new FormData();
//		fd.top = new FormAttachment(passwordLabel, 0, SWT.TOP);
//		fd.bottom = new FormAttachment(passwordLabel, 0, SWT.BOTTOM);
//		fd.left = new FormAttachment(passwordLabel, 0, SWT.LEFT);
//		fd.right = new FormAttachment(passwordLabel, 100, SWT.RIGHT);
//		password.setLayoutData(fd);
//
//		Button button = new Button(parent, SWT.PUSH);
//		button.setText("LOGIN");
//		fd = new FormData();
//		fd.top = new FormAttachment(password, 10, SWT.BOTTOM);
//		fd.bottom = new FormAttachment(password, 30, SWT.BOTTOM);
//		fd.left = new FormAttachment(password, 0, SWT.LEFT);
//		fd.right = new FormAttachment(password, -100, SWT.RIGHT);
//		button.setLayoutData(fd);

		//parent.setLayout(layout);
		
		
		


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

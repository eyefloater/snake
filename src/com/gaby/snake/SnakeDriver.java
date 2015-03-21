package com.gaby.snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

//import com.gaby.snake.configuration.SnakeConf;
//import com.gaby.snake.parsers.ConfigParser;

public class SnakeDriver {

	private static Canvas canvas;
	private static Display display;
	private static Rectangle rect;
	//private static GC gcImage;
	//private static Image offImage;
	private static Shell shell;
	private static Button startButton;
	private static Button loginButton;
	private static Label userLabel;
	private static Composite loginComposite;
	
	// public static Shell shellStart;
	// public static Shell shellGame;

	public static Image logo;
	//private static HttpCommunicator httpcommunicator;
	private static Text user;
	private static Label loginImage;
	private static Label passwordLabel;
	private static Text password;


	public static void main(String[] args) {

		// SnakeConf sc = new ConfigParser().parseXMLFromStream();

		Display display = Display.getDefault();
		rect = new Rectangle(100, 100, 600, 600);
		shell = new Shell(display);

		shell.setBounds(rect);
		shell.setText("SNAKE");
	
		shell.setLayout(new FormLayout());
		loginComposite = new Composite(shell, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.center = true;
		rowLayout.marginLeft = rect.width/3;
        rowLayout.marginTop = 5;
        rowLayout.marginRight = 5;
        rowLayout.marginBottom = 5;
        
		loginComposite.setLayout(rowLayout);
		
		FormData fd = new FormData();
	    fd.top = new FormAttachment(0, 0);
	    fd.left = new FormAttachment(0, 0);
	    fd.bottom = new FormAttachment(100, 0);
	    fd.right = new FormAttachment(100, 0);
	    loginComposite.setLayoutData(fd);

		canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
		fd = new FormData();
	    fd.top = new FormAttachment(0, 0);
	    fd.left = new FormAttachment(0, 0);
	    fd.bottom = new FormAttachment(100, 0);
	    fd.right = new FormAttachment(100, 0);
	    canvas.setLayoutData(fd);
	    canvas.setVisible(false);
		
		createLoginLayout();
		shell.open();
		// keeps shell open until user closes it forever
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public static void createLoginLayout() {

		Image logo = new Image(display, "images/logo.png");


		loginImage = new Label(loginComposite, SWT.RIGHT);
		loginImage.setImage(logo);
		loginImage.setLayoutData(new RowData(200, 200));

		userLabel = new Label(loginComposite, SWT.CENTER);
		userLabel.setText("User");
		userLabel.setLayoutData(new RowData(100, 15));

		user = new Text(loginComposite, SWT.LEFT);
		user.setLayoutData(new RowData(100, 20));

		passwordLabel = new Label(loginComposite, SWT.CENTER);
		passwordLabel.setText("Password");
		passwordLabel.setLayoutData(new RowData(100, 15));

		password = new Text(loginComposite, SWT.LEFT);
		password.setLayoutData(new RowData(100, 20));

		loginButton = new Button(loginComposite, SWT.PUSH);
		loginButton.setText("LOGIN");
		loginButton.setLayoutData(new RowData(100, 20));
		loginButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseDown(MouseEvent arg0) {
				String senduser = user.getText();
				String sendpassword = password.getText();
				startButton.setVisible(true);
				loginButton.setVisible(false);
				userLabel.setVisible(false);
				user.setVisible(false);
				passwordLabel.setVisible(false);
				password.setVisible(false);
				
				// Commented out to continue developing without needing the
				// server to be up
				// if ((senduser == null) || (sendpassword ==null)){
				// return;
				// }
				// HttpCommunicator communicator = new HttpCommunicator();
				// int responseCode = communicator.get("test");
				// if(HttpStatus.SC_OK != responseCode){
				// return;
				// }
				//
				// String response = communicator.post(senduser, sendpassword);
				// int k = 0;

				

			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		startButton = new Button(loginComposite, SWT.PUSH);
		startButton.setText("Start");
		startButton.setLayoutData(new RowData(100, 20));
		startButton.setVisible(false);
		startButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseDown(MouseEvent arg0) {

				// HttpCommunicator communicator = new HttpCommunicator();
				// int responseCode = communicator.get("test");
				// if (HttpStatus.SC_OK != responseCode) {
				// return;
				// }
				loginComposite.setVisible(false);
			    canvas.setVisible(true);
			    createGame();

			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {

			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	
	}

	public static void createGame() {
		SnakeGame snakegame = new SnakeGame(display, shell, canvas);

	}

}

package com.gaby.snake;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Rectangle;

public class Buttons {
	
	Rectangle leftButton;
	Rectangle rightButton;
	Rectangle upButton;
	Rectangle downButton;
	
	public static final int OUT = 0;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	

	public Buttons(Rectangle canvasrect){
		leftButton = new Rectangle(0, canvasrect.height*2/3, canvasrect.width/3, canvasrect.height/3);
		rightButton = new Rectangle(canvasrect.width*2/3, canvasrect.height*2/3, canvasrect.width/3, canvasrect.height/3);
		upButton = new Rectangle(canvasrect.width/3, canvasrect.height*2/3, canvasrect.width/3, canvasrect.height/6);
		downButton = new Rectangle(canvasrect.width/3, canvasrect.height*5/6, canvasrect.width/3, canvasrect.height/6);
	}
	
	public int getButton(int x, int y){
		if(insideButton(x,y, leftButton)){
			System.out.println("LEFT");
			return LEFT;}
		if(insideButton(x,y, rightButton)){
			System.out.println("RIGHT");
			return RIGHT;}
		if(insideButton(x,y, upButton)){
			System.out.println("UP");
			return UP;}
		if(insideButton(x,y, downButton)){
			System.out.println("DOWN");
			return DOWN;}
		return OUT;
						
	}
	
	private boolean insideButton(int x, int y, Rectangle rect){
		return (x>=rect.x)&&(x<=(rect.x+rect.width))&&(y>=rect.y)&&(y<=(rect.y+rect.height));
			
		}
		
		
	}



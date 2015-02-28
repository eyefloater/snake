package com.gaby.snake;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

public class Snake {
	// TODO: write a way to pull in both head and segment pieces here.

	private SnakeHead head;
	private List<SnakeSegment> body;

	public Snake(Image image) {
		super();
		head = new SnakeHead(0, 0, Display.getDefault());
		body = new ArrayList<SnakeSegment>();

		for (int i = 0; i < 2; i++) {
			int offsetx;
			int offsety;
			body.add(new SnakeSegment(0, 0, image));
		}
	}

	public SnakeHead getHead() {
		return head;
	}

	public void setHead(SnakeHead head) {
		this.head = head;
	}

	public void draw(GC gc) {
		//GC gc = e.gc;
		Point p = head.snakelocation.getLocation();
		head.draw(gc);

	}
}

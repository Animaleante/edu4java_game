package com.diogo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	private GameTest game;
	
	private int x = 0;
	private int vx = 0;

	public Racquet(GameTest game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			vx = -1;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			vx = 1;
	}

	public void keyReleased(KeyEvent e) {
		vx = 0;
	}

	public void move() {
		if(x + vx >= 0 && x + vx < game.getWidth() - WIDTH)
			x = x + vx;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillRect(x, Y, WIDTH, HEIGHT);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,  Y,  WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y;
	}
}

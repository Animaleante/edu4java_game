package com.diogo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	
	private GameTest game;
	
	private int x = 0;
	private int y = 0;
	private int vx = 1;
	private int vy = 1;
	
	public Ball(GameTest game) {
		this.game = game;
	}
	
	public void move() {
		if(x + vx < 0) {
			vx = 1;
		} else if(x + vx > game.getWidth() - DIAMETER) {
			vx = -1;
		}
		
		if(y + vy < 0) {
			vy = 1;
		} else if(y + vy > game.getHeight() - DIAMETER) {
//			vy = -1;
			game.gameOver();
		}
		
		if(collision()) {
			vy = -1;
			y = game.getRacquet().getTopY() - DIAMETER;
		}
		
		x = x + vx;
		y = y + vy;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, 30, 30);
	}
	
	public boolean collision() {
		return game.getRacquet().getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}

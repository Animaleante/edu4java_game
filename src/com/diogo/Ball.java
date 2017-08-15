package com.diogo;

import java.awt.Graphics2D;

public class Ball {
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
		} else if(x + vx > game.getWidth() - 30) {
			vx = -1;
		}
		
		if(y + vy < 0) {
			vy = 1;
		} else if(y + vy > game.getHeight() - 30) {
			vy = -1;
		}
		
		x = x + vx;
		y = y + vy;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, 30, 30);
	}
}

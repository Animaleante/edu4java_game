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
		boolean changeDirection = true;
		
		if(x + vx < 0) {
			vx = game.getSpeed();
		} else if(x + vx > game.getWidth() - DIAMETER) {
			vx = -game.getSpeed();
		} else if(y + vy < 0) {
			vy = game.getSpeed();
		} else if(y + vy > game.getHeight() - DIAMETER) {
			game.gameOver();
		} else if(collision()) {
			vy = -game.getSpeed();
			y = game.getRacquet().getTopY() - DIAMETER;
			game.setSpeed(game.getSpeed()+1);
		} else {
			changeDirection = false;
		}
		
		if(changeDirection)
			Sound.BALL.play();
		
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

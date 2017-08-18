package com.diogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static final int DIAMETER = 30;
	
	private GameTest game;
	
	private int x = 0;
	private int y = 0;
	private int vx = 1;
	private int vy = 1;
	
	private Point[] trails;
	private int trailCount;
//	private float[] trailsPercent = {0.8f,0.6f,0.4f,0.2f};
	private int trailCounter;
	
	public Ball(GameTest game) {
		this.game = game;

		trailCount = 50;
		trailCounter = 0;
		trails = new Point[trailCount];
		trails[0] = new Point(x, y);
	}
	
	public void move() {
//		boolean changeDirection = true;
		
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
//			changeDirection = false;
		}
		
//		if(changeDirection)
//			Sound.BALL.play();
		
		x = x + vx;
		y = y + vy;
		
		if(trailCounter % 2 == 0) {
			for(int i = trailCount-1; i > 0; i--) {
				if(trails[i-1] != null) {
					trails[i] = trails[i-1];
				}
			}
			
			trails[0] = new Point(x, y);
		}
		
		trailCounter++;
	}

	public void paint(Graphics2D g2d) {
		float percent;
		for(int i = trailCount-1; i > 0; i--) {
			if(trails[i] != null) {
				percent = (float)(trailCount-i)/trailCount;
				g2d.setColor(new Color(0, 0, 0, percent));
				g2d.fillOval(
					Math.round((trails[i].x + DIAMETER/2) - (DIAMETER/2 * percent)), 
					Math.round((trails[i].y + DIAMETER/2) - (DIAMETER/2 * percent)), 
					(int) Math.floor(DIAMETER * percent), 
					(int) Math.floor(DIAMETER * percent)
				);
			}
		}

		g2d.setColor(Color.BLACK);
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public boolean collision() {
		return game.getRacquet().getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}

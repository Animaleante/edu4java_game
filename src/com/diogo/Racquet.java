package com.diogo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet {
	private GameTest game;
	
	private int x = 0;
	private int vx = 0;

	public Racquet(GameTest game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			vx = 1;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			vx = -1;
	}

	public void keyReleased(KeyEvent e) {
		vx = 0;
	}

	public void move() {
		if(x + vx > 0 && x + vx < game.getWidth() - 60)
			x = x + vx;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillRect(x, 330, 60, 10);
	}
}

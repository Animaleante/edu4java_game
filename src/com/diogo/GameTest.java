package com.diogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameTest extends JPanel {
	
	private Ball ball;
	private Racquet racquet;

	public static void main(String[] args) throws InterruptedException {
		GameTest game = new GameTest();

		JFrame frame = new JFrame("Game Test");
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			game.process();
		}
	}
	
	private void process() throws InterruptedException {
		ball.move();
		racquet.move();
		
		this.repaint();
		Thread.sleep(10);
	}

	public GameTest() {
		ball = new Ball(this);
		racquet = new Racquet(this);
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		racquet.paint(g2d);
	}

}

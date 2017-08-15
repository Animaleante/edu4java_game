package com.diogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardExample extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Keyboard Example");
		KeyboardExample example = new KeyboardExample();
		frame.add(example);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public KeyboardExample() {
		KeyListener listener = new MyListener();
		this.addKeyListener(listener);
		this.setFocusable(true);
	}
	
	private class MyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
		}
		
	}

}

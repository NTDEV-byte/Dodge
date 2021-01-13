package com.dodge;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

	public boolean keys[] = new boolean[2048];
	public boolean right,left;
	
	
	public void update() { 
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}

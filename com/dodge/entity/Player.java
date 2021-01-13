package com.dodge.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.Game;
import com.dodge.Input;

public class Player extends Entity{

	private Input input = Game.input;
	
	public Player(Rectangle bounds,Color c) {
		super(bounds,c);
		
	}

	@Override
	public void update() {
		bounds.y+=speedy;
		if(input.right) {
			bounds.x+=speedx;
		}
		if(input.left) { 
			bounds.x-=speedx;
		}
		if(collision(level.getPlatforme())) speedy = 0;
		int co = this.collidingWorldBounds();
		if(co == LEFTC)  bounds.x+=speedx;
	    if(co == RIGHTC) bounds.x-=speedx;
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
	}

}

package com.dodge.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.Game;

public class Platforme extends Entity{

	public static final int PW = Game.WIDTH;
	public static final int PH = 15;
	
	public Platforme(Rectangle bounds, Color color) {
		super(bounds, color);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

}

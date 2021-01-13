package com.dodge.block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.entity.Entity;

public class Block extends Entity{

	public Block(Rectangle bounds, Color color) {
		super(bounds, color);
	}

	@Override
	public void update() {
		bounds.y+=speedy;
		if(collision(level.getPlatforme())) {
			 speedy = 0;
			 remove();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

}

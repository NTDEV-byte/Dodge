package com.dodge.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.Game;
import com.dodge.level.Level;

public abstract class Entity {
	
		public static final int LEFTC = 0;
		public static final int RIGHTC = 1;
		public static final int NOC = -1;
	
		protected Rectangle bounds;
		protected Color color;
		protected int speedx = 1,speedy = 1;
		protected boolean removed,colliding;
		protected Level level = Game.level;
		
		public Entity(Rectangle bounds) {
				this.bounds = bounds;
				this.color = Color.white;
		}
		
		public Entity(Rectangle bounds,Color color) { 
				this.bounds = bounds;
				this.color = color;
		}
		
		
		protected boolean collision(Entity e) { 
			return bounds.intersects(e.getBounds());
		}
		
		protected int collidingWorldBounds() { 
			 if(bounds.x <= 0 ) return LEFTC;
			 if(bounds.x >= Game.WIDTH - bounds.width) return RIGHTC;
			 return NOC;
		}
		
		public abstract void update();
		public abstract void render(Graphics g);
		
		public void remove() { 
			removed = true;
		}


		public Rectangle getBounds() {
			return bounds;
		}


		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}


		public boolean isRemoved() {
			return removed;
		}


		public void setRemoved(boolean removed) {
			this.removed = removed;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
		
		
		
}

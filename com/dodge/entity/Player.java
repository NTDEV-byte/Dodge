package com.dodge.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.Game;
import com.dodge.Input;

public class Player extends Entity{
	
	public static final Font FONT = new Font("Verdana",Font.PLAIN,15);
	public static final int SCORE_X = Game.WIDTH - 90;
	public static final int SCORE_Y = 15;
	
	
	private Input input = Game.input;
	private int score = 0;
	private int lives = 5;
	
	
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
	    if(level.getManager().touched(this)) {
	    	lives--;
	    }
	}
	
	private void renderScore(Graphics g) {
		g.setColor(color);
		g.setFont(FONT);
		g.drawString("Score: "+score, SCORE_X, SCORE_Y);
	}
	
	
	private void renderLives(Graphics g) {
		int startX = 5;
		 g.setColor(color);
		 for(int i=0;i<lives;i++) {
			  g.fillOval(startX, 5, 8, 8);
			  startX+=10;
		 }
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
		renderScore(g);
		renderLives(g);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}

}

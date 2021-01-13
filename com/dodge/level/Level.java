package com.dodge.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.dodge.Game;
import com.dodge.entity.Block;
import com.dodge.entity.Platforme;
import com.dodge.entity.Player;

public class Level {
	
		private Player player;
		private Platforme platforme;
		private Block block;
		
		public Level() { 
			
		}
		
		public void init() { 
			platforme = new Platforme(new Rectangle(0,Game.HEIGHT - Platforme.PH * 3,Platforme.PW,Platforme.PH),Color.red);
			player = new Player(new Rectangle(Game.WIDTH / 2 , 10,15,15),Color.cyan);
			block = new Block(new Rectangle(Game.WIDTH / 2 + 150 , 10,15,15),Color.magenta);
		}
		
		public void update() {
			Game.input.update();
			player.update();
		//	block.update();
		}
		
		public void render(Graphics g) {
			platforme.render(g);
			player.render(g);
			block.render(g);
		}
		
		
		
		
		public Player getPlayer() {
			return player;
		}
		public void setPlayer(Player player) {
			this.player = player;
		}
		public Platforme getPlatforme() {
			return platforme;
		}
		public void setPlatforme(Platforme platforme) {
			this.platforme = platforme;
		}
		public Block getBlock() {
			return block;
		}
		public void setBlock(Block block) {
			this.block = block;
		}

}

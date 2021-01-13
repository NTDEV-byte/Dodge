package com.dodge.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.dodge.Game;
import com.dodge.block.BlockManager;
import com.dodge.entity.Platforme;
import com.dodge.entity.Player;

public class Level {
	
		public static final int TOTAL_BLOCKS = 20;
		public static final int STEP_SCORE = 10;
		
		private Player player;
		private Platforme platforme;
		private int levels;
		private List<BlockManager> manager;
		private int currentLVL = 0;
		
		
		
		public Level(int levels) { 
			this.levels = levels;
		}
		
		public void init() { 
			platforme = new Platforme(new Rectangle(0,Game.HEIGHT - Platforme.PH * 3,Platforme.PW,Platforme.PH),Color.red);
			player = new Player(new Rectangle(Game.WIDTH / 2 , 10,15,15),Color.cyan);
			manager =  new ArrayList<BlockManager>();
			generateLevels();
		}
		

		public void update() {
			Game.input.update();
			player.update();
			manager.get(currentLVL).update();
			///increaseDifficulty();
		}
		
		
	
		public void render(Graphics g) {
			platforme.render(g);
			player.render(g);
			manager.get(currentLVL).render(g);
		}
		
		
	/*	private void increaseDifficulty() { 
			if(currentLVL > 0 && currentLVL <= manager.size() - 1);
		 	  if(player.getScore() >= 30) {
		 		   if(currentLVL > manager.size() -1) currentLVL = manager.size() - 1;
		 		   else currentLVL++;
		 	  }
		 	  System.out.println(currentLVL); 
		}*/
		
		
		private void generateLevels() {
			int step = 5;
			int blocks = TOTAL_BLOCKS;
			for(int i=0;i<levels;i++) {
				 manager.add(new BlockManager(blocks));
				 blocks+=step;
			}
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

		public BlockManager getManager() {
			return manager.get(currentLVL);
		}


}

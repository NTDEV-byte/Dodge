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
import com.dodge.menu.InnerMenu;

public class Level {
	
		public static final int TOTAL_BLOCKS = 20;
		public static final int STEP_SCORE = 10;
		public static final int BLOCKS_NEXT_LEVEL = 10;
		
		private Player player;
		private Platforme platforme;
		private InnerMenu menu;
		private int levels;
		private List<BlockManager> manager;
		private int currentLVL = 0;
		
		public Level(int levels) { 
			this.levels = levels;
			menu = new InnerMenu();
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
			increaseDifficulty();
			manager.get(currentLVL).update();
		}
		
		public void render(Graphics g) {
			if(!player.hasNoLives()) { 
				platforme.render(g);
				player.render(g);
				manager.get(currentLVL).render(g);
			}
			else {
				menu.show(g);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void increaseDifficulty() {
			System.out.println(currentLVL);
			 if(player.getScore() % 20 != 0) player.setScoreIncreased(false);
			 if(currentLVL!= manager.size() - 1 && player.getScore() % 20 == 0 && player.getScore()!=0 && !player.isScoreIncreased()) { 
				 if(currentLVL >= 0 && currentLVL < manager.size() - 1)
					 player.setScoreIncreased(true);
				 	 currentLVL++;
			 }
		}
		
		private void generateLevels() {
			int step = BLOCKS_NEXT_LEVEL;
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

package com.dodge.block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.dodge.Game;
import com.dodge.entity.Entity;
import com.dodge.level.Level;

public class BlockManager extends Entity{

	 	public static final int BLOCK_WIDTH = 30;
	 	public static final int BLOCK_HEIGHT = 10;
	
			private List<Block> blocks = new ArrayList<Block>();
			private int amount;
			
			
			public BlockManager(int amount) { 
				this.amount = amount;
				generate();
			}
	
	
			private void generate() {
				for(int i=0;i<amount;i++) {
					 blocks.add(new Block(new Rectangle(random.nextInt(Game.WIDTH / 2),random.nextInt(Game.HEIGHT /2),BLOCK_WIDTH,BLOCK_HEIGHT),new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255))));
				}
			}
			
			private void removeDestroyedBlocks() {
				 for(int i=0;i<blocks.size();i++) {
					  if(blocks.get(i).isRemoved()) {
						   blocks.remove(i);
					  }
				 }
			}
			
			public boolean touched(Entity e) { 
				 for(int i=0;i<blocks.size();i++) { 
					   if(blocks.get(i).collision(e)) {
						    blocks.get(i).remove();
						    return true;
					   }
				 }
				 return false;
			}
			
			private void regenerate() { 
				if(blocks.size() - 1 == 0) { 
					 generate();
					 level.getPlayer().setScore(level.getPlayer().getScore() + Level.STEP_SCORE);
				}
			}
	@Override
	public void update() {
		for(Block b : blocks) { 
			b.update();
		}
		regenerate();
		removeDestroyedBlocks();
	}

	@Override
	public void render(Graphics g) {
		for(Block b : blocks) { 
			b.render(g);
		}
	}	

}

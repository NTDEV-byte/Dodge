package com.dodge;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dodge.level.Level;

public class Game extends JPanel{
	
	
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			public static final int WIDTH = 800;
			public static final int HEIGHT = 600;

			public static Input input = new Input();
			public static Level level = new Level();
			
			private JFrame window;
			
			
				public Game() { 
					level.init();
					window = new JFrame("Dodge");
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setLocationRelativeTo(null);
					setPreferredSize(new Dimension(WIDTH,HEIGHT));
					window.addKeyListener(input);
					window.add(this);
					window.pack();
				}
				
				
				
				public void paint(Graphics g) { 
					g.setColor(Color.black);
					g.fillRect(0, 0, getWidth(), getHeight());
					level.render(g);
					level.update();
					repaint();
				}
				
				
				
				public static void main(String[] args) { 
						new Game();
				}
			
}

package com.game.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Display extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5734478523296375045L;
	Sprite sprite;
	Image background;
	public volatile int dx;
	
	public Display(Sprite sprite, Image background){
		this.sprite = sprite;
		this.background = background;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image image = sprite.getImage();
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(background, dx, 0, null);
		g.drawImage(image, 0, 0, null);
	}
}

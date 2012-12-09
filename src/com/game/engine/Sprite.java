package com.game.engine;

import java.awt.Image;

public class Sprite {
	private final String name;
	private final Animation animation;
	
	public Sprite(String name, Animation animation){
		this.name = name;
		this.animation = animation;
	}
	
	public String getName(){
		return name;
	}

	public Image getImage() {
		return animation.nextImage();
	}
	
	public String toString(){
		return String.format("Sprite(%s)", name);
	}

	public boolean stopped() {
		return animation.stopped();
	}
}

package com.game.engine;

import java.awt.Image;

class Frame{
	private final Long id;
	private final Image image;
	private final Long duration;
	
	public Frame(Long id, Image image, Long duration){
		this.id = id;
		this.image = image;
		this.duration = duration;
	}

	public Image getImage() {
		return image;
	}

	public Long getDuration() {
		return duration;
	}
	
	public Long getId(){
		return id;
	}
	
	@Override
	public String toString(){
		return String.format("Frame(%s, %s)", id , duration);
	}
}
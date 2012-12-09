package com.game.engine;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

public class Animation {
	private final List<Frame> frames = new LinkedList<Frame>();
	private final boolean loop;
	private int frameIndex;
	private Frame currentFrame;
	private long duration;
	
	public Animation(){
		this(false);
	}
	
	public Animation(boolean loop){
		this.loop = loop;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public Image nextImage(){
		int size = frames.size();
		if(System.currentTimeMillis() > duration){
			currentFrame = frames.get(frameIndex);
			duration = System.currentTimeMillis() + currentFrame.getDuration();
			
			if(loop){
				frameIndex = (++frameIndex%size);
			}else if(frameIndex < size - 1){
				frameIndex++;
			}
		}
		return currentFrame.getImage();

	}
	
	public synchronized boolean stopped(){
		return !loop && frameIndex == frames.size() - 1;
	}

		
}

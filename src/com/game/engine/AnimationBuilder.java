package com.game.engine;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;

public final class AnimationBuilder {
	
	private AnimationBuilder(){
		
	}
	
	public static Animation build() throws Exception{
		Animation animation = new Animation(true);
		String prifix = "starling/run";
		
		for(int i = 0; i < 12; i++ ){
			String index = i < 9 ? "000" + (i+1) : "00" + (i+1);
			File file = new File(prifix + index + ".png"); 
			
			InputStream input  = null;
			byte[] buffer = new byte[(int)file.length()];
		
			try {
				input = new FileInputStream(file);
				input.read(buffer);
			}finally{
				if(input != null){
					input.close();
				}
			}
			
			ImageIcon image = new ImageIcon(buffer);
			Frame frame = new Frame((long)i, image.getImage(), 50l);
			
			animation.addFrame(frame);
		}
		
		return animation;
	}
	
	public static Image LoadBackground() throws Exception{
		File file = new File("foresr.jpg");
		byte buffer[] = new byte[(int)file.length()];
		InputStream stream = null;
		
		try {
			stream = new FileInputStream(file);
			stream.read(buffer);
		} finally{
			if(stream != null){
				stream.close();
			}
		}
		
		return new ImageIcon(buffer).getImage();
	}
}

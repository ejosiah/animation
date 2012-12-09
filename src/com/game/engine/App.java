package com.game.engine;

import java.awt.Image;

import javax.swing.JFrame;

public class App extends JFrame{

	private static final long serialVersionUID = -5377368338681609778L;
	private Display display;
	private Sprite sprite;
	public App(Sprite sprite, Image background){
		super("Starling");
		this.sprite = sprite;
		display = new Display(sprite, background);
		add(display);
		setSize(500, 333);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		new Thread(new Play()).start();
	}
	
	private class Play implements Runnable{

		@Override
		public void run() {
			try{
				while (true) {
					if(sprite.stopped()){
						break;
					}
					Thread.sleep(50L);
					display.dx -= 10;
					display.repaint();
				}
			}catch(InterruptedException e){
				// Ignore
			}
			
		}
		
	}
	
	public static void main(String...args) throws Exception{
		Animation animation = AnimationBuilder.build();
		new App(new Sprite("starling", animation), AnimationBuilder.LoadBackground());
	}

}

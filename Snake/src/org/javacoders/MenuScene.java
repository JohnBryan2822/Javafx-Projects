package org.javacoders;

import java.awt.Color;
import java.awt.Graphics;

public class MenuScene extends Scene {
	
	public KL keyListener;
	
	public MenuScene(KL keyListener) {
		this.keyListener = keyListener;
	}

	@Override
	public void update(double dt) {
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

}

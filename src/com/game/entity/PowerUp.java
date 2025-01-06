package com.game.entity;

import java.awt.Graphics;

import com.game.Game;
import com.game.Handler;
import com.game.Id;

public class PowerUp extends Entity {

	public PowerUp(int x, int y, int width, int height, Id id, Handler handler,String type) 
	{
		super(x, y, width, height, id, handler);
		this.type=type;
	}

	@Override
	public void render(Graphics g) 
	{
		if(type.toLowerCase().contains("powerup"))
			g.drawImage(Game.powerup.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("fire"))
			g.drawImage(Game.fire.getBufferedImage(), x, y, width,height,null);
	}	

	@Override
	public void tick() {
		y+=getVelY();
		
	}

}

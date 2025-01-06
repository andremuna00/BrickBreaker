package com.game.entity;

import java.awt.Graphics;

import com.game.Game;
import com.game.Handler;
import com.game.Id;
import com.game.input.MouseInput;

public class Player extends Entity {

	public Player(int x, int y, int width, int height, Id id, Handler handler) 
	{
		super(x, y, width, height, id, handler);
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Game.player.getBufferedImage(),x,y,width,height,null);
	}

	@Override
	public void tick() 
	{
		if(Game.Tastiera)x+=getVelX();
		if(Game.Mouse)x=MouseInput.x-width/2;
		if(x<=0)x=0;
		if(x+width>=Game.GetFrameWidth())x=Game.GetFrameWidth()-width;
		for(int i =0;i<Game.handler.entity.size();i++)
		{
			Entity en = Game.handler.entity.get(i);
			if(en.getBounds().intersects(getBounds())&&en.getId()==Id.powerup&&en.type=="powerup")
			{
				Game.handler.addEntity(new Ball(x+width/2, y-24, 25, 25, Id.ball, Game.handler));
				Game.numeroBall++;
				en.die();
			}
			if(en.getBounds().intersects(getBounds())&&en.getId()==Id.powerup&&en.type=="fire")
			{
				Game.firable=true;
				en.die();
			}
		}
	}

}

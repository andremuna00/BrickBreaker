package com.game.tile;

import java.awt.Graphics;
import java.util.Random;

import com.game.Game;
import com.game.Handler;
import com.game.Id;

public class Block extends Tile 
{
	Random rnd;
	public Block(int x, int y, int width, int height, boolean solid, Id id, Handler handler, String type,int hp)
	{
		super(x, y, width, height, solid, id, handler,hp);
		this.type=type;
		rnd=new Random();
		this.random=rnd.nextInt(30);//da 0 a 29-30 numeri
	}

	@Override
	public void render(Graphics g)
	{
		if(type.toLowerCase().contains("blue"))
			g.drawImage(Game.blue.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("red"))
			g.drawImage(Game.red.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("yellow"))
			g.drawImage(Game.yellow.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("green"))
			g.drawImage(Game.green.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("violet"))
			g.drawImage(Game.violet.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("light_blue"))
			g.drawImage(Game.light_blue.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("orange"))
			g.drawImage(Game.orange.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("acqua"))
			g.drawImage(Game.acqua.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("unbreak"))
			g.drawImage(Game.unbreak.getBufferedImage(), x, y, width,height,null);
		if(type.toLowerCase().contains("breakable"))
		{	
			if(hp==2)
			{
				g.drawImage(Game.breakable[2].getBufferedImage(), x, y, width,height,null);
			}
			if(hp==1)
			{
				g.drawImage(Game.breakable[1].getBufferedImage(), x, y, width,height,null);
			}
			if(hp==0)
			{
				g.drawImage(Game.breakable[0].getBufferedImage(), x, y, width,height,null);
			}
		}
		
	}

	@Override
	public void tick() 
	{}

}

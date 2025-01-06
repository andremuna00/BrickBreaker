package com.game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.entity.Ball;
import com.game.entity.Entity;
import com.game.entity.Player;
import com.game.tile.Block;
import com.game.tile.Tile;

public class Handler 
{

	public LinkedList<Entity> entity = new LinkedList<Entity>();
	public LinkedList<Tile> tile = new LinkedList<Tile>();
	
	public int unbreakblock=0;
	
	public void render(Graphics g)
	{
		for(int i=0;i<entity.size();i++)
		{
			Entity en = entity.get(i);
			en.render(g);
		}
		
		for(Tile ti:tile)
		{
			ti.render(g);
		}

	}
	
	public void tick()
	{
		for(int i=0;i<entity.size();i++)
		{
			Entity en = entity.get(i);
			en.tick();
			
		}
		
		for(Tile ti:tile)
		{
			ti.tick();
		}
	}
	
	public void addEntity(Entity en)
	{
		entity.add(en);
	}
	
	public void removeEntity(Entity en)
	{
		entity.remove(en);
	}
	
	public void addTile(Tile ti)
	{
		tile.add(ti);
	}
	
	public void removeTile(Tile ti)
	{
		tile.remove(ti);
	}
	
	public void createLevel(BufferedImage level)
	{
		int width=level.getWidth();
		int height=level.getHeight();
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				int pixel=level.getRGB(x, y);
				
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel ) & 0xff;
				
				if(red==0&&green==0&&blue==255) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"blue",0));
				if(red==255&&green==0&&blue==0) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"red",0));
				if(red==255&&green==255&&blue==0) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"yellow",0));
				if(red==0&&green==255&&blue==0) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"green",0));
				if(red==128&&green==0&&blue==255) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"violet",0));
				if(red==0&&green==255&&blue==128) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"acqua",0));
				if(red==255&&green==128&&blue==0) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"orange",0));
				if(red==0&&green==255&&blue==255) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"light_blue",0));
				if(red==128&&green==128&&blue==128) {addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"unbreak",0));unbreakblock++;}
				if(red==128&&green==128&&blue==0) addTile(new Block(x*37,y*25,37,25,true,Id.block,this,"breakable",2));
				if(red==0&&green==0&&blue==0) addEntity(new Player(x*37,y*25,150,25,Id.player,this));
				if(red==255&&green==128&&blue==255) {addEntity(new Ball(x*37,y*25,25,25,Id.ball,this));Game.numeroBall=1;}
			}
		}
	}
	
	public void ClearLevel()
	{
		unbreakblock=0;
		entity.clear();
		tile.clear();
	}

}
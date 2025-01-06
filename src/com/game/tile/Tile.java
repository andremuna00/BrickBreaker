package com.game.tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.Handler;
import com.game.Id;

public abstract class Tile {
	public int x,y;
	public int width,height;
	
	public boolean solid;
	public boolean activated= false;
	
	public int velX,velY;

	public Id id;
	
	public Handler handler;
	public int random;
	public int hp;
	public String type;
	
	public Tile(int x,int y,int width,int height,boolean solid, Id id,Handler handler,int hp)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.solid=solid;
		this.id=id;
		this.handler=handler;
		this.hp=hp;
	}
	
	
	public abstract void render(Graphics g);	
	
	public abstract void tick();
	
	public void die()
	{
		handler.removeTile(this);
	}
	
	//getter and setter
	public void setVelX(int velX) {this.velX = velX;}

	public void setVelY(int velY) {this.velY = velY;}

	public int getX() {return x;}

	public void setX(int x) {this.x = x;}

	public int getY() {return y;}

	public void setY(int y) {this.y = y;}

	public boolean isSolid() {return solid;}

	public void setSolid(boolean solid) {this.solid = solid;}
	
	public Id getId() {return id;}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,width,height);
	}
}

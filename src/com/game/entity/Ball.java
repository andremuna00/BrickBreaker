package com.game.entity;

import java.awt.Graphics;
import com.game.Game;
import com.game.Handler;
import com.game.Id;
import com.game.tile.Tile;

public class Ball extends Entity {

	private boolean pause=false;
	PowerUp powerup;
	
	public Ball(int x, int y, int width, int height, Id id, Handler handler) 
	{
		super(x, y, width, height, id, handler);
	}

	@Override
	public void render(Graphics g) 
	{
		
		if(Game.firable) g.drawImage(Game.poweredball.getBufferedImage(),x,y,width,height,null);
		else g.drawImage(Game.ball.getBufferedImage(),x,y,width,height,null);
	}

	@Override
	public void tick() 
	{
		
		x+=getVelX();
		y+=getVelY();
		if(x<=0) setVelX(Game.getVel());
		if(y+height>=Game.GetFrameHeight()){Game.numeroBall--;die();}
		if(Game.numeroBall==0)
		{
			if(Game.Playing==true)
			{
				Game.Playing=false;
				for(int j=0;j<Game.handler.entity.size();j++)
				{
					Entity ent = Game.handler.entity.get(j);
					if(ent.getId()==Id.player) ent.die();
				}
			}
		}
		if(y<=0) setVelY(Game.getVel());
		if(x+width>=Game.GetFrameWidth()) setVelX(-Game.getVel());
		for(int i=0;i<Game.handler.tile.size();i++)
		{
			Tile ti = Game.handler.tile.get(i);
			if(getBoundsTop().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==0&&pause==false) 
			{
				if(!Game.firable)setVelY(Game.getVel()); 
				if(Game.firable&&ti.type.contains("unbreak"))setVelY(Game.getVel());
				if(!ti.type.contains("unbreak"))
				{
					ti.die();
					Game.punti++;
					if(ti.random==1)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"powerup"));
						powerup.setVelY(+2);
					}
					if(ti.random==0)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"fire"));
						powerup.setVelY(+2);
					}
				}
			}
			if(getBoundsBottom().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==0&&pause==false) 
			{
				if(!Game.firable)setVelY(-Game.getVel());
				if(Game.firable&&ti.type.contains("unbreak"))setVelY(-Game.getVel());
				if(!ti.type.contains("unbreak"))
				{
					ti.die();
					Game.punti++;
					if(ti.random==1)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"powerup"));
						powerup.setVelY(+2);
					}
					if(ti.random==0)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"fire"));
						powerup.setVelY(+2);
					}
				}
			}
				
			if(getBoundsLeft().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==0&&pause==false) 
			{
				if(!Game.firable)setVelX(Game.getVel());
				if(Game.firable&&ti.type.contains("unbreak"))setVelX(Game.getVel());
				if(!ti.type.contains("unbreak"))
				{
					ti.die();
					Game.punti++;
					if(ti.random==1)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"powerup"));
						powerup.setVelY(+2);
					}
					if(ti.random==0)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"fire"));
						powerup.setVelY(+2);
					}
				}
			}
			
			if(getBoundsRight().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==0&&pause==false)
			{ 
				if(!Game.firable)setVelX(-Game.getVel());
				if(Game.firable&&ti.type.contains("unbreak"))setVelX(-Game.getVel());
				if(!ti.type.contains("unbreak"))
				{
					ti.die();
					Game.punti++;
					if(ti.random==1)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"powerup"));
						powerup.setVelY(+2);
					}
					if(ti.random==0)
					{
						Game.handler.entity.add(powerup=new PowerUp(ti.x+ti.width/2-15, ti.y+ti.height, 30, 30, Id.powerup, Game.handler,"fire"));
						powerup.setVelY(+2);
					}
				}
			}
			
			if(getBoundsTop().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==3) {ti.hp=2;setVelY(Game.getVel());pause=true;}
			if(getBoundsBottom().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==3) {ti.hp=2;setVelY(-Game.getVel());pause=true;}
			if(getBoundsLeft().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==3) {ti.hp=2;setVelX(Game.getVel());pause=true;}
			if(getBoundsRight().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==3){ti.hp=2;setVelX(-Game.getVel());pause=true;}
			
			if(getBoundsTop().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==2&&pause==false) {ti.hp=1;setVelY(Game.getVel());pause=true; }
			if(getBoundsBottom().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==2&&pause==false) {ti.hp=1;setVelY(-Game.getVel());pause=true;}
			if(getBoundsLeft().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==2&&pause==false) {ti.hp=1;setVelX(Game.getVel());pause=true;}
			if(getBoundsRight().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==2&&pause==false){ti.hp=1;setVelX(-Game.getVel());pause=true;}
			
			if(getBoundsTop().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==1&&pause==false) {ti.hp=0;setVelY(Game.getVel()); pause=true;}
			if(getBoundsBottom().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==1&&pause==false) {ti.hp=0;setVelY(-Game.getVel());pause=true;}
			if(getBoundsLeft().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==1&&pause==false) {ti.hp=0;setVelX(Game.getVel());pause=true;}
			if(getBoundsRight().intersects(ti.getBounds())&&ti.getId()==Id.block&&ti.hp==1&&pause==false){ti.hp=0;setVelX(-Game.getVel());pause=true;}
			
			pause=false;
			
		}
		for(int i=0;i<Game.handler.entity.size();i++)
		{
			Entity en = Game.handler.entity.get(i);
			if(getPerfectBounds().intersects(en.getBoundsBottom())&&en.getId()==Id.player)
			{
				
			}
			else if(getPerfectBounds().intersects(en.getBoundsLeft())&&en.getId()==Id.player)
			{
				setVelY(-Game.getVel());
				setVelX(-Game.getVel());
			}
			else if(getPerfectBounds().intersects(en.getBoundsRight())&&en.getId()==Id.player)
			{
				setVelY(-Game.getVel());
				setVelX(Game.getVel());
			}
			else if(getPerfectBounds().intersects(en.getBounds())&&en.getId()==Id.player)
			{ 
				setVelY(-Game.getVel());
				if(getVelX()==0) setVelX(-Game.getVel());
			}
			else if(getVelX()==0&&getVelY()==0&&Game.stop==false)
			{
				setVelX(Game.getVel());
				setVelY(-Game.getVel());
			}
		}
	}

}

package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Graphics;

import com.game.Game;
import com.game.gfx.Sprite;

public class Palline 
{
	public Button button[];
	Sprite pallina0;
	Sprite pallina1;
	Sprite pallina2;
	Sprite pallina3;
	Sprite pallina4;
	Sprite pallina5;
	Sprite pallina6;
	
	public Palline()
	{
		pallina0=new Sprite("/Balls/balls0.png");
		pallina1=new Sprite("/Balls/balls.png");
		pallina2=new Sprite("/Balls/ball2.png");
		pallina3=new Sprite("/Balls/ball3.png");
		pallina4=new Sprite("/Balls/ball4.png");
		pallina5=new Sprite("/Balls/ball5.png");
		pallina6=new Sprite("/Balls/ball6.png");
		
		button=new Button[7];
		
		button[0]=new Button(40,80,100,100,"pal 1");
		button[1]=new Button(225,80,100,100,"pal 2");
		button[2]=new Button(410,80,100,100,"pal 3");
		button[3]=new Button(40,300,100,100,"pal 4");
		button[4]=new Button(225,300,100,100,"pal 5");
		button[5]=new Button(410,300,100,100,"pal 6");
		button[6]=new Button(50,500,160,90,"back");
	}
	
	public void render(Graphics g) 
	{
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.GetFrameWidth(), Game.GetFrameHeight());
		for(int i=0;i<button.length;i++)
		{
			button[i].render(g);
		}
		g.drawImage(pallina1.getBufferedImage(), 40, 80, 100,100,null);
		
		if(Game.pal2) g.drawImage(pallina2.getBufferedImage(), 225, 80, 100,100,null);
		else{ g.drawImage(pallina0.getBufferedImage(), 225, 80, 100,100,null);g.drawString("100 Coin", 215, 60);}
		
		if(Game.pal3) g.drawImage(pallina3.getBufferedImage(), 410, 80, 100,100,null);
		else{ g.drawImage(pallina0.getBufferedImage(), 410, 80, 100,100,null);g.drawString("150 Coin", 400, 60);}
		
		if(Game.pal4) g.drawImage(pallina4.getBufferedImage(), 40, 300, 100,100,null);
		else{ g.drawImage(pallina0.getBufferedImage(), 40, 300, 100,100,null);g.drawString("200 Coin", 30, 280);}
		
		if(Game.pal5) g.drawImage(pallina5.getBufferedImage(), 225, 300, 100,100,null);
		else{ g.drawImage(pallina0.getBufferedImage(), 225, 300, 100,100,null);g.drawString("250 Coin", 215, 280);}
		
		if(Game.pal6) g.drawImage(pallina6.getBufferedImage(), 410, 300, 100,100,null);
		else{ g.drawImage(pallina0.getBufferedImage(), 410, 300, 100,100,null);	g.drawString("300 Coin", 400, 280);}
		
		g.drawImage(Game.monete.getBufferedImage(), 400, 520, 108/3,128/3,null);
		g.drawString(": "+Game.soldi, 450, 550);
		
	}
}


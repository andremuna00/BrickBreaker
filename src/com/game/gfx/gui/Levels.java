package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Graphics;

import com.game.Game;
import com.game.gfx.Sprite;

public class Levels 
{
	public Button button[];
	
	Sprite livello0;
	Sprite livello1;
	Sprite livello2;
	Sprite livello3;
	Sprite livello4;
	Sprite livello5;
	Sprite livello6;
	
	public Levels()
	{
		
		button=new Button[7];
		
		livello0= new Sprite("/Livello/livello_bloccato.jpg");
		livello1= new Sprite("/Livello/level0.png");
		livello2= new Sprite("/Livello/level1.png");
		livello3= new Sprite("/Livello/level2.png");
		livello4= new Sprite("/Livello/level3.png");
		livello5= new Sprite("/Livello/level4.png");
		livello6= new Sprite("/Livello/level5.png");
		
		button[0]=new Button(40,80,120,160,"liv 1");
		button[1]=new Button(225,80,120,160,"liv 2");
		button[2]=new Button(410,80,120,160,"liv 3");
		button[3]=new Button(40,300,120,160,"liv 4");
		button[4]=new Button(225,300,120,160,"liv 5");
		button[5]=new Button(410,300,120,160,"liv 6");
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
		g.drawImage(livello1.getBufferedImage(), 40, 80, 120,160,null);
		
		if(Game.livello2) g.drawImage(livello2.getBufferedImage(), 225, 80, 120,160,null);
		else g.drawImage(livello0.getBufferedImage(), 225, 80, 120,160,null);
		
		if(Game.livello3) g.drawImage(livello3.getBufferedImage(), 410, 80, 120,160,null);
		else g.drawImage(livello0.getBufferedImage(), 410, 80, 120,160,null);
		
		if(Game.livello4) g.drawImage(livello4.getBufferedImage(), 40, 300, 120,160,null);
		else g.drawImage(livello0.getBufferedImage(), 40, 300, 120,160,null);
		
		if(Game.livello5) g.drawImage(livello5.getBufferedImage(), 225, 300, 120,160,null);
		else g.drawImage(livello0.getBufferedImage(), 225, 300, 120,160,null);
		
		if(Game.livello6) g.drawImage(livello6.getBufferedImage(), 410, 300, 120,160,null);
		else g.drawImage(livello0.getBufferedImage(), 410, 300, 120,160,null);		
		
	}
}

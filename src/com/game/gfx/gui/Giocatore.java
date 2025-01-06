package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Graphics;

import com.game.Game;
import com.game.gfx.Sprite;

public class Giocatore {
	public Button button[];
	
	Sprite giocatore0;
	Sprite giocatore1;
	Sprite giocatore2;
	Sprite giocatore3;
	Sprite giocatore4;
	Sprite giocatore5;
	Sprite giocatore6;
	public Giocatore()
	{
		giocatore0=new Sprite("/Players/player0.png");
		giocatore1=new Sprite("/Players/player1.png");
		giocatore2=new Sprite("/Players/player2.png");
		giocatore3=new Sprite("/Players/player3.png");
		giocatore4=new Sprite("/Players/player4.png");
		giocatore5=new Sprite("/Players/player5.png");
		giocatore6=new Sprite("/Players/player6.png");
		
		button=new Button[7];

		button[0]=new Button(5,80,150+25,25+4,"gio 1");
		button[1]=new Button(190,80,150+25,25+4,"gio 2");
		button[2]=new Button(375,80,150+25,25+4,"gio 3");
		button[3]=new Button(5,300,150+25,25+4,"gio 4");
		button[4]=new Button(190,300,150+25,25+4,"gio 5");
		button[5]=new Button(375,300,150+25,25+4,"gio 6");
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
		g.drawImage(giocatore1.getBufferedImage(), 5, 80, 150+25,25+4,null);
		
		if(Game.gio2) g.drawImage(giocatore2.getBufferedImage(), 190, 80, 150+25,25+4,null);
		else{ g.drawImage(giocatore0.getBufferedImage(), 190, 80,150+25,25+4,null);g.drawString("100 Coin", 215, 60);}
		
		if(Game.gio3) g.drawImage(giocatore3.getBufferedImage(), 375, 80, 150+25,25+4,null);
		else{ g.drawImage(giocatore0.getBufferedImage(), 375, 80, 150+25,25+4,null);g.drawString("150 Coin", 400, 60);}
		
		if(Game.gio4) g.drawImage(giocatore4.getBufferedImage(), 5, 300, 150+25,25+4,null);
		else{ g.drawImage(giocatore0.getBufferedImage(), 5, 300, 150+25,25+4,null);g.drawString("200 Coin", 30, 280);}
		
		if(Game.gio5) g.drawImage(giocatore5.getBufferedImage(), 190, 300, 150+25,25+4,null);
		else{ g.drawImage(giocatore0.getBufferedImage(), 190, 300, 150+25,25+4,null);g.drawString("250 Coin", 215, 280);}
		
		if(Game.gio6) g.drawImage(giocatore6.getBufferedImage(), 375, 300, 150+25,25+4,null);
		else{ g.drawImage(giocatore0.getBufferedImage(), 375, 300, 150+25,25+4,null);	g.drawString("300 Coin", 400, 280);}
		
		g.drawImage(Game.monete.getBufferedImage(), 400, 520, 108/3,128/3,null);
		g.drawString(": "+Game.soldi, 450, 550);
		
	}
}


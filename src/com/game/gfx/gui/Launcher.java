package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.game.Game;
import com.game.gfx.Sprite;

public class Launcher {
	
	public Button button[];
	
	public Launcher()
	{
		button=new Button[5];
		button[0]=new Button(160,250,200,70,"Inizia il gioco");
		button[1]=new Button(40,40,75,75,"vol");
		button[2]=new Button(180,350,200,70,"Livelli");
		button[3]=new Button(80,430,200,70,"Palline");
		button[4]=new Button(260,430,200,70,"Giocatore");
	}
	public void render(Graphics g) 
	{
		g.drawImage(Game.sfondo.getBufferedImage(), 0,0,Game.GetFrameWidth(),Game.GetFrameHeight(),null);
		g.setColor(Color.white);
		g.setFont(new Font("Century Gothic",Font.BOLD,50));
		g.drawString("Brick Breaker", 125, 220);
		for(int i = 0 ;i<button.length;i++)
		{
			button[i].render(g);
		}
		g.setColor(Color.red);
		g.setFont(new Font("Century Gothic",Font.ITALIC,10));
		g.drawString("Andrea Munarin, Andrea Barisan, Alberto Ballancin",300,600);
		if(Game.Volume) 
		{
			Game.volume=new Sprite("/Menu/volume.png");
			g.drawImage(Game.volume.getBufferedImage(), 40,40,75,75,null);
		}
		if(!Game.Volume) 
		{
			Game.volume=new Sprite("/Menu/volume2.png");
			g.drawImage(Game.volume.getBufferedImage(), 40,40,75,75,null);
		}
	}
	public static void finestra()
	{
		JFrame opzioni = new JFrame("Opzioni Avanzate");
		opzioni.setSize(300,300);
		opzioni.setVisible(true);
	}
}

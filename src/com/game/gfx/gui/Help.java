package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.game.Game;
import com.game.gfx.Sprite;

public class Help 
{
	Button button[];
	Sprite help;
	public Help()
	{
		button = new Button[1];
		help=new Sprite("/Menu/TASTIERA.png");
		button[0]=new Button(10,500,160,90,"back");
	}
	public void render(Graphics g) 
	{
		g.drawImage(help.getBufferedImage(), 0,0,Game.GetFrameWidth(),Game.GetFrameHeight(),null);
		for(int i = 0 ;i<button.length;i++)
		{
			button[i].render(g);
		}
	}

}

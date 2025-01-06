package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.Game;

public class Vincita 
{
	public void render(Graphics g) 
	{
		g.clearRect(0, 0, Game.GetFrameWidth(), Game.GetFrameHeight());
		g.setColor(Color.white);
		g.setFont(new Font("Century Gothic",Font.BOLD,75));
		g.drawString("HAI VINTO", 110, 220);
		g.drawImage(Game.monete.getBufferedImage(), 200, 300,108/2,128/2,null);
		g.setFont(new Font("Century Gothic",Font.ITALIC,35));
		g.drawString(": "+Game.punti/10+"+"+Game.level*10, 260, 340);
	}
}

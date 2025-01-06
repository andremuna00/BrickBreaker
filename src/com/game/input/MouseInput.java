package com.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.game.Game;
import com.game.gfx.gui.Button;

public class MouseInput implements MouseListener,MouseMotionListener {

	
	public static int x;
	public int y;
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		for(int i=0;i<Game.livelli.button.length;i++)
		{
			Button button = Game.livelli.button[i];
			if(x>=button.getX()&&y>=button.getY()&&x<=button.getX()+button.getWidth()&&y<=button.getY()+button.getHeight()) button.TriggeredEvent();
		}
		for(int i=0;i<Game.launcher.button.length;i++)
		{
			Button button = Game.launcher.button[i];
			if(x>=button.getX()&&y>=button.getY()&&x<=button.getX()+button.getWidth()&&y<=button.getY()+button.getHeight()){ button.TriggeredEvent();}
		}
		for(int i=0;i<Game.palline.button.length;i++)
		{
			Button button = Game.palline.button[i];
			if(x>=button.getX()&&y>=button.getY()&&x<=button.getX()+button.getWidth()&&y<=button.getY()+button.getHeight()){ button.TriggeredEvent();}
		}
		for(int i=0;i<Game.giocatore.button.length;i++)
		{
			Button button = Game.giocatore.button[i];
			if(x>=button.getX()&&y>=button.getY()&&x<=button.getX()+button.getWidth()&&y<=button.getY()+button.getHeight()){ button.TriggeredEvent();}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		x=e.getX();
		y=e.getY();
	}

}

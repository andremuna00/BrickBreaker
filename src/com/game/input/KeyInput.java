package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.game.Game;
import com.game.Id;
import com.game.entity.Entity;

public class KeyInput implements KeyListener
{
	int i1=0;
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key= e.getKeyCode();
		
		for(int i=0;i<Game.handler.entity.size();i++)
		{
			Entity en = Game.handler.entity.get(i);
			
			switch(key)
			{
				case KeyEvent.VK_RIGHT:
					if(en.getId()==Id.player) en.setVelX(5);
					break;
				case KeyEvent.VK_LEFT:
					if(en.getId()==Id.player) en.setVelX(-5);
					break;
				case KeyEvent.VK_ENTER:
					if(en.getId()==Id.ball) {Game.stop=false; en.setVelY(Game.getVel());}
					break;
				case KeyEvent.VK_ESCAPE:
					if(Game.Playing==true)
					{
						Game.Playing=false;
						for(int j=0;j<Game.handler.entity.size();j++)
						{
							Entity ent = Game.handler.entity.get(j);
							if(ent.getId()==Id.player) ent.die();
						}
					}
					break;
				case KeyEvent.VK_P:
					if(!Game.Pause&&Game.Playing&&i1==0)
					{
						Game.Pause=true;
						Game.Playing=false;
						i1++;
					}
					if(Game.Pause&&!Game.Playing&&i1==0)
					{
						Game.Pause=false;
						Game.Playing=true;
						i1++;
					}
					break;
				default:
					break;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key= e.getKeyCode();
		for(int i=0;i<Game.handler.entity.size();i++)
		{
			Entity en = Game.handler.entity.get(i);
			
			switch(key)
			{
				case KeyEvent.VK_RIGHT:
					if(en.getId()==Id.player) en.setVelX(0);
					break;
				case KeyEvent.VK_LEFT:
					if(en.getId()==Id.player) en.setVelX(0);
					break;
				case KeyEvent.VK_P:
					i1=0;
					break;
				default:
					break;
			}
		}
	}

}

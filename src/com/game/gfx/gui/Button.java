package com.game.gfx.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.game.Game;
import com.game.gfx.Sprite;

public class Button 
{
	public int x,y;
	public int width,height;
	public static int selected=1;
	public static int selected2=1;
	public String label;

	public Button(int x, int y, int width, int height, String label) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.label = label;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.LAYOUT_LEFT_TO_RIGHT, 30));
		if(getLabel().toLowerCase().contains("pal 1")&&selected==1) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("pal 2")&&selected==2) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("pal 3")&&selected==3) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("pal 4")&&selected==4) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("pal 5")&&selected==5) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("pal 6")&&selected==6) g.drawRect(x, y, width, height);
		
		if(getLabel().toLowerCase().contains("gio 1")&&selected2==1) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("gio 2")&&selected2==2) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("gio 3")&&selected2==3) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("gio 4")&&selected2==4) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("gio 5")&&selected2==5) g.drawRect(x, y, width, height);
		if(getLabel().toLowerCase().contains("gio 6")&&selected2==6) g.drawRect(x, y, width, height);
		
		FontMetrics fm = g.getFontMetrics();
		int StringX=(getWidth()-fm.stringWidth(getLabel()))/2;
		int StringY=(fm.getAscent()+ (getHeight()-(fm.getAscent()+fm.getDescent()))/2);
		if(!getLabel().toLowerCase().contains("vol")&&!getLabel().toLowerCase().contains("gio 1")&&!getLabel().toLowerCase().contains("gio 2")&&!getLabel().toLowerCase().contains("gio 3")&&!getLabel().toLowerCase().contains("gio 4")&&!getLabel().toLowerCase().contains("gio 5")&&!getLabel().toLowerCase().contains("gio 6"))
				g.drawString(getLabel(), getX()+StringX, getY()+StringY);
	}
	
	public void TriggeredEvent()
	{
		if(!Game.Playing&&!Game.schermata_livelli&&!Game.schermata_palline&&!Game.schermata_giocatore&&!Game.schermata_vittoria&&!Game.schermata_help)
		{
			if(getLabel().toLowerCase().contains("inizia il gioco")) {Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			else if(getLabel().toLowerCase().contains("vol")&&Game.Volume==true) {Game.canzone.Stop(); Game.Volume=false; }
			else if(getLabel().toLowerCase().contains("vol")&&Game.Volume==false) {Game.canzone.Play(); Game.Volume=true; }
			else if(getLabel().toLowerCase().contains("livelli")) {Game.schermata_livelli=true;}
			else if(getLabel().toLowerCase().contains("giocatore")) 
			{Game.schermata_giocatore=true;}
			else if(getLabel().toLowerCase().contains("palline")) {Game.schermata_palline=true;}
		}
		if(Game.schermata_livelli&&!Game.Playing)
		{
			if(getLabel().toLowerCase().contains("back")){Game.schermata_livelli=false;}
			if(Game.livello1)if(getLabel().toLowerCase().contains("liv 1")){Game.level=0;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			if(Game.livello2)if(getLabel().toLowerCase().contains("liv 2")){Game.level=1;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			if(Game.livello3)if(getLabel().toLowerCase().contains("liv 3")){Game.level=2;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			if(Game.livello4)if(getLabel().toLowerCase().contains("liv 4")){Game.level=3;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			if(Game.livello5)if(getLabel().toLowerCase().contains("liv 5")){Game.level=4;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
			if(Game.livello6)if(getLabel().toLowerCase().contains("liv 6")){Game.level=5;Game.handler.ClearLevel();Game.stop=true;Game.handler.createLevel(Game.levels[Game.level]);Game.Playing=true;}
		}
		if(Game.schermata_palline&&!Game.Playing)
		{
			if(getLabel().toLowerCase().contains("back")){Game.schermata_palline=false;}
			if(getLabel().toLowerCase().contains("pal 2")&&Game.soldi>=100&&Game.pal2==false)
			{
				Game.soldi-=100;
				Game.pal2=true;
				Game.ball=new Sprite("/Balls/ball2.png");
				selected=2;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3+",2");
					b.flush();
					b.newLine();
					b.write(nextStr4);
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("pal 2")&&Game.pal2==true)
			{
				Game.ball=new Sprite("/Balls/ball2.png");
				selected=2;
			}
			if(getLabel().toLowerCase().contains("pal 3")&&Game.soldi>=150&&Game.pal3==false)
			{
				Game.soldi-=150;
				Game.pal3=true;
				Game.ball=new Sprite("/Balls/ball3.png");
				selected=3;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3+",3");
					b.flush();
					b.newLine();
					b.write(nextStr4);
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("pal 3")&&Game.pal3==true)
			{
				Game.ball=new Sprite("/Balls/ball3.png");
				selected=3;
			}
			if(getLabel().toLowerCase().contains("pal 4")&&Game.soldi>=250&&Game.pal4==false)
			{
				Game.soldi-=250;
				Game.pal4=true;
				Game.ball=new Sprite("/Balls/ball4.png");
				selected=4;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3+",4");
					b.flush();
					b.newLine();
					b.write(nextStr4);
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("pal 4")&&Game.pal4==true)
			{
				Game.ball=new Sprite("/Balls/ball4.png");
				selected=4;
			}
			if(getLabel().toLowerCase().contains("pal 5")&&Game.soldi>=300&&Game.pal5==false)
			{
				Game.soldi-=300;
				Game.pal5=true;
				Game.ball=new Sprite("/Balls/ball5.png");
				selected=5;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3+",5");
					b.flush();
					b.newLine();
					b.write(nextStr4);
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("pal 5")&&Game.pal5==true)
			{
				Game.ball=new Sprite("/Balls/ball5.png");
				selected=5;
			}
			if(getLabel().toLowerCase().contains("pal 6")&&Game.soldi>=350&&Game.pal6==false)
			{
				Game.soldi-=350;
				Game.pal6=true;
				Game.ball=new Sprite("/Balls/ball6.png");
				selected=6;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3+",6");
					b.flush();
					b.newLine();
					b.write(nextStr4);
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("pal 6")&&Game.pal6==true)
			{
				Game.ball=new Sprite("/Balls/ball6.png");
				selected=6;
			}
			if(getLabel().toLowerCase().contains("pal 1"))
			{
				Game.ball=new Sprite("/Balls/balls.png");
				selected=1;
			}
		}
		if(Game.schermata_giocatore&&!Game.Playing)
		{
			if(getLabel().toLowerCase().contains("back")){Game.schermata_giocatore=false;}
			if(getLabel().toLowerCase().contains("gio 2")&&Game.soldi>=100&&Game.gio2==false)
			{
				Game.soldi-=100;
				Game.gio2=true;
				Game.player=new Sprite("/Players/player2.png");
				selected2=2;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
					b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3);
					b.flush();
					b.newLine();
					b.write(nextStr4+",2");
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("gio 2")&&Game.gio2==true)
			{
				Game.player=new Sprite("/Players/player2.png");
				selected2=2;
			}
			if(getLabel().toLowerCase().contains("gio 3")&&Game.soldi>=150&&Game.gio3==false)
			{
				Game.soldi-=150;
				Game.gio3=true;
				Game.player=new Sprite("/Players/player3.png");
				selected2=3;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
			    	b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3);
					b.flush();
					b.newLine();
					b.write(nextStr4+",3");
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("gio 3")&&Game.gio3==true)
			{
				Game.player=new Sprite("/Players/player3.png");
				selected2=3;
			}
			if(getLabel().toLowerCase().contains("gio 4")&&Game.soldi>=250&&Game.gio4==false)
			{
				Game.soldi-=250;
				Game.gio4=true;
				Game.player=new Sprite("/Players/player4.png");
				selected2=4;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
			    	b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3);
					b.flush();
					b.newLine();
					b.write(nextStr4+",4");
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("gio 4")&&Game.gio4==true)
			{
				Game.player=new Sprite("/Players/player4.png");
				selected2=4;
			}
			if(getLabel().toLowerCase().contains("gio 5")&&Game.soldi>=300&&Game.gio5==false)
			{
				Game.soldi-=300;
				Game.gio5=true;
				Game.player=new Sprite("/Players/player5.png");
				selected2=5;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
			    	b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3);
					b.flush();
					b.newLine();
					b.write(nextStr4+",5");
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("gio 5")&&Game.gio5==true)
			{
				Game.player=new Sprite("/Players/player5.png");
				selected2=5;
			}
			if(getLabel().toLowerCase().contains("gio 6")&&Game.soldi>=350&&Game.gio6==false)
			{
				Game.soldi-=350;
				Game.gio6=true;
				Game.player=new Sprite("/Players/player6.png");
				selected2=6;
				try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
				String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2= Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				BufferedWriter b;
				try {Game.w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}
			    b=new BufferedWriter (Game.w);
			    try 
			    {
			    	b.write(nextStr1);
					b.flush();
					b.newLine();
					b.write("Monete: "+Game.soldi);
					b.flush();
					b.newLine();
					b.write(nextStr3);
					b.flush();
					b.newLine();
					b.write(nextStr4+",6");
					b.flush();
				} catch (IOException e) {e.printStackTrace();}
			}
			if(getLabel().toLowerCase().contains("gio 6")&&Game.gio6==true)
			{
				Game.player=new Sprite("/Players/player6.png");
				selected2=6;
			}
			if(getLabel().toLowerCase().contains("gio 1"))
			{
				Game.player=new Sprite("/Players/player1.png");
				selected2=1;
			}
		}
		if(Game.schermata_help&&!Game.Playing)
		{
			if(getLabel().toLowerCase().contains("back")){Game.schermata_help=false;}
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
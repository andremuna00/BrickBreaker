
package com.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import com.game.entity.Entity;
import com.game.gfx.Sprite;
import com.game.gfx.gui.Giocatore;
import com.game.gfx.gui.Help;
import com.game.gfx.gui.Launcher;
import com.game.gfx.gui.Levels;
import com.game.gfx.gui.Palline;
import com.game.gfx.gui.Vincita;
import com.game.input.KeyInput;
import com.game.input.MouseInput;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static BufferedReader filebuf =  null; 
	public static FileWriter w = null;
	private static Graphics g;
	private static final int WIDTH = 111;
	private static final int HEIGHT = 125;
	private static final int SCALE = 5;
	private static final String TITLE = "Progetto - informatica";
	private static int vel=4;
	public static int punti=0;
	public static int soldi=0;
	public static int numeroBall=0;
	public static int fire_cont=0;
	public static int cont=0;
	public static boolean Tastiera=false;
	public static boolean Mouse=true;
	public static boolean stop=true;
	public static boolean schermata_livelli=false;
	public static boolean schermata_giocatore=false;
	public static boolean schermata_palline=false;
	public static boolean schermata_vittoria=false;
	public static boolean schermata_help=false;
	public static boolean Pause=false;
	public static boolean firable=false;
	
	
	public static boolean livello1=true;
	public static boolean livello2=false;
	public static boolean livello3=false;
	public static boolean livello4=false;
	public static boolean livello5=false;
	public static boolean livello6=false;
	
	public static boolean pal1=true;
	public static boolean pal2=false;
	public static boolean pal3=false;
	public static boolean pal4=false;
	public static boolean pal5=false;
	public static boolean pal6=false;
	
	public static boolean gio1=true;
	public static boolean gio2=false;
	public static boolean gio3=false;
	public static boolean gio4=false;
	public static boolean gio5=false;
	public static boolean gio6=false;
	
	public static int level=0;
	
	public static int getVel() {return vel;}

	public static void setVel(int vel) {Game.vel = vel;}

	private Thread thread;
	public static Launcher launcher;
	public static Handler handler;
	private static MouseInput mouse;
	public static Levels livelli;
	public static Giocatore giocatore;
	public static Palline palline;
	public static Vincita vincita;
	public static Help help;
	
	private static boolean running = false;
	public static boolean Playing= false;
	public static boolean Canzone=true;
	public static boolean Volume=true;
	
	public static BufferedImage levels[];
	public static Sprite monete;
	public static Sprite sfondo_livello[];
	public static Sprite breakable[];
	public static Sprite blue;
	public static Sprite red;
	public static Sprite yellow;
	public static Sprite green;
	public static Sprite violet;
	public static Sprite light_blue;
	public static Sprite acqua;
	public static Sprite orange;
	public static Sprite unbreak;
	public static Sprite player;
	public static Sprite ball;
	public static Sprite poweredball;
	public static Sprite powerup;
	public static Sprite fire;
	public static Sprite sfondo;
	public static Sprite volume;
	public static Sound canzone;
	
	public Game ()
	{
		Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	private void init()
	{
		try {filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
		String nextStr1 = null;
		String nextStr2 = null;
		String nextStr3 = null;
		String nextStr4 = null;
		try {nextStr1 = filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
		try {nextStr2 = filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
		try {nextStr3 = filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
		try {nextStr4 = filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
		if(nextStr1.contains("Livello sbloccato:"))
		{
			System.out.println(nextStr1);
			if(nextStr1.contains("1")) livello1=true;
			if(nextStr1.contains("2")) livello2=true; 
			if(nextStr1.contains("3")) {livello2=true; livello3=true;}
			if(nextStr1.contains("4")) {livello2=true; livello3=true; livello4=true;}
			if(nextStr1.contains("5")) {livello2=true; livello3=true; livello4=true; livello5=true;}
			if(nextStr1.contains("6")) { livello2=true; livello3=true; livello4=true; livello5=true; livello6=true;}
		}
		if(nextStr2.contains("Monete:"))
		{
			System.out.println(nextStr2);
			soldi=Integer.parseInt(nextStr2.substring(8, nextStr2.length()));
		}
		if(nextStr3.contains("Palline sbloccate:"))
		{
			System.out.println(nextStr3);
			if(nextStr3.contains("1")) pal1=true;
			if(nextStr3.contains("2")) pal2=true; 
			if(nextStr3.contains("3")) {pal3=true;}
			if(nextStr3.contains("4")) {pal4=true;}
			if(nextStr3.contains("5")) {pal5=true;}
			if(nextStr3.contains("6")) {pal6=true;}
		}
		
		if(nextStr4.contains("Giocatori sbloccati:"))
		{
			System.out.println(nextStr4);
			if(nextStr4.contains("1")) gio1=true;
			if(nextStr4.contains("2")) gio2=true; 
			if(nextStr4.contains("3")) { gio3=true;}
			if(nextStr4.contains("4")) { gio4=true;}
			if(nextStr4.contains("5")) {gio5=true;}
			if(nextStr4.contains("6")) {gio6=true;}
		}
		launcher = new Launcher();
		handler = new Handler();
		mouse = new MouseInput();
		livelli=new Levels();
		giocatore=new Giocatore();
		palline=new Palline();
		vincita=new Vincita();
		help=new Help();
		levels=new BufferedImage[6];
		
		addKeyListener(new KeyInput());
		addMouseMotionListener(mouse);
		addMouseListener(mouse);
		
		monete=new Sprite("/PowerUp/Coin.png");
		breakable = new Sprite[3];
		sfondo_livello=new Sprite[6];
		breakable[2] = new Sprite("/blocks/break2.png");
		breakable[1] = new Sprite("/blocks/break1.png");
		breakable[0] = new Sprite("/blocks/break0.png");
		blue = new Sprite("/blocks/blue.png");
		red = new Sprite("/blocks/red.png");
		yellow = new Sprite("/blocks/yellow.png");
		green = new Sprite("/blocks/green.png");
		light_blue = new Sprite("/blocks/light_blue.png");
		violet = new Sprite("/blocks/violet.png");
		acqua = new Sprite("/blocks/acqua.png");
		orange = new Sprite("/blocks/orange.png");
		unbreak = new Sprite("/blocks/unbreak.png");
		player = new Sprite("/Players/player1.png");
		ball= new Sprite("/balls/balls.png");
		poweredball= new Sprite("/balls/balls2.png");
		sfondo_livello[0]=new Sprite("/Livello/sfondo1.jpg");
		sfondo_livello[1]=new Sprite("/Livello/sfondo2.jpg");
		sfondo_livello[2]=new Sprite("/Livello/sfondo3.jpg");
		sfondo_livello[3]=new Sprite("/Livello/sfondo4.jpg");
		sfondo_livello[4]=new Sprite("/Livello/sfondo5.jpg");
		sfondo_livello[5]=new Sprite("/Livello/sfondo6.jpg");
		powerup=new Sprite("/PowerUp/powerup.png");
		fire=new Sprite("/PowerUp/fire.png");
		sfondo=new Sprite("/Menu/sfondo.jpg");
		volume=new Sprite("/Menu/volume.png");
		canzone=new Sound("/Menu/Centuries.wav");

		try 
		{
			levels[0]=ImageIO.read(getClass().getResourceAsStream("/Livello/level0.png"));
			levels[1]=ImageIO.read(getClass().getResourceAsStream("/Livello/level1.png"));
			levels[2]=ImageIO.read(getClass().getResourceAsStream("/Livello/level2.png"));
			levels[3]=ImageIO.read(getClass().getResourceAsStream("/Livello/level3.png"));
			levels[4]=ImageIO.read(getClass().getResourceAsStream("/Livello/level4.png"));
			levels[5]=ImageIO.read(getClass().getResourceAsStream("/Livello/level5.png"));
		} 
		catch (IOException e) {e.printStackTrace();}
		handler.createLevel(levels[level]);
	}
	
	
	private synchronized void start()
	{	
		if(running) return;
		running=true;
		thread=new Thread(this,"Thread");
		thread.start();
	}
	
	private synchronized void stop()
	{
		if(!running) return;
		running=false;
		
		try{thread.join();} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void run()
	{
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta=0;
		double ns = 1000000000.0/60.0;
		int frames=0;
		int ticks =0;
		while(running)
		{
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1)
			{
				tick();
				ticks++;
				delta--;
			}
			
			render();
			
			frames++;
			if(System.currentTimeMillis()-timer >1000){
				timer+=1000;
				System.out.print("Frame per Second: "+frames);
				System.out.println("  Tick per Second: "+ticks);
				frames=0;
				ticks=0;
			}
		}
		stop();
	}
	
	

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		g= bs.getDrawGraphics();
		
		if(Playing){g.clearRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE); g.drawImage(sfondo_livello[level].getBufferedImage(), 0, 0, GetFrameWidth(), GetFrameHeight(),null);handler.render(g);}
		else if(!Playing&&!schermata_livelli&&!Pause&&!schermata_palline&&!schermata_giocatore&&!schermata_vittoria) launcher.render(g);
		if(schermata_livelli&&!Playing&&!Pause){livelli.render(g);}
		if(schermata_palline&&!Playing&&!Pause){palline.render(g);}
		if(schermata_giocatore&&!Playing&&!Pause){giocatore.render(g);}
		if(schermata_vittoria&&!Playing&&!Pause){vincita.render(g);}
		if(schermata_help&&!Playing&&!Pause){help.render(g);}
		if(Pause){g.setFont(new Font("Century Gothic", Font.ITALIC, 30)); g.drawString("||", Game.GetFrameWidth()/2, Game.GetFrameHeight()/2);}
		g.dispose();
		bs.show();
	}
	
	public void tick()
	{
		if(level==1) livello2=true;
		if(level==2) livello3=true;
		if(level==3) livello4=true;
		if(level==4) livello5=true;
		if(level==5) livello6=true;
		if(Game.schermata_vittoria&&cont<300)
		{
			cont++;
		}
		if(Game.schermata_vittoria&&cont>=300)
		{
			cont=0;
			Game.schermata_vittoria=false;
			Game.Playing=true;
			punti=0;
		}
		
		
		if(firable==true)
		{
			fire_cont++;
		}
		if(fire_cont>=120)
		{
			fire_cont=0;
			firable=false;
		}
		if(Canzone)
		{
			canzone.Play();
			canzone.infinity();
			Canzone=false;
		}
		
		if(Playing) handler.tick();
		if(Playing) 
			if((handler.tile.size()-handler.unbreakblock)==0) 
			{
				soldi+=(punti/10+level*10);
				SwitchLevel();
				Game.Playing=false;
				Game.schermata_vittoria=true;
			}
	}
	
	public static void Azzera()
	{

	    try {w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}

	    BufferedWriter b;
	    b=new BufferedWriter (w);

	    try {
			b.write("Livello sbloccato: 1");
			b.flush();
			b.newLine();
			b.write("Monete: 0");
			b.flush();
			b.newLine();
			b.write("Palline sbloccate: 1");
			b.flush();
			b.newLine();
			b.write("Giocatori sbloccati: 1");
			b.flush();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public static void SwitchLevel()
	{
		if(level!=5)
		{
		level++;
		if((level+1==2&&livello2==true)||(level+1==3&&livello3==true)||(level+1==4&&livello4==true)||(level+1==5&&livello5==true)||(level+1==6&&livello6==true))
		{
			try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
			String nextStr1 = null;
			String nextStr2 = null;
			String nextStr3 = null;
			String nextStr4 = null;
			try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
			try {nextStr2 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
			try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
			try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
			try {w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}

    		BufferedWriter b;
    		b=new BufferedWriter (w);
    		try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
			
    		try 
    		{
	    	
	    		b.write(nextStr1);
	    		b.flush();
	    		b.newLine();
	    		b.write("Monete: "+soldi);
	    		b.flush();
	    		
	    		b.newLine();
	    		b.write(nextStr3);
	    		b.flush();
	    		b.newLine();
	    		b.write(nextStr4);
	    		b.flush();
    		} 
    		catch (IOException e) {e.printStackTrace();}
		}
    	else
    	{	
    		try {Game.filebuf=new BufferedReader(new FileReader("salvataggi.txt"));} catch (FileNotFoundException e2) {e2.printStackTrace();}
    		String nextStr1 = null;
				String nextStr2 = null;
				String nextStr3 = null;
				String nextStr4 = null;
				try {nextStr1 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr2 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr3 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
				try {nextStr4 = Game.filebuf.readLine();} catch (IOException e1) {e1.printStackTrace();}
    		try {w=new FileWriter("salvataggi.txt");} catch (IOException e) {e.printStackTrace();}

    		BufferedWriter b;
    		b=new BufferedWriter (w);
    		
    		try 
    		{
	    	
	    		b.write("Livello sbloccato:");
	    		b.write(Integer.toString(level+1));
	    		b.flush();
	    		b.newLine();
	    		b.write("Monete: "+soldi);
	    		b.flush();
	    		b.newLine();
	    		b.write(nextStr3);
	    		b.flush();
	    		b.newLine();
	    		b.write(nextStr4);
	    		b.flush();
    		} 
    		catch (IOException e) {e.printStackTrace();}

    	}
		
		handler.ClearLevel();
		stop=true;
		handler.createLevel(levels[level]);
		}
		else
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
	
	public static int GetFrameWidth(){return WIDTH*SCALE;}
	
	public static int GetFrameHeight() { return HEIGHT*SCALE;}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		menuBar = new JMenuBar();

		menu = new JMenu("Menu");
		menuBar.add(menu);

		menuItem = new JMenuItem("Inizia il gioco", KeyEvent.VK_T);
		menuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Game.Playing=true;
			}
			
		});
		menu.add(menuItem);
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Help");
		menuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				schermata_help=true;
				
			}
			
		});
		menu.add(menuItem);
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Esci dal gioco", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		menu.add(menuItem);
		
		menu = new JMenu("Opzioni");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);
		
		submenu = new JMenu("Difficoltà");
		submenu.setMnemonic(KeyEvent.VK_S);

		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("facile");
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVel(2);
			}
			
		});
		submenu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("medio");
		rbMenuItem.setSelected(true);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVel(4);
			}
			
		});
		submenu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("difficile");
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVel(6);
			}
			
		});
		submenu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("molto difficile");
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVel(8);
			}
			
		});
		submenu.add(rbMenuItem);
		
		menu.add(submenu);

		submenu = new JMenu("Movimenti");
		submenu.setMnemonic(KeyEvent.VK_S);

		ButtonGroup group2 = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Tastiera");
		group2.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Tastiera=true;
				Mouse=false;
			}
			
		});
		submenu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Mouse");
		rbMenuItem.setSelected(true);
		group2.add(rbMenuItem);
		rbMenuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Mouse=true;
				Tastiera=true;
			}
			
		});
		submenu.add(rbMenuItem);
		
		menu.add(submenu);
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Azzera il gioco");
		menuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Azzera();
				System.exit(0);
			}
			
		});
		menu.add(menuItem);
		
menu.addSeparator();
		
		/*menuItem = new JMenuItem("Opzioni Avanzate");
		menuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Launcher.finestra();
				
			}
			
		});
		menu.add(menuItem);*/
		
		ImageIcon icon=new ImageIcon("/volume.jpg");
		JButton volume = new JButton(icon); 
		JPanel pan=new JPanel();
		pan.setBounds(100,100,300,300);
		pan.add(volume);
		
		frame.setJMenuBar(menuBar);
		frame.add(pan);
		frame.setVisible(true);
		
		game.start();
	}

}


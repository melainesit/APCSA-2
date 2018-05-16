//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Bullets shots;

	private int tick;

	private AlienHorde horde;
	private boolean[] keys;
	private BufferedImage back;
	private EliteAlienHorde eliteHorde;
	private Alien alienone;	
	private Alien alientwo;
	
	public OuterSpace() {
		setBackground(Color.black);

		keys = new boolean[5];

		ship = new Ship(400, 500, 35, 35, 2);
		
		int hordeWidth = 5;
		int hordeHeight = 3;
		int hordeSize = hordeWidth * hordeHeight;
		
		alienone = new Alien(30,30,1);
		alientwo = new Alien(30,30,1);
		
		eliteHorde = new EliteAlienHorde(1);
		horde = new AlienHorde(hordeSize);
		shots = new Bullets();
		
		for(int x = 5; x < StarFighter.WIDTH - 100; x += (StarFighter.WIDTH) / 5)
			for(int y = 22; y < StarFighter.HEIGHT / 1.5 - 100; y += (StarFighter.HEIGHT / 1.5) / 4)
				horde.add(new Alien(x + 10, y, 25, 25, 1));

		for (int x = 8; x < StarFighter.WIDTH-100 ; x += (StarFighter.WIDTH) /8 )
			for (int y = 325; y < StarFighter.HEIGHT / 1.5-50; y += (StarFighter.HEIGHT / 1.5) / 4)
				eliteHorde.add(new EliteAlien(x , y-20, 30, 30, 1));
		
		
		this.addKeyListener(this);
		new Thread(this).start();
//
		

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		alienone.setX(alienone.getX() + alienone.getSpeed());

		alienone.draw(window);

		
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		tick++;

		// processInputs
		if (keys[0] == true) {
			ship.move("LEFT");
		}
		if (keys[1] == true) {
			ship.move("RIGHT");
		}
		if (keys[2] == true) {
			ship.move("UP");
		}
		if (keys[3] == true) {
			ship.move("DOWN");
		}
		if (keys[4] == true) {
			if (tick >= 70) {
				shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 2, ship.getY(), 5));
				tick = 0;
			}
		}

		// update
		horde.moveEmAll();
		eliteHorde.moveEmAll();
		shots.moveEmAll();
		horde.removeDeadOnes(shots.getList());
		eliteHorde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();
		horde.checkShipDeath(ship);
		eliteHorde.checkShipDeath(ship);

		if (horde.getSize() == 0) {
			System.out.println("You win!");
			System.exit(0);
		}

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString(""+horde.getSize(), 740, 530);
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);
		eliteHorde.drawEmAll(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[4] = false;
		}
		repaint();
		
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}


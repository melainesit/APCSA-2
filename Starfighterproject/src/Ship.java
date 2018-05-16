//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(40,40,40,40,1);
	}

	public Ship(int x, int y)
	{
		this(x, y, 40, 40, 1);
	}

	public Ship(int x, int y, int s)
	{
		this(x, y, 40, 40, s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			
			image = ImageIO.read(new File("C:\\Users\\sitm3033\\Documents\\GitHub\\APCSA-2\\Starfighterproject\\src\\ship.jpg"));
		}
		catch(Exception e)
		{
			
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;	
	}

	public int getSpeed()
	{
	   return speed;
	}
	public void move(String direction) {

		// remember that 0,0 is in top left of screen
		if (direction.equals("LEFT")) {
			setX(getX() - speed);
		} else if (direction.equals("RIGHT")) {
			setX(getX() + speed);
		} else if (direction.equals("UP")) {
			setY(getY() - speed);
		} else if (direction.equals("DOWN")) {
			setY(getY() + speed);
		}
	}


	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(), getWidth(), getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}

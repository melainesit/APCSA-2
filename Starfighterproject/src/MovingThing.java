//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public MovingThing()
	{
		xPos = 10;
		yPos = 10;
		width = 10;
		height = 10;
	}

	public MovingThing(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
	}

	public MovingThing(int x, int y, int w, int h)
	{
		setX(x-w/2);
		setY(y-w/2);
		setWidth(w);
		setHeight(h);
	}
	public boolean isCollidingMT(MovingThing mt) {
		// check collision at central left, right, top, and bottom
		if (partialCollision(this.getX(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY(), mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight(), mt))
			return true;
		return false;
	}
	private boolean partialCollision(int pointX, int pointY, MovingThing mt) {
		return pointX > mt.getX() && pointX < mt.getX() + mt.getWidth() && pointY > mt.getY()
				&& pointY < mt.getY() + mt.getHeight();
	}
	public void setPos( int x, int y)
	{
		xPos= x;
		yPos =y;
	}

	public void setX(int x)
	{
		xPos= x;
	}

	public void setY(int y)
	{
		yPos =y;
	}

	public int getX()
	{
		return xPos;   //finish this method
	}

	public int getY()
	{
		return yPos;  //finish this method
	}

	public void setWidth(int w)
	{
		width = w;
	}

	public void setHeight(int h)
	{
		height =h;
	}

	public int getWidth()
	{
		return width;  //finish this method
	}

	public int getHeight()
	{
		return height;  //finish this method
	}
	public abstract void setSpeed( int s );
	public abstract int getSpeed();

	public abstract void move(String direction);
	public abstract void draw(Graphics window);

	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}
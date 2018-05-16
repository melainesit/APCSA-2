
//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class - 
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h, Color col, int xS, int yS)
	{
		super(x, y, w, h, col);
		setXSpeed(xS);
		setYSpeed(yS);
	}
	
	//SET METHODS
	public void setXSpeed(int xS) {
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS) {
		ySpeed = yS;
	}
	
	//GET METHODS
	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}

	//OTHER METHODS
	public void moveAndDraw(Graphics window)
	{
		Color temp = getColor();
		draw(window, Color.WHITE);
		setPos(getx()+getXSpeed(), gety()+getYSpeed());
		draw(window, temp);
	}

	public boolean equals(Object obj)
	{
		Ball other = (Ball) obj;
		return super.equals(other)
				&& this.getXSpeed() == other.getXSpeed()
				&& this.getYSpeed() == other.getYSpeed();
	}

	//IMPLEMENTED FROM COLLIDABLE
	public boolean didCollideLeft(Object obj) {
		Wall other = (Wall) obj;
		return this.getx() <= other.getLeft();
	}
	
	public boolean didCollideRight(Object obj) {
		Wall other = (Wall) obj;
		return this.getx() >= other.getRight();
	}
	
	public boolean didCollideTop(Object obj) {
		Wall other = (Wall) obj;
		return this.gety() <= other.getTop();
	}

	public boolean didCollideBottom(Object obj) {
		Wall other = (Wall) obj;
		return this.gety()+9  >= other.getBottom();
	}
	
	public String toString() {
		return super.toString() +" "+ getXSpeed() +" "+ getYSpeed();
	}
}
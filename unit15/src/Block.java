//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{


	}
	
	
	public Block (int x, int y){
		setx(x);
		sety(y);
		color = Color.BLACK;
	}
	public Block(int x,int y,int width,int height)
	{
		setx(x);
		sety(y);
		setwidth(width);
		setheight(height);
		color = Color.BLACK;
		
		
	}
	public Block(int x,int y,int width1,int height1, Color color)
	{
		setx(x);
		sety(y);
		setwidth(width1);
		setheight(height1);
		setColor(color);
		
		
	}
	public void setPos( int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	public void setx(int x)
	{
		xPos=x;
	}
	public void sety(int y)
	{
		yPos=y;
	}
	public void setwidth(int width1)
	{
		width=width1;
	}
	public void setheight(int height1)
	{
		height=height1;
	}
	public void setColor(Color col)
	   {
			color = col;
	   }
	//add other Block constructors - x , y , width, height, color
	public int getx()
	{
		return xPos;
	}
	public int gety()
	{
		return yPos;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public Color getColor()
	{
		return color;
	}
	
	
   //add the other set methods
  

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getx(), gety(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	      window.fillRect(getx(), gety(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{	
		Block a = (Block) obj;
		if (a.getx() ==this.getx() && a.gety()==this.gety() && a.getWidth()==this.getWidth() && a.getHeight()==this.getHeight() && a.getColor() == this.getColor())
			return true;

		return false;
	}   

   //add the other get methods
    public String toString()
    {
    	return getx() + " "  + gety() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }

   //add a toString() method  - x , y , width, height, color
}
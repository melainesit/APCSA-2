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

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;		//keeps track of what keys are pressed
	private int rightScore, leftScore;

	public PaddleTestTwo()
	{
		//set up all game variables


		//instantiate a Ball
		
		ball = new Ball(100, 100, 10, 10);
		leftPaddle = new Paddle(10, 0, 10, 50, Color.BLACK, 3);
		rightPaddle = new Paddle(750, 20, 10, 50 , Color.BLACK,3);
		


		keys = new boolean[5];


		//set up the Canvas
		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);
		window.setColor(Color.RED);
		window.drawString("rightScore: " + rightScore, 400,530 );
		window.setColor(Color.RED);
		window.drawString("leftScore: " + leftScore, 400,550 );
		
		if (ball.getx() <= leftPaddle.getx() + leftPaddle.getWidth()){
			window.setColor(Color.WHITE);
			window.drawString("rightScore: " + rightScore, 400,530 );
			rightScore++;
			window.setColor(Color.RED);
			window.drawString("rightScore: " + rightScore, 400,530 );
		
			ball.draw(window, Color.WHITE);
			ball.setPos(500,  300);}
		
		if (ball.getx() + ball.getWidth() >= rightPaddle.getx()) 	
		{
			window.setColor(Color.WHITE);
			window.drawString("leftScore: " + leftScore, 400,550 );
			leftScore++;
			window.setColor(Color.RED);
			window.drawString("leftScore: " + leftScore, 400,550 );
		
			ball.draw(window, Color.WHITE);
			ball.setPos(500,  300);
		}


		if(!(ball.getx()>=10 && ball.getx()<=550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.gety()>=10 && ball.gety()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveDownAndDraw(window);		
			}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(window);
		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);

		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);

		}
	}


	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;
		}
	
	if (ball.didCollideLeft(leftPaddle)){
		if(ball.getx() <= leftPaddle.getx() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed() )){
			ball.setYSpeed(-ball.getYSpeed());
		}
		else{
			ball.setXSpeed(-ball.getXSpeed());
		}
	}
	if (ball.didCollideRight(rightPaddle)){
		if(ball.getx() + ball.getWidth() >= rightPaddle.getx() + Math.abs(ball.getXSpeed() )){
			ball.setYSpeed(-ball.getYSpeed());
		}
		else
			ball.setXSpeed(-ball.getXSpeed());
	}
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
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}		
}
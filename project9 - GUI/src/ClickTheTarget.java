import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
Name: Kyle Pamintuan
Date: 12-8-15
Purpose: To show the use of GUI
Inputs: Mouse click
Outputs: Click score
*/

public class ClickTheTarget extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	JFrame frame = new JFrame();
	
	public ClickTheTarget()
	{
		ImagePanel imagePanel = new ImagePanel();	//This variable includes the image and everything relative to it
		frame.add(imagePanel);		//Add the variable it to the JFrame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);	//Set frame width & height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{   
		//Start the program
		ClickTheTarget test = new ClickTheTarget();
	}
}

class ImagePanel extends JPanel implements MouseListener
{
	private ImageIcon target = new ImageIcon("target.jpg");	//Grab the image from files
	private Image image =  target.getImage();	//Put that image into an Image variable
	private int imageWidth, imageHeight;
	private int x, y, count;
	Random randomGenerator = new Random();	//RNG for randomizing the position of the image
	JLabel label = new JLabel();	//Label for the click score
	Timer t;	//Timer for the speed of the image movement
	
	public ImagePanel()
	{
		//Set Variables
		imageWidth = target.getIconWidth();
		imageHeight = target.getIconHeight();
		x = 0;
		y = 0;
		count = 0;
		add(label);		//Add label
		label.setText("Count: " + count);	//Set label
		
		//This moves the image's position and repaints it to make it visable
		ActionListener act = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				move();
				repaint();
			}
		};
		
		//Start moving the image
		t = new Timer(1000, act);
		t.start();
		
		//Start tracking the mouse's activity
		addMouseListener(this);
	}
	
	//Re-position the image
	public void move()
	{
		x = randomGenerator.nextInt(800 - imageWidth);
		y = randomGenerator.nextInt(600 - imageHeight);
	}
	
	//Paint the image (make visible)
	protected void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		if (image != null)
			g.drawImage(image, x, y, this);
	}
	
	//These methods keep track of the activity of the mouse and what to do when these actions are performed
	public void mouseClicked(MouseEvent event) 
	{
		Point p = new Point(event.getX(), event.getY());
		Rectangle r = new Rectangle(x, y, imageWidth, imageHeight);
		
		//If target is clicked...
		if(r.contains(p))
		{
			count++;	//Increase score
			label.setText("Count: " + count); //Print score
			
			if(count == 5) //If score reaches 5, increase image speed
			{
				t.setDelay(700);
			}
			else if(count == 10) //If score reaches 5, increase image speed again
			{
				//imageHeight = 100;
				//imageWidth = 100;
				t.setDelay(600);
			}
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Actor {
	private int direction;
	private Location location;

	private Image image;


	public Actor(int direction, Location location)
	{
		this.direction = direction;
		this.location = location;
		ImageIcon testActor = new ImageIcon("fish.gif"); 
		image = testActor.getImage();
	}
    public Image getImage()
    {
    	return image;
    }
	public int getDirection()
	{
		return direction;
	}

	public Location getLocation()
	{ 
		return location;
	}

	public void setDirection(int dir)
	{
		direction = dir;
	}

	public void setLocation(Location loc)
	{
		location = loc;
	}

	public void moveForward()
	{
		//to be implemented
	}

	public void faceUp()
	{
		direction = 0;
	}

	public void faceRight()
	{
		direction = 90;
	}

	public void faceLeft()
	{
		direction = 270;
	}

	public void faceBack()
	{
		direction = 180;
	}

	public boolean canMove()
	{
		//to be implemented
		return true;
	}

	public void paint(Graphics g)
	{
		
	}
}
 




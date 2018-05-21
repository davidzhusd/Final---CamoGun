
public class Actor {
	private int direction;
	private Location location;
	
	public Actor(int direction, Location location)
	{
		this.direction = direction;
		this.location = location;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public void setDirection(dir)
	{
		direction = dir;
	}
	
	public void setLocation(loc)
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
	
	public boolean canMove();
	{
		//to be implemeted
		return true;
	}
	}
	
}

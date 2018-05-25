import java.awt.Image;


public class Player extends Actor
{
	
	private int direction;
	private Location location;
	private Image image;
	public Player(int direction, Location location)
	{
		super(direction, location);
	}
	public void moveLeft()
	{
		location=new Location(location.getRow(),location.getCol()-1);
	}
	public void moveRight()
	{
		location=new Location(location.getRow(),location.getCol()+1);

	}
	public void moveUp()
	{
		location=new Location(location.getRow()-1, location.getCol());
	}
	public void moveDown()
	{
		location =new Location(location.getRow()+1, location.getCol());
	}
	public void shoot()
	{
		Bullet bul=new Bullet(getDirection(),getLocation());
	}
	
}

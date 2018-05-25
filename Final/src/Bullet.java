import java.awt.Image;


public class Bullet extends Actor
{
	private int direction;
	private Location location;
	private Image image;
	public Bullet(int dir, Location loc)
	{
		super(dir, loc);
		
	}
}

import java.awt.Image;


public class bullet extends Actor
{
	private int direction;
	private Location location;
	private Image image;
	public bullet(int dir, Location loc)
	{
		super(dir, loc);
	}
}

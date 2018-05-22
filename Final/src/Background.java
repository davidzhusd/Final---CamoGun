import java.awt.Image;
import javax.swing.ImageIcon;

public class Background {

private Location myLoc;
private Image image;

public Background(Location loc)
{
	myLoc = loc;
	ImageIcon testBackground = new ImageIcon ("grass.jpg");
	image = testBackground.getImage();
}

public Location getLocation()
{
	return myLoc;
}

public void setLocation(Location loc)
{
	myLoc = loc;
}


}
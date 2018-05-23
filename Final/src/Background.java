import java.awt.Image;
import javax.swing.ImageIcon;

public class Background {

private Location myLoc;
private Image image;

public Background(Location loc)
{
	myLoc = loc;

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
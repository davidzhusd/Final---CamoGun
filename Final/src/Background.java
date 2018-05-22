import java.awt.Image;


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
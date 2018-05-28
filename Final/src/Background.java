import java.awt.Image;
import javax.swing.ImageIcon;

public class Background {

    private ImageIcon backgroundImage;
    private Image image;

    public Background() {
    backgroundImage = new ImageIcon("brick-wall.jpg");
    image = backgroundImage.getImage();
    }

    public Image getImage() {
        return image;
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    /*
public Location getLocation()
{
	return myLoc;
}

public void setLocation(Location loc)
{
	myLoc = loc;
}

*/
}
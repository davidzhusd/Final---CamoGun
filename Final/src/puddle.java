import java.awt.Image;

import javax.swing.ImageIcon;


public class puddle extends Background{


private Image image;

public puddle(Location loc)
{
	super(loc);
	ImageIcon testBackground = new ImageIcon ("puddle.jpg");
	image = testBackground.getImage();
}
}

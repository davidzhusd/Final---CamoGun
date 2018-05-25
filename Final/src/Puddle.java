import java.awt.Image;

import javax.swing.ImageIcon;


public class Puddle extends Background{


private Image image;

public Puddle(Location loc)
{
	super(loc);
	ImageIcon testBackground = new ImageIcon ("puddle.jpg");
	image = testBackground.getImage();
}
}

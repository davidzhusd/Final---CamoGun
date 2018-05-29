import javax.swing.ImageIcon;
public class Wall extends Actor
{
	private int direction;
	private ImageIcon image;
	public Wall()
	{
		super();
		image = new ImageIcon("brick-wall-pls.png");
	}

	public ImageIcon getImage() {
		return image;
	}
}


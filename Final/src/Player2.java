import javax.swing.ImageIcon;
public class Player2 extends Player
{
	private int direction;
	private ImageIcon image;
	public Player2(int direction)
	{
		super(direction);
		image = new ImageIcon("player2.png");

	}

	public ImageIcon getImage() {
		return image;
	}
}

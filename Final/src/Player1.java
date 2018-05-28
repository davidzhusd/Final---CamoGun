import javax.swing.ImageIcon;
public class Player1 extends Player
{
	private int direction;
	private ImageIcon image;
	public Player1(int direction)
	{
		super(direction);
		image = new ImageIcon("player1.png");
	}

	public ImageIcon getImage() {
		return image;
	}
}

import java.awt.Graphics;

import javax.swing.JFrame;


public class Game extends JFrame{
//	Grid gr;
	Actor player;
	public Game()
	{
		player = new Actor(0, new Location(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		setSize(1000, 1000);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(player.getImage(), 100, 100, this);
	}
}

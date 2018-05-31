
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Instructions extends JFrame{
	public Instructions() 
	{
		JTextArea text = new JTextArea(10, 20);
		text.setLineWrap(true);
		text.setEditable(false);
		text.setText("Instructions:\n"
				+ "Player 1 starts at top left corner, move with WASD, and shoot with the SPACE key.\n"
				+ "Player 2 starts at bottom right corner, move with arrow keys, and shoot with L\n"
				+ "Players turn invisible after 3 seconds and remain so until a players fires a bullet.\n"
				+ "When a player moves through bushes and puddles, the bushes will rustle and the puddles will splash.\n"
				+ "Brick walls are unbreakable, but wooden ones can be broken by bullets.\n"
				+ "A player will be revealed if they do not do anything for 5 seconds.\n There are items, a shield that "
				+ "blocks one bullet, \nand also another item that reveals the other player for 7 seconds.\n"
				+ "The goal is to deduce where the other player is and eliminate them stealthily.");
		add(text);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setVisible(true);
	}
}


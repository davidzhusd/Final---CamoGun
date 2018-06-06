import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Credits extends JFrame {
	JTextArea text = new JTextArea(10, 20);
	public Credits() {
		text.setLineWrap(true);
		text.setEditable(false);
		text.setText("Game Desginers: Richard Chen, David Zhu, Yang Song, Wenzhe Zhang\n"
				+ "Websites used:\n"
				+ "https://pixlr.com/editor/\n"
				+ "https://opengameart.org/content/basic-map-32x32-by-silver-iv\n"
				+ "https://toen.itch.io/toens-medieval-strategy\n "
				+ "https://www.iconspng.com/images/brick-wall/brick-wall.jpg \n"
				+ "http://gamedesign.wikidot.com/spriteart:sprite-art-101-brick-wall-i\n"
				+ "https://opengameart.org/content/animated-top-down-survivor-player\n"
				+ "https://opengameart.org/content/bullet-collection-2-m484-games\n"
				+ "https://opengameart.org/content/bullet-collection-1-m484\n"
				+ "https://opengameart.org/content/magnifying-glass \n"
				+ "https://opengameart.org/content/handpainted-rpg-icons\n"

				);
		add(text);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setVisible(true);
	}
}

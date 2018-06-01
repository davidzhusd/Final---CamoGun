import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Credits extends JFrame {
	JTextArea text = new JTextArea(10, 20);
	public Credits() {
		text.setLineWrap(true);
		text.setEditable(false);
		text.setText("Game Desginers: Richard Chen, David Zhu, Yang Song, Wenzhe Zhang\n"
				+ "Websites used: https://pixlr.com/editor/"
				+ "https://opengameart.org/content/basic-map-32x32-by-silver-iv");
		add(text);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setVisible(true);
	}
}

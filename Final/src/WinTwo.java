import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinTwo extends JFrame{
	public WinTwo() 
	{
		JLabel label = new JLabel("Player Two Wins!");
		label.setSize(100, 100);
		add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(100, 100);
		setVisible(true);
	}
}

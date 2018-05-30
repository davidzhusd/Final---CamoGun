import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinOne extends JFrame{
	public WinOne() 
	{
		JLabel label = new JLabel("Player One Wins!");
		label.setSize(100, 100);
		add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(100, 100);
		setVisible(true);
	}
}

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class WinOne extends JFrame{
	Timer timer;
	public WinOne() 
	{
		setVisible(true);
		JTextArea label = new JTextArea(20, 20);
		label.setEditable(false);
		label.setFont(new Font("Arial Black", Font.BOLD, 40));
		label.setText("Player One Wins");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(label, gbc);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 1000);
		ActionListener timelistener = new TimeListener();
		timer = new Timer(2000, timelistener);
		timer.start();
	}
	public class TimeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setVisible(false);
			dispose();
			timer.stop();
		}
	}
}

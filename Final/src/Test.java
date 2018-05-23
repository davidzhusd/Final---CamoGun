import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Test extends JFrame implements ActionListener {
	JButton Play;
	JButton Instructions;
	JButton Credits;
	public Test() {

		Play = new JButton("Play");
		Instructions = new JButton("Instructions");
		Credits = new JButton("Credits");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady = 100;
		gbc.ipadx = 100;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(Play, gbc);
		add(Instructions, gbc);
		add(Credits, gbc);
		Play.addActionListener(this);
		Instructions.addActionListener(this);
		Credits.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
	}
	public void actionPerformed (ActionEvent event)
	{
		if (event.getSource() == Play)
		{
			// 	x.displayGame();
		}
	}
	public static void main(String[] args) {
		Test test = new Test();

	}
}
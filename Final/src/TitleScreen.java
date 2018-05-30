import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JFrame implements ActionListener{
	Display x;
	JButton Play;
	JButton Instructions;
	JButton Credits;
	public TitleScreen() {
		x = new Display();	
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
		JLabel label = new JLabel();
		ImageIcon image = new ImageIcon("fish.gif");
		label.setIcon(image);
		add(label, gbc);
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
			x.displayGame();
			//x.displayGameAlternate();
		} else if (event.getSource() == Instructions) 
		{
			
		} else if (event.getSource() == Credits) 
		{
			
		}
	}
}

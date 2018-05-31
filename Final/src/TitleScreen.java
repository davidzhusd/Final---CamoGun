import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JFrame implements ActionListener{
	private Display x;
	private JButton Play;
	private JButton Instructions;
	private JButton Credits;
	private JComboBox<String> comboBox1;
    private String[] names = {"CHOOSE A MAP", "Map 1", "Map 2", "Random"};
    private int useMap;
	public TitleScreen() {
		x = new Display();	
		comboBox1 = new JComboBox<String>(names);
		comboBox1.setMaximumRowCount(4);
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
		add(comboBox1);
		JLabel label = new JLabel();
		ImageIcon image = new ImageIcon("fish.gif");
		label.setIcon(image);
		add(label, gbc);
		comboBox1.addItemListener(new ComboBoxHandler());
		Play.addActionListener(this); 
		Instructions.addActionListener(this);
		Credits.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
	}
	public void setMap(int num) 
	{
		useMap = num;
	}
    private class ComboBoxHandler implements ItemListener {
        public void itemStateChanged (ItemEvent event) {
            if (event.getSource() == comboBox1) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                	if (event.getItem().equals("Map 1")) 
                	{
                		setMap(1);
                	}
                	else if (event.getItem().equals("Map 2")) 
                	{
                		setMap(2);
                	}
                	else if (event.getItem().equals("Random")) 
                	{
                		setMap(0);
                	}
                }
            }
                
        }  
    }
	public void actionPerformed (ActionEvent event)
	{
		if (event.getSource() == Play)
		{
			x.displayGame(useMap);
			//x.displayGameAlternate();
		} else if (event.getSource() == Instructions) 
		{
			x.displayInstructions();
		} else if (event.getSource() == Credits) 
		{
			
		}
	}
}

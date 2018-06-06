import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JFrame implements ActionListener{
	private Display x;
	private JLabel left;
	private JLabel y;
	private JLabel right;
	private JButton Play;
	private JButton Instructions;
	private JButton Credits;
	private JPanel label;
	private JPanel label2;
	private JComboBox<String> comboBox1;
    private String[] names = {"CHOOSE A MAP", "Map 1", "Map 2","Map 3", "Random"};
    private int useMap;
    private ImageIcon decorR;
    private ImageIcon decorL;
	public TitleScreen() {
		images();
		x = new Display();
		setTitle("CamoGun");
		left = new JLabel();
		right = new JLabel();
		y = new JLabel("Camo Gun");
		y.setFont(new Font("Papyrus",Font.ITALIC,50));
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
		label2= new JPanel();
		label2.add(y);
		add(label2, gbc);
		add(Play, gbc);
		add(Instructions, gbc);
		add(Credits, gbc);
		label = new JPanel();
		label.add(left);
		label.add(right);
		add(label, gbc);
		left.setIcon(decorL);
		right.setIcon(decorR);
		add(comboBox1);
		comboBox1.addItemListener(new ComboBoxHandler());
		Play.addActionListener(this); 
		Instructions.addActionListener(this);
		Credits.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
	}
	public void images() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		decorR = new ImageIcon(cldr.getResource("player2Left.png"));
		Image decorR1 = decorR.getImage(); // transform it 
		Image newDecorR = decorR1.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
		decorR = new ImageIcon(newDecorR);
		decorL = new ImageIcon(cldr.getResource("player1.png"));
		Image decorL1 = decorL.getImage(); // transform it 
		Image newDecorL = decorL1.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
		decorL = new ImageIcon(newDecorL);
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
                	else if(event.getItem().equals("Map 3"))
                	{
                		setMap(3);
                	}
                	
                	else
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
			x.displayCredits();
		}
	}
}

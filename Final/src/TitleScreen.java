import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleScreen extends JFrame{
	private JButton start;
	private JButton instructions;
	private JPanel buttons;
	public TitleScreen()
	{
		initGUI();
	}
	public void initGUI()
	{
		start = new JButton("Start");
		instructions = new JButton("Instructions");
		buttons = new JPanel();
		buttons.add(start);
		buttons.add(instructions);
		getContentPane().setLayout(new BorderLayout());
		add("Center", buttons);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
	}
}

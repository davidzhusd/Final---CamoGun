import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Game extends JFrame{
//	Grid gr;
	private Actor player1;
	private Actor player2;
	private JLabel[][] labels;
	private Map map;
	public Game()
	{
		player1 = new Actor(90, new Location(1, 1), CellType.EMPTY);
		player2 = new Actor(0, new Location(8, 8), CellType.EMPTY);
		labels = new JLabel[10][10];
		getContentPane().setLayout(new GridLayout(10, 10));
		map = new Map();
		update();
		initialize();
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//repaint();
		setSize(1000, 1000);
		setVisible(true);
		requestFocusInWindow();
		addKeyListener(new KeyHandler());

	}
	public void initialize() 
	{
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				add(labels[i][j]);
			}
		}
	}
	public void update() 
	{
		System.out.println("update");
		labels = map.draw();
	}
	private class KeyHandler implements KeyListener {

		public void keyPressed ( KeyEvent event )
		{	
			if (event.getKeyCode() == KeyEvent.VK_D) 
			{
				if (player1.getDirection() != 90) 
				{
					player1.setDirection(90);
					update();
				}
				else 
				{
					if (player1.canMove(map)) 
					{
						int r = player1.getLocation().getRow();
						int c = player1.getLocation().getCol();
						player1.moveForward();
						System.out.println(player1.getLocation().getRow() + " " + player1.getLocation().getCol());
						map.updatePlayer(r, c, player1.getLocation().getRow(), player1.getLocation().getCol(), player1);
						update();
						ImageIcon icon = new ImageIcon("brick-wall-pls.png");
						labels[5][5].setIcon(icon);
						System.out.println("GOT HERE");
					}
				}
			}
		}

		public void keyReleased (KeyEvent event )
		{
			// called when key is released after a keyPressed or 
			// keyTyped event
		}

		public void keyTyped (KeyEvent event )
		{
			// only responds to pressing "non-action" keys; 
			// (action keys include arrow key, Home, etc)
		}
	}   // end KeyHandler
	/*public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(player.getImage(), 100, 100, this);
	}*/
}

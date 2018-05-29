import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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
		player1.thisIsPlayerOne();
		player2 = new Actor(0, new Location(8, 8), CellType.EMPTY);
		labels = new JLabel[10][10];
		getContentPane().setLayout(new GridLayout(10, 10));
		map = new Map();
		initialize();
		draw(map.updateMap());
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
				JLabel label = new JLabel();
				labels[i][j] = label;
				add(labels[i][j]);
			}
		}
	}
	public void draw(CellType[][] map) 
	{
		ImageIcon wall = new ImageIcon("brick-wall-pls.png");
		Image image = wall.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		wall = new ImageIcon(newimg);  // transform it back
		ImageIcon player1 = new ImageIcon("player1.png");
		Image player1img = player1.getImage();
		Image newPlayer1 = player1img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		player1 = new ImageIcon(newPlayer1);
		ImageIcon player2 = new ImageIcon("player2.png");
		Image player2img = player2.getImage();
		Image newPlayer2 = player2img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		player2 = new ImageIcon(newPlayer2);
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				if (map[i][j] == (CellType.WALL)) 
				{
					labels[i][j].setIcon(wall);
				}
				else if (map[i][j] == CellType.PLAYER_A) 
				{
					labels[i][j].setIcon(player1);
				}
				else if (map[i][j] == CellType.PLAYER_B) 
				{
					labels[i][j].setIcon(player2);
				}
				else 
				{
					labels[i][j].setIcon(null);
				}
			}
		}
	}
	private class KeyHandler implements KeyListener {

		public void keyPressed ( KeyEvent event )
		{	
			if (event.getKeyCode() == KeyEvent.VK_D) 
			{
				if (player1.getDirection() != 90) 
				{
					player1.setDirection(90);
				}
				else 
				{
					if (player1.canMove(map)) 
					{
						int r = player1.getLocation().getRow();
						int c = player1.getLocation().getCol();
						player1.moveForward();
						map.updatePlayer(r, c, player1.getLocation().getRow(), player1.getLocation().getCol(), player1);
						draw(map.updateMap());
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_A) 
			{
				if (player1.getDirection() != 270) 
				{
					player1.setDirection(270);
				}
				else 
				{
					if (player1.canMove(map)) 
					{
						int r = player1.getLocation().getRow();
						int c = player1.getLocation().getCol();
						player1.moveForward();
						map.updatePlayer(r, c, player1.getLocation().getRow(), player1.getLocation().getCol(), player1);
						draw(map.updateMap());
						System.out.println("GOT HERE A");
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_S) 
			{
				if (player1.getDirection() != 180) 
				{
					player1.setDirection(180);
				}
				else 
				{
					if (player1.canMove(map)) 
					{
						int r = player1.getLocation().getRow();
						int c = player1.getLocation().getCol();
						player1.moveForward();
						map.updatePlayer(r, c, player1.getLocation().getRow(), player1.getLocation().getCol(), player1);
						draw(map.updateMap());
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_W) 
			{
				if (player1.getDirection() != 0) 
				{
					player1.setDirection(0);
				}
				else 
				{
					if (player1.canMove(map)) 
					{
						int r = player1.getLocation().getRow();
						int c = player1.getLocation().getCol();
						player1.moveForward();
						map.updatePlayer(r, c, player1.getLocation().getRow(), player1.getLocation().getCol(), player1);
						draw(map.updateMap());
					}
				}
				
			} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
			{
				if (player2.getDirection() != 90) 
				{
					player2.setDirection(90);
				}
				else 
				{
					if (player2.canMove(map)) 
					{
						int r = player2.getLocation().getRow();
						int c = player2.getLocation().getCol();
						player2.moveForward();
						map.updatePlayer(r, c, player2.getLocation().getRow(), player2.getLocation().getCol(), player2);
						draw(map.updateMap());
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_LEFT) 
			{
				if (player2.getDirection() != 270) 
				{
					player2.setDirection(270);
				}
				else 
				{
					if (player2.canMove(map)) 
					{
						int r = player2.getLocation().getRow();
						int c = player2.getLocation().getCol();
						player2.moveForward();
						map.updatePlayer(r, c, player2.getLocation().getRow(), player2.getLocation().getCol(), player2);
						draw(map.updateMap());
						System.out.println("GOT HERE A");
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_DOWN) 
			{
				if (player2.getDirection() != 180) 
				{
					player2.setDirection(180);
				}
				else 
				{
					if (player2.canMove(map)) 
					{
						int r = player2.getLocation().getRow();
						int c = player2.getLocation().getCol();
						player2.moveForward();
						map.updatePlayer(r, c, player2.getLocation().getRow(), player2.getLocation().getCol(), player2);
						draw(map.updateMap());
					}
				}
			} else if (event.getKeyCode() == KeyEvent.VK_UP) 
			{
				if (player2.getDirection() != 0) 
				{
					player2.setDirection(0);
				}
				else 
				{
					if (player2.canMove(map)) 
					{
						int r = player2.getLocation().getRow();
						int c = player2.getLocation().getCol();
						player2.moveForward();
						map.updatePlayer(r, c, player2.getLocation().getRow(), player2.getLocation().getCol(), player2);
						draw(map.updateMap());
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

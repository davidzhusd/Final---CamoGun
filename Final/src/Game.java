import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;



public class Game extends JFrame {
	//	Grid gr;
	private Actor player1;
	private Actor player2;
	private JLabel[][] labels;
	private Map map;
	private Bullet bullet1;
	private Bullet bullet2;
	private ImageIcon bullet1I;
	private ImageIcon bullet2I;
	private ImageIcon wall;
	private ImageIcon player1I;
	private ImageIcon player2I;
	boolean timerOnB;
	public Game()
	{
		images();
		timerOnB = false;
		player1 = new Actor(90, new Location(1, 1), CellType.EMPTY);
		player1.thisIsPlayerOne();
		player1.goInvis();
		player2 = new Actor(0, new Location(8, 8), CellType.EMPTY);
		player2.goInvis();
		bullet1 = new Bullet(player1.getDirection(), player1.getLocation());
		bullet2 = new Bullet(player2.getDirection(), player2.getLocation());
		labels = new JLabel[10][10];
		getContentPane().setLayout(new GridLayout(10, 10));
		map = new Map(1);
		initialize();
		draw(map.updateMap());
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
		requestFocusInWindow();
		addKeyListener(new KeyHandler());
		class InvisListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player1.goInvis();
				player2.goInvis();
				draw(map.updateMap());
			}

		}
		ActionListener listen = new InvisListener();
		Timer timer = new Timer(2000, listen);
		timer.start();
	}

	public class BulletListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			moveBullet(bullet1);
			moveBullet(bullet2);
		}	
	}
	public void moveBullet(Bullet bullet) 
	{
		if (bullet.canMove(map)) 
		{
			int r = bullet.getLocation().getRow();
			int c = bullet.getLocation().getCol();
			bullet.moveForward();
			map.updateBullet(r, c, bullet.getLocation().getRow(), bullet.getLocation().getCol(), bullet);
			draw(map.updateMap());
		} else if (bullet.getLocation() != null)
		{
			System.out.println("Cant move");
			int r = bullet.getLocation().getRow();
			int c = bullet.getLocation().getCol();
			map.repair(r, c);
			bullet.setInactive();
			bullet.setLocation(null);
			draw(map.updateMap());
		}
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
					if (player1.invis()) 
					{
						System.out.println("invis");
						labels[i][j].setIcon(null);
					} else 
					{
						System.out.println("appear");
						labels[i][j].setIcon(player1I);
					}
				}
				else if (map[i][j] == CellType.PLAYER_B) 
				{
					if (this.player2.invis()) 
					{
						labels[i][j].setIcon(null);
					} else 
					{
						labels[i][j].setIcon(player2I);
					}
				}
				else if (map[i][j] == CellType.BULLET1) 
				{
					System.out.println("Print Bullet1");
					labels[i][j].setIcon(bullet1I);
				}
				else if (map[i][j] == CellType.BULLET2) 
				{
					labels[i][j].setIcon(bullet2I);
				}
				else 
				{
					labels[i][j].setIcon(null);
				}
			}
		}
	}
	public void fire(Actor player, Bullet bullet) 
	{
		bullet.setActive();
		player.appear();
		draw(map.updateMap());
		if (player.amIPlayerOne()) 
		{
			bullet.thisIsBullet1();
			bullet1I = bullet.getBulletImage();
		} else 
		{
			System.out.println("TEST");
			bullet2I = bullet.getBulletImage();
		}
	}
	private class KeyHandler implements KeyListener {

		public void keyPressed ( KeyEvent event )
		{	
			if (event.getKeyCode() == KeyEvent.VK_SPACE) 
			{
				if (!bullet1.isActive()) 
				{
					bullet1 = new Bullet(player1.getDirection(), player1.getLocation());
					bullet1.setActive();
					fire(player1, bullet1);
					if (!timerOnB) 
					{
						ActionListener listenB = new BulletListener();
						Timer timerB = new Timer(1000, listenB);
						timerB.start();
						timerOnB = true;
					}
					draw(map.updateMap());
				}
			}
			if (event.getKeyCode() == KeyEvent.VK_L) 
			{
				if (!bullet2.isActive()) 
				{
					System.out.println("in");
					bullet2 = new Bullet(player2.getDirection(), player2.getLocation());
					bullet2.setActive();
					fire(player2, bullet2);
					if (!timerOnB) 
					{
						ActionListener listenB = new BulletListener();
						Timer timerB = new Timer(1000, listenB);
						timerB.start();
						timerOnB = true;
					}
				}
				draw(map.updateMap());

			}
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
	public void images() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		wall = new ImageIcon(cldr.getResource("brick-wall-pls.png"));
		Image image = wall.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		wall = new ImageIcon(newimg);  // transform it back
		player1I = new ImageIcon(cldr.getResource("player1.png"));
		Image player1img = player1I.getImage();
		Image newPlayer1 = player1img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		player1I = new ImageIcon(newPlayer1);
		player2I = new ImageIcon(cldr.getResource("player2.png"));
		Image player2img = player2I.getImage();
		Image newPlayer2 = player2img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		player2I = new ImageIcon(newPlayer2);
	}
}

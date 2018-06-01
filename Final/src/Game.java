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
	private Display x;
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
	private ImageIcon bush;
	private ImageIcon wallb;
	private ImageIcon puddle;
	private ImageIcon splash;
	private ImageIcon shieldI;
	private ImageIcon revealerI;
	private Shield shield;
	private Revealer revealer;
	private Timer timerB1;
	private Timer timerB2;
	private Timer timerR1;
	private Timer timerR2;
	private Timer timerI;
	private Timer timerG;
	private Timer killTimer;
	private Timer killTimer1;
	private boolean shieldActive;
	private boolean revealerActive;
	private int useMapNum;
	//constructor
	public Game(int num)
	{
		startItemTimers();
		startBtimers();
		startRevealTimers();
		startGameTimer();
		images();
		useMapNum = num;
		shield = new Shield(null);
		revealer = new Revealer(null);
		x = new Display();
		player1 = new Actor(90, new Location(1, 1), CellType.EMPTY);
		player1.thisIsPlayerOne();
		player1.appear();
		player2 = new Actor(0, new Location(8, 8), CellType.EMPTY);
		player2.appear();
		bullet1 = new Bullet(player1.getDirection(), player1.getLocation());
		bullet2 = new Bullet(player2.getDirection(), player2.getLocation());
		labels = new JLabel[10][10];
		getContentPane().setLayout(new GridLayout(10, 10));
		//choose which map to use
		if (useMapNum != 0) 
		{
			map = new Map(useMapNum);
		} else 
		{//randomized map
			int random=(int)((Math.random())*2 + 1);
			map = new Map(random);
		}
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
		Timer timer = new Timer(3000, listen);
		timer.start();
	}
	//start all necessary timers
	public void startGameTimer() 
	{
		ActionListener listenG = new GameListener();
		timerG = new Timer(100, listenG);
		timerG.start();
	}
	public void startItemTimers() 
	{
		ActionListener item = new ItemListener();
		timerI = new Timer(7000, item);
		timerI.start();
	}
	public void startRevealTimers() 
	{
		ActionListener listenR1 = new RevealListener1();
		timerR1 = new Timer(1000, listenR1);
		timerR1.start();
		ActionListener listenR2 = new RevealListener2();
		timerR2 = new Timer(1000, listenR2);
		timerR2.start();
	}
	public void startBtimers() 
	{
		ActionListener listenB1 = new BulletListener1();
		timerB1 = new Timer(50, listenB1);
		timerB1.start();
		ActionListener listenB2 = new BulletListener2();
		timerB2 = new Timer(50, listenB2);
		timerB2.start();
	}
	//creates random location for item spawning
	public Location randomEmptyLoc() 
	{
		do 
		{
			int r = (int)(Math.random()*9 + 1);
			int c = (int)(Math.random()*9 + 1);
			Location loc = new Location(r, c);
			if (map.getCellType(r, c) == CellType.EMPTY) 
			{
				return loc;
			}
		} while (true);
	}
	public class ItemListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (!shieldActive) 
			{
				shieldActive = true;
				Location loc = randomEmptyLoc();
				shield.setLocation(loc);
				int r = loc.getRow();
				int c = loc.getCol();
				map.updateCell(r, c, CellType.SHIELD);
				map.updateOriginalCell(r, c, CellType.SHIELD);
			}
			if (!revealerActive) 
			{
				revealerActive = true;
				Location loc = randomEmptyLoc();
				shield.setLocation(loc);
				int r = loc.getRow();
				int c = loc.getCol();
				map.updateCell(r, c, CellType.REVEALER);
				map.updateOriginalCell(r, c, CellType.REVEALER);
			}
		}
	}
	public class GameListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			refreshPlayer(player1);
			refreshPlayer(player2);
			draw(map.updateMap());
		}	
	}
	public class KillListener1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			oneWin();
			killTimer.stop();
		}
	}
	public void twoWin() 
	{
		x.displayTwoWIN();
		setVisible(false);
		dispose();
	}
	public void oneWin() 
	{
		x.displayOneWIN();
		setVisible(false);
		dispose();
	}
	public class KillListener2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			twoWin();
			killTimer1.stop();
		}
	}
	public class RevealListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			player1.updateInactivity();
			if (player1.getInactivity()) 
			{
				player1.setInvis(true);
				player1.appear();
				draw(map.updateMap());
			}
			if (player1.revealed()) 
			{
				player1.setInvis(true);
				player1.updateReveal();
				player1.appear();
				draw(map.updateMap());
			}
		}
	}
	public class RevealListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			player2.updateInactivity();
			if (player2.getInactivity()) 
			{
				player2.setInvis(true);
				player2.appear();
				draw(map.updateMap());
			}
			if (player2.revealed()) 
			{
				player2.setInvis(true);
				player2.updateReveal();
				player2.appear();
				draw(map.updateMap());
			}
		}
	}
	public class BulletListener1 implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			moveBullet(bullet1);
			refreshPlayer(player1);
			if (bullet1TouchingPlayer2()) 
			{
				player2.setInvis(true);
				player2.setGameEnd();
				player1.setGameEnd();
				player2.appear();
				draw(map.updateMap());
				ActionListener killlistener = new KillListener1();
				killTimer = new Timer(500, killlistener);
				killTimer.start();
			}
		}	
	}
	public class BulletListener2 implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			moveBullet(bullet2);
			refreshPlayer(player2);
			if (bullet2TouchingPlayer1()) 
			{
				player1.setInvis(true);
				player2.setGameEnd();
				player1.setGameEnd();
				player1.appear();
				draw(map.updateMap());
				ActionListener killlistener = new KillListener2();
				killTimer1 = new Timer(500, killlistener);
				killTimer1.start();
			}
		}	
	}
	public void moveBullet(Bullet bullet) 
	{
		if (bullet.canMove(map)) 
		{
			int nextR = bullet.getLocation().getAdjacentLocation(bullet.getDirection()).getRow();
			int nextC = bullet.getLocation().getAdjacentLocation(bullet.getDirection()).getCol();
			if (bulletTouchingWallB(bullet, nextR, nextC)) 
			{
				//removes breakable walls by overriding original copy of map
				map.updateCell(nextR, nextC, CellType.EMPTY);
				map.updateOriginalCell(nextR, nextC, CellType.EMPTY);
				map.repair(bullet.getLocation().getRow(), bullet.getLocation().getCol());
				bullet.setInactive();
				bullet.setLocation(null);
				draw(map.updateMap());
			} else {
				//moves forward without changing the map
				int r = bullet.getLocation().getRow();
				int c = bullet.getLocation().getCol();
				bullet.moveForward();
				map.updateBullet(r, c, bullet.getLocation().getRow(), bullet.getLocation().getCol(), bullet);
				map.repair(r, c);
				draw(map.updateMap());
			}
		} else if (bullet.getLocation() != null)
		{
			//can't move, stops and removes bullet
			int r = bullet.getLocation().getRow();
			int c = bullet.getLocation().getCol();
			map.repair(r, c);
			bullet.setInactive();
			bullet.setLocation(null);
			draw(map.updateMap());
		}
	}
	public void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("TEST");
		}
	}
	//refreshes the display
	public void refreshPlayer(Actor player) 
	{
		int r = player.getLocation().getRow();
		int c = player.getLocation().getCol();
		if (player.amIPlayerOne()) 
		{
			map.updateCell(r, c, CellType.PLAYER_A);
		} else 
		{
			map.updateCell(r, c, CellType.PLAYER_B);
		}
	}
	//checks for bullet hitting a breakable wall
	public boolean bulletTouchingWallB(Bullet bullet, int r, int c) 
	{
		if (bullet.getLocation() == null) 
		{
			return false;
		}
		if (map.getCellType(r, c) == CellType.WAll_B) 
		{
			return true;
		}
		return false;
	}
	//win condition
	public boolean bullet1TouchingPlayer2() 
	{
		if (bullet1.getLocation() == null) 
		{
			return false;
		}
		if (bullet1.getLocation().equals(player2.getLocation())) 
		{
			if (player2.extraLife()) 
			{
				player2.appear();
				player2.setExtraLife(false);
				return false;
			}
			timerB1.stop();
			timerB2.stop();
			return true;
		}
		return false;
	}
	//win condition
	public boolean bullet2TouchingPlayer1() 
	{
		if (bullet2.getLocation() == null) 
		{
			return false;
		}
		if (bullet2.getLocation().equals(player1.getLocation())) 
		{
			if (player1.extraLife()) 
			{
				player1.appear();
				player1.setExtraLife(false);
				return false;
			}
			timerB1.stop();
			timerB2.stop();
			return true;
		}
		return false;
	}
	//initializes all the JLabels required
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
	//updates the display
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
						labels[i][j].setIcon(null);
					} else 
					{
						player1I = player1.getImage();
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
						player2I = player2.getImage();
						labels[i][j].setIcon(player2I);
					}
				}
				else if (map[i][j] == CellType.BULLET1) 
				{
					labels[i][j].setIcon(bullet1I);
				}
				else if (map[i][j] == CellType.BULLET2) 
				{
					labels[i][j].setIcon(bullet2I);
				}
				else if (map[i][j] == CellType.BUSH) 
				{
					labels[i][j].setIcon(bush);
				}
				else if (map[i][j] == CellType.WAll_B) 
				{
					labels[i][j].setIcon(wallb);

				}
				else if (map[i][j] == CellType.PUDDLE) 
				{
					labels[i][j].setIcon(puddle);
				}
				else if (map[i][j] == CellType.SHIELD) 
				{
					shield.setLocation(new Location(i, j));
					labels[i][j].setIcon(shieldI);
				}
				else if (map[i][j] == CellType.REVEALER) 
				{
					revealer.setLocation(new Location(i, j));
					labels[i][j].setIcon(revealerI);
				}
				else 
				{
					labels[i][j].setIcon(null);
				}

			}
		}
	}
	//shoots bullet
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
			bullet2I = bullet.getBulletImage();
		}
	}
	public void move(Actor player) 
	{
		if (player.canMove(map)) 
		{
			player.resetInactivity();
			player.setInvis(false);
			int r = player.getLocation().getRow();
			int c = player.getLocation().getCol();
			if (player.gameGoingCanMove()) 
			{
				player.moveForward();
			}
			if (touchingShield(player)) 
			{
				map.updateCell(player.getLocation().getRow(), player.getLocation().getCol(), CellType.EMPTY);
				map.updateOriginalCell(player.getLocation().getRow(), player.getLocation().getCol(), CellType.EMPTY);
			}
			else if (touchingRevealer(player)) 
			{
				map.updateCell(player.getLocation().getRow(), player.getLocation().getCol(), CellType.EMPTY);
				map.updateOriginalCell(player.getLocation().getRow(), player.getLocation().getCol(), CellType.EMPTY);
			}
			map.updatePlayer(r, c, player.getLocation().getRow(), player.getLocation().getCol(), player);
			draw(map.updateMap());
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
					draw(map.updateMap());
				}
			}
			if (event.getKeyCode() == KeyEvent.VK_L) 
			{
				if (!bullet2.isActive()) 
				{
					bullet2 = new Bullet(player2.getDirection(), player2.getLocation());
					bullet2.setActive();
					fire(player2, bullet2);
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
					move(player1);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_A) 
			{
				if (player1.getDirection() != 270) 
				{
					player1.setDirection(270);
				}
				else 
				{
					move(player1);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_S) 
			{
				if (player1.getDirection() != 180) 
				{
					player1.setDirection(180);
				}
				else 
				{
					move(player1);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_W) 
			{
				if (player1.getDirection() != 0) 
				{
					player1.setDirection(0);
				}
				else 
				{
					move(player1);
				}

			} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
			{
				if (player2.getDirection() != 90) 
				{
					player2.setDirection(90);
				}
				else 
				{
					move(player2);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_LEFT) 
			{
				if (player2.getDirection() != 270) 
				{
					player2.setDirection(270);
				}
				else 
				{
					move(player2);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_DOWN) 
			{
				if (player2.getDirection() != 180) 
				{
					player2.setDirection(180);
				}
				else 
				{
					move(player2);
				}
			} else if (event.getKeyCode() == KeyEvent.VK_UP) 
			{
				if (player2.getDirection() != 0) 
				{
					player2.setDirection(0);
				}
				else 
				{
					move(player2);
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
	public boolean touchingShield(Actor player) 
	{
		if (player.getLocation() == null || shield.getLocation() == null) 
		{
			return false;
		}
		if (player.getLocation().equals(shield.getLocation())) 
		{
			shieldActive = false;
			shield.activate(player);
			shield.setLocation(null);
			return true;
		}
		return false;
	}
	public boolean touchingRevealer(Actor player) 
	{
		if (player.getLocation() == null || revealer.getLocation() == null) 
		{
			return false;
		}
		if (player.getLocation().equals(revealer.getLocation())) 
		{
			if (player.amIPlayerOne()) 
			{
				revealerActive = false;
				revealer.setLocation(null);
				revealer.activate(player2);
			} else 
			{
				revealerActive = false;
				revealer.setLocation(null);
				revealer.activate(player1);
			}
			return true;
		}
		return false;
	}
	public void images() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		wall = new ImageIcon(cldr.getResource("brick-wall-pls.png"));
		Image image = wall.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		wall = new ImageIcon(newimg);  // transform it back
		bush = new ImageIcon(cldr.getResource("grass.jpg"));
		Image bush1 = bush.getImage(); // transform it 
		Image newbush = bush1.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		bush = new ImageIcon(newbush);  // transform it back
		puddle = new ImageIcon(cldr.getResource("puddle.png"));
		Image puddle1 = puddle.getImage(); // transform it 
		Image newpuddle = puddle1.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		puddle = new ImageIcon(newpuddle);  // transform it back
		wallb = new ImageIcon(cldr.getResource("breakableBox.png"));
		Image wall1 = wallb.getImage(); // transform it 
		Image newwallb = wall1.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		wallb = new ImageIcon(newwallb);  // transform it back
		splash = new ImageIcon(cldr.getResource("splash.gif"));
		Image splash1 = splash.getImage(); // transform it 
		Image newsplash = splash1.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		splash = new ImageIcon(newsplash);  // transform it back
		shieldI = new ImageIcon(cldr.getResource("shield.png"));
		Image shield1 = shieldI.getImage();
		Image newshield = shield1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		shieldI = new ImageIcon(newshield);
		revealerI = new ImageIcon(cldr.getResource("magnifying Glass.png"));
		Image revealer1 = revealerI.getImage(); // transform it 
		Image newrevealer = revealer1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		revealerI = new ImageIcon(newrevealer);  // transform it back
	}
}

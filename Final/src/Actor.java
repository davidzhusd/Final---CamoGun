
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Actor {
	private int myDirection;
	private Location myLocation;
	private CellType myBack;
	private Image image;
	private ImageIcon actorImage1U;
	private ImageIcon actorImage1D;
	private ImageIcon actorImage1L;
	private ImageIcon actorImage1R;
	private ImageIcon actorImage2U;
	private ImageIcon actorImage2D;
	private ImageIcon actorImage2L;
	private ImageIcon actorImage2R;
	private boolean playerIdentifier;
	private boolean playerInvis;
	private boolean extraLife;
	private int reveal;
	private boolean hasReveal;
	private boolean cantgoinvis;
	private boolean inActive;
	private boolean gameGoingCanMove;
	public int count;
	public Actor() {}
	//constructor
	public Actor(int direction, Location location, CellType back)
	{
		gameGoingCanMove = true;
		inActive = false;
		count = 0;
		myBack = back;
		myDirection = direction;
		myLocation = location;
		images();
	}
	public Actor(int dir) 
	{
		myDirection = dir;
		cantgoinvis = false;
	}
	//to constantly see if the player is active or inactive and count depending on that
	public void updateInactivity() 
	{
		if (inActive == false) {
			count++;
			if (count == 5) 
			{
				inActive = true;
			}
		} else if (inActive == true) 
		{
			count--;
			if (count == 0) 
			{
				inActive = false;
			}
		}
	}
	//resets counter
	public void resetInactivity() 
	{
		count = 0;
		inActive = false;
	}
	//checks if player is inactive
	public boolean getInactivity() 
	{
		return inActive;
	}
	//sets if the player can become invisible
	public void setInvis(boolean value) 
	{
		cantgoinvis = value;
	}
	//identifies player 1
	public void thisIsPlayerOne() 
	{
		playerIdentifier = true;
	}
	//makes the player disappear
	public void goInvis() 
	{
		if (cantgoinvis) 
		{
			playerInvis = false;
		}
		else 
		{
			playerInvis = true;
		}
	}
	public void setGameEnd() 
	{
		gameGoingCanMove = false;
	}
	public boolean gameGoingCanMove() 
	{
		return gameGoingCanMove;
	}
	//checks is the player is invisible
	public boolean invis() 
	{
		return playerInvis;
	}
	//makes the player appear
	public void appear() 
	{
		playerInvis = false;
	}
	//checks if the player is player1
	public boolean amIPlayerOne() 
	{
		return playerIdentifier;
	}
	//makes this player revealed because other player got the revealer item
	public void addRevealer() 
	{
		reveal = 7;
		hasReveal = true;	
	}
	//checks if the player is affected by the item
	public boolean revealed() 
	{
		return hasReveal;
	}
	//updates its revealed state
	public void updateReveal() 
	{
		if (reveal == 0) 
		{
			cantgoinvis = false;
			hasReveal = false;
			reveal = 7;
		}
		reveal--;
	}
	//checks is the player can become invisible
	public boolean cant() 
	{
		return cantgoinvis;
	}
	//adds item shield
	public void addShield() 
	{
		extraLife = true;
	}
	//effect from shield
	public boolean extraLife() 
	{
		return extraLife;
	}
	//controls shield
	public void setExtraLife(boolean value) 
	{
		extraLife = value;
	}
	//sets background
	public void setBack(CellType type) 
	{
		myBack = type;
	}
	//returns background
	public CellType getBack() 
	{
		return myBack;
	}
	//returns dir
	public int getDirection()
	{
		return myDirection;
	}
	//returns loc
	public Location getLocation()
	{ 
		return myLocation;
	}
	//returns current image based off direction
	public ImageIcon getImage() {
		if (amIPlayerOne()) 
		{
			if (getDirection() == 0) 
			{
				return actorImage1U;
			} else if (getDirection() == 90) 
			{
				return actorImage1R;
			} else if (getDirection() == 180)
			{
				return actorImage1D;
			} else if (getDirection() == 270) 
			{
				return actorImage1L;
			}
		} else 
		{
			if (getDirection() == 0) 
			{
				return actorImage2U;
			} else if (getDirection() == 90) 
			{
				return actorImage2R;
			} else if (getDirection() == 180)
			{
				return actorImage2D;
			} else if (getDirection() == 270) 
			{
				return actorImage2L;
			}
		}
		return null;
	} 
	//sets dir
	public void setDirection(int dir)
	{
		myDirection = dir;
	}
	//sets loc
	public void setLocation(Location loc)
	{
		myLocation = loc;
	}
	//sets loc
	public void moveTo(Location loc)
	{
		myLocation = loc;
	}
	//moves forward in dir
	public void moveForward()
	{
		myLocation = myLocation.getAdjacentLocation(myDirection);
	}
	//checks if actor can move
	public boolean canMove(Map map)
	{
		Location newLoc = myLocation.getAdjacentLocation(myDirection);
		if (map.getCellType(newLoc.getRow(), newLoc.getCol()) != CellType.WALL && map.getCellType(newLoc.getRow(), newLoc.getCol()) != CellType.WAll_B
				&& map.getCellType(newLoc.getRow(), newLoc.getCol()) != CellType.PLAYER_B && map.getCellType(newLoc.getRow(), newLoc.getCol()) != CellType.PLAYER_A) 
		{
			return true;
		}
		return false;
	}
	//loads all images of actor
	public void images() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		actorImage1U = new ImageIcon(cldr.getResource("player1Up.png"));
		Image a1u = actorImage1U.getImage(); // transform it 
		Image a1unew = a1u.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage1U = new ImageIcon(a1unew);  // transform it back
		actorImage1D = new ImageIcon(cldr.getResource("player1Down.png"));
		Image a1d = actorImage1D.getImage(); // transform it 
		Image a1dnew = a1d.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage1D = new ImageIcon(a1dnew);
		actorImage1L = new ImageIcon(cldr.getResource("player1Left.png"));
		Image a1l = actorImage1L.getImage(); // transform it 
		Image a1lnew = a1l.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage1L = new ImageIcon(a1lnew);
		actorImage1R = new ImageIcon(cldr.getResource("player1.png"));
		Image a1r = actorImage1R.getImage(); // transform it 
		Image a1rnew = a1r.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage1R = new ImageIcon(a1rnew);
		actorImage2U = new ImageIcon(cldr.getResource("player2Up.png"));
		Image a2u = actorImage2U.getImage(); // transform it 
		Image a2unew = a2u.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage2U = new ImageIcon(a2unew);
		actorImage2D = new ImageIcon(cldr.getResource("player2Down.png"));
		Image a2d = actorImage2D.getImage(); // transform it 
		Image a2dnew = a2d.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage2D = new ImageIcon(a2dnew);
		actorImage2L = new ImageIcon(cldr.getResource("player2Left.png"));
		Image a2l = actorImage2L.getImage(); // transform it 
		Image a2lnew = a2l.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage2L = new ImageIcon(a2lnew);
		actorImage2R = new ImageIcon(cldr.getResource("player2.png"));
		Image a2r = actorImage2R.getImage(); // transform it 
		Image a2rnew = a2r.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		actorImage2R = new ImageIcon(a2rnew);
	}

	public void removeSelffromGrid()
	{
		//to be implemented
	}	
}
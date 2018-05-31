
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
	public int count;
	public Actor() {}
	public Actor(int dir) 
	{
		myDirection = dir;
		cantgoinvis = false;
	}
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
	public void resetInactivity() 
	{
		count = 0;
		inActive = false;
	}
	public boolean getInactivity() 
	{
		return inActive;
	}
	public void setInvis(boolean value) 
	{
		cantgoinvis = value;
	}
	public void thisIsPlayerOne() 
	{
		playerIdentifier = true;
	}
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
	public boolean invis() 
	{
		return playerInvis;
	}
	public void appear() 
	{
		playerInvis = false;
	}
	public boolean amIPlayerOne() 
	{
		return playerIdentifier;
	}
	public void addRevealer() 
	{
		reveal = 7;
		hasReveal = true;	
	}
	public boolean revealed() 
	{
		return hasReveal;
	}
	public void updateReveal() 
	{
		if (reveal == 0) 
		{
			System.out.println("END");
			cantgoinvis = false;
			hasReveal = false;
			reveal = 7;
		}
		reveal--;
	}
	public boolean cant() 
	{
		return cantgoinvis;
	}
	public void addShield() 
	{
		extraLife = true;
	}
	public boolean extraLife() 
	{
		return extraLife;
	}
	public void setExtraLife(boolean value) 
	{
		extraLife = value;
	}
	public Actor(int direction, Location location, CellType back)
	{
		inActive = false;
		count = 0;
		ClassLoader cldr = this.getClass().getClassLoader();
		myBack = back;
		myDirection = direction;
		myLocation = location;
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
	public void setBack(CellType type) 
	{
		myBack = type;
	}
	public CellType getBack() 
	{
		return myBack;
	}
	public int getDirection()
	{
		return myDirection;
	}

	public Location getLocation()
	{ 
		return myLocation;
	}

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

	public void setDirection(int dir)
	{
		myDirection = dir;
	}

	public void setLocation(Location loc)
	{
		myLocation = loc;
	}

	public void moveTo(Location loc)
	{
		myLocation = loc;
	}

	public void moveForward()
	{
		myLocation = myLocation.getAdjacentLocation(myDirection);
	}

	public void faceUp()
	{
		myDirection = 0;
	}

	public void faceRight()
	{
		myDirection = 90;
	}

	public void faceLeft()
	{
		myDirection = 270;
	}

	public void faceBack()
	{
		myDirection = 180;
	}

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

	public void removeSelffromGrid()
	{
		//to be implemented
	}	
}
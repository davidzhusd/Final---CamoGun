
import java.awt.Image;

import javax.swing.ImageIcon;

public class Actor {
	private int myDirection;
	private Location myLocation;
	private CellType myBack;
	private Image image;
	private ImageIcon actorImage;
	private boolean playerIdentifier;
	private boolean playerInvis;
	public Actor() {}
	public Actor(int dir) 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		myDirection = dir;
		actorImage = new ImageIcon(cldr.getResource("fish.gif"));
	}
	public void thisIsPlayerOne() 
	{
		playerIdentifier = true;
	}
	public void goInvis() 
	{
		playerInvis = true;
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
	public Actor(int direction, Location location, CellType back)
	{
		myBack = back;
		myDirection = direction;
		myLocation = location;
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
		return actorImage;
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





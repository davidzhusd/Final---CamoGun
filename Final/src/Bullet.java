import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet
{
	private int direction;
	private ImageIcon bulletImage;
	private Image image;
	private Location myLocation;
	private boolean identifier;
	private boolean active;
	public Bullet(int direction, Location location){
		active = false;
		myLocation = location;
		this.direction = direction;
		ClassLoader cldr = this.getClass().getClassLoader();
		if (direction%180 == 90) {
			bulletImage = new ImageIcon(cldr.getResource("BulletHorizontal.png"));
			image = bulletImage.getImage();
		}
		else {
			bulletImage = new ImageIcon(cldr.getResource("BulletVertical.png"));
			image = bulletImage.getImage();
		}
	}
	public boolean isActive() 
	{
		return active;
	}
	public void setActive() 
	{
		active = true;
	}
	public void setInactive() 
	{
		active = false;
	}
	public void thisIsBullet1() 
	{
		identifier = true;
	}
	public boolean amIBullet1() 
	{
		return identifier;
	}
	public Bullet(int direction){
		this.direction = direction;
		if (direction%180 == 90) {
			bulletImage = new ImageIcon("BulletHorizontal.png");
			image = bulletImage.getImage();
		}
		else {
			bulletImage = new ImageIcon("BulletVertical.png");
			image = bulletImage.getImage();
		}
	}
	public void moveForward() 
	{
		myLocation = myLocation.getAdjacentLocation(this.direction);
	}
	public Image getImage(){
		return image;
	}
	public Location getLocation() 
	{
		return myLocation;
	}
	public void setLocation(Location location) 
	{
		myLocation = location;
	}
	public ImageIcon getBulletImage() {
		return bulletImage;
	}
	public boolean canMove(Map map) 
	{
		if (myLocation == null) 
		{
			return false;
		}
		Location newLoc = myLocation.getAdjacentLocation(this.direction);
		int r = newLoc.getRow();
		int c = newLoc.getCol();
		if (map.getCellType(r, c) != CellType.WALL) 
		{
			return true;
		}
		return false;
	}
	public int getDirection(){
		return direction;
	}
}

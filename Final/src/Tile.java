import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile {
	private Location myLocation;
	private Background myBackground;
	private Actor myActor;
	private Bullet myBullet;

	public Tile(int row, int col, Background back, Actor actor) {
		myLocation = new Location(row, col);
		myBackground = back;
		myActor = actor;
		//myBullet = new Bullet(0);
	}
	public Tile(int row, int col, Background back) {
		myLocation = new Location(row, col);
		myBackground = back;
		//myBullet = new Bullet(0);
	}

	public Location getLocation() {
		return myLocation;
	}

	public Background getBackground() {
		return myBackground;
	}

	public Actor getActor() {
		return myActor;
	}

	public Bullet getBullet(){
		return myBullet;
	}

	public void setActor(Actor actor) {
		myActor = actor;
	}

	public void setBackground(Background back){}
}

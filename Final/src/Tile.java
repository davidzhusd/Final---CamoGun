import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile {
	private Location myLocation;
	private Background myBackground;
	private Actor myActor;
	private Bullet myBullet;

	public Tile(int row, int col, Background back, Player play) {
		myLocation = new Location(row, col);
		myBackground = back;
		myActor = play;
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

	public void setActor(Player P) {
		myActor = P;

	}
}

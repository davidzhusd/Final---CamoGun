import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet
{
	private int direction;
	private ImageIcon bulletImage;
	private Image image;
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
	public Image getImage(){
		return image;
	}

	public ImageIcon getBulletImage() {
		return bulletImage;
	}

	public int getDirection(){
		return direction;
	}
}

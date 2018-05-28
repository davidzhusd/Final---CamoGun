import java.awt.*;
import javax.swing.ImageIcon;
public class Wall extends Actor{
        private int direction;
        private ImageIcon image;

        public Wall(int direction)
        {
            super(direction);
            image = new ImageIcon("brick-wall-pls.png");
        }

    public ImageIcon getImage() {
        return image;
    }
}

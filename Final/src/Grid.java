import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Grid {

    private JLayeredPane pane;
    private int numCol;
    private int numRow;
    private Tile[][] grid;

    public Grid(int row, int col) {
        numCol = col;
        numRow = row;
        grid = new MapAlternate().loadMap(0);
        displayGrid();
    }

    public void displayGrid()
    {
        pane = new JLayeredPane();
        pane.add(BackgroundGrid());
        pane.add(ActorGrid());
        pane.add(BulletGrid());
    }

    public JPanel BackgroundGrid() {
        JPanel backPanel = new JPanel();
        backPanel.setSize(1000, 1000);
        backPanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon image = grid[i][j].getBackground().getBackgroundImage();
                JLabel label = new JLabel();
                label.setIcon(image);
                backPanel.add(label);
            }
        }
        return backPanel;
    }

    public JPanel ActorGrid() {
        JPanel actorPanel = new JPanel();
        actorPanel.setSize(1000, 1000);
        actorPanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon image = grid[i][j].getActor().getActorImage();
                JLabel label = new JLabel();
                label.setIcon(image);
                actorPanel.add(label);
            }
        }
        return actorPanel;
    }

    public JPanel BulletGrid() {
        JPanel bulletPanel = new JPanel();
        bulletPanel.setSize(1000, 1000);
        bulletPanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon image = grid[i][j].getBullet().getBulletImage();
                JLabel label = new JLabel();
                label.setIcon(image);
                bulletPanel.add(label);
            }
        }
        return bulletPanel;
    }
}

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

    public Grid() {
        grid = new MapAlternate().loadMap(0);
        displayGrid();
    }

    public JLayeredPane displayGrid() {
        pane = new JLayeredPane();
        //pane.add(BackgroundGrid());
        pane.add(ActorGrid());
        //pane.add(BulletGrid());
        return pane;
    }

    public JPanel BackgroundGrid() {
        JPanel backPanel = new JPanel();
        backPanel.setSize(1000, 1000);
        backPanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon image;
                JLabel label = new JLabel();
                if (grid[i][j].getActor() != null) {
                    image = grid[i][j].getBackground().getBackgroundImage();
                    label.setIcon(image);
                }
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
                ImageIcon image;
                JLabel label = new JLabel();
                if (grid[i][j].getActor() != null) {
                    image = grid[i][j].getActor().getImage();
                    label.setIcon(image);
                }
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
                ImageIcon image;
                JLabel label = new JLabel();
                if (grid[i][j].getActor() != null) {
                    image = grid[i][j].getBullet().getBulletImage();
                    label.setIcon(image);
                }
                bulletPanel.add(label);
            }
        }
        return bulletPanel;
    }

    public Tile findPlayer1() {
        Tile tile;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] != null && grid[i][j].getActor() instanceof Player1)
                    return grid[i][j];
            }
        }
        return null;
    }

    public Tile findPlayer2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] != null && grid[i][j].getActor() instanceof Player2)
                    return grid[i][j];
            }
        }
        return null;
    }

    public Tile getNewTile(Tile tile, int dir) {
        if (dir == 0) {
            Tile newTile = grid[tile.getLocation().getRow() - 1][tile.getLocation().getCol()];
            return newTile;
        } else if (dir == 90) {
            Tile newTile = grid[tile.getLocation().getRow()][tile.getLocation().getCol() + 1];
            return newTile;
        } else if (dir == 180) {
            Tile newTile = grid[tile.getLocation().getRow() + 1][tile.getLocation().getCol()];
            return newTile;
        } else {
            Tile newTile = grid[tile.getLocation().getRow()][tile.getLocation().getCol() - 1];
            return newTile;
        }
    }

    public boolean canPlayerMove(Tile tile) {
        if (tile.getActor() != null && tile.getActor() instanceof Wall)
            return false;
        else
            return true;
    }

    public void playerMove(Tile tile, Tile newTile) {
        newTile.setActor(tile.getActor());
        tile.setActor(null);
    }
}

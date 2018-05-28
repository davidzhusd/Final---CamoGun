import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class GameAlternate extends JFrame {

    private JPanel scorePanel;
    private JLabel test;
    private JLayeredPane pane;
    private Grid grid = new Grid();

    public GameAlternate(int score1, int score2) {
        setLayout(new BorderLayout());
        scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout());
        scorePanel.add(new JLabel("Player1" + score1), BorderLayout.LINE_START);
        scorePanel.add(new JLabel("Player2" + score2), BorderLayout.LINE_END);
        add(scorePanel, BorderLayout.PAGE_START);
        pane = grid.displayGrid();
        add(pane, BorderLayout.CENTER);
        /*ImageIcon image = new ImageIcon("final/fish.gif");
        test = new JLabel();
        test.setIcon(image);
        add(test,BorderLayout.CENTER);*/
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //repaint();
        setSize(1000, 1000);
        setVisible(true);
        requestFocusInWindow();
        addKeyListener(new KeyHandler());
    }

    private class KeyHandler implements KeyListener {

        public void move1(int dir, boolean player1) {
            Tile playerTile;
            if (player1 = true)
                playerTile = grid.findPlayer1();
            else
                playerTile = grid.findPlayer2();
            Actor player = playerTile.getActor();

            String check = "Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol();
            System.out.println("Arrow Direction: " + dir + " Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());
            if (playerTile.getActor().getDirection() != dir) {
                System.out.println("Not Facing Direction of Key: " + " Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());
                playerTile.getActor().setDirection(dir);
                System.out.println("New Direction " + " Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());

            } else {
                System.out.println("Facing Direction of Key " + player.getDirection()+" Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());
                Tile newTile = grid.getNewTile(playerTile, player.getDirection());
                if (grid.canPlayerMove(newTile)) {
                    System.out.println("CanMove");
                    grid.playerMove(playerTile, newTile);

                    System.out.println("New Location " + " Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());
                }
                else{
                    System.out.println("Can't Move "+ " Direction: "+player.getDirection()+" Location R C: " + playerTile.getLocation().getRow()+" "+playerTile.getLocation().getCol());
                }
            }
        }


        public void keyPressed(KeyEvent event) {
            System.out.println("Hello World");
            if (event.getKeyCode() == KeyEvent.VK_D)
                move1(90, true);
            if (event.getKeyCode() == KeyEvent.VK_S)
                move1(180, true);
            if (event.getKeyCode() == KeyEvent.VK_A)
                move1(270, true);
            if (event.getKeyCode() == KeyEvent.VK_W)
                move1(0, true);
            if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                move1(90, false);
            if (event.getKeyCode() == KeyEvent.VK_DOWN)
                move1(180, false);
            if (event.getKeyCode() == KeyEvent.VK_LEFT)
                move1(270, false);
            if (event.getKeyCode() == KeyEvent.VK_UP)
                move1(0, false);

        }

        public void keyReleased(KeyEvent event) {
            // called when key is released after a keyPressed or
            // keyTyped event
        }

        public void keyTyped(KeyEvent event) {
            // only responds to pressing "non-action" keys;
            // (action keys include arrow key, Home, etc)
        }
    }   // end KeyHandler
	/*public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(player.getImage(), 100, 100, this);
	}*/
}

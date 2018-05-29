import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map {
	private CellType[][] map;
	public Map() 
	{
		map = new CellType[10][10];
		for (int i = 0; i < 10; i++) 
		{
			map[0][i] = CellType.WALL;
			map[9][i] = CellType.WALL;
		}
		for (int i = 1; i < 9; i++) 
		{
			map[i][0] = CellType.WALL;
			map[i][9] = CellType.WALL;
		}
		map[1][1] = CellType.PLAYER_A;
		map[8][8] = CellType.PLAYER_B;
	}
	public CellType getCellType(int r, int c) 
	{
		return map[r][c];
	}
	public CellType[][] updateMap() 
	{
		return map;
	}
	public void updatePlayer(int or, int oc, int r, int c, Actor player) 
	{
		map[or][oc] = CellType.EMPTY;
		map[r][c] = CellType.PLAYER_A;
	}
	public void change(CellType type, int r, int c) 
	{
		map[r][c] = type;
	}
	public void update(CellType player) 
	{
		
	}
	/*public JLabel[][] draw() 
	{
		JLabel[][] labels = new JLabel[10][10];
		ImageIcon wall = new ImageIcon("brick-wall-pls.png");
		Image image = wall.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		wall = new ImageIcon(newimg);  // transform it back
		ImageIcon fish = new ImageIcon("fish.gif");
		Image fishI = fish.getImage();
		Image newFish = fishI.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		fish = new ImageIcon(newFish);
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				if (map[i][j] == (CellType.WALL)) 
				{
					JLabel label = new JLabel();
					label.setIcon(wall);
					labels[i][j] = label;
				}
				else if (map[i][j] == CellType.PLAYER_A) 
				{
					System.out.println("MAP" + i + " " + j);
					JLabel label = new JLabel();
					label.setIcon(fish);
					labels[i][j] = label;
				}
				else 
				{
					JLabel label = new JLabel();
					labels[i][j] = label;
				}
			}
		}
		return labels;
	}*/
}

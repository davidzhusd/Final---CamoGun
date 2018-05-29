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
	public void updateBullet(int or, int oc, int r, int c) 
	{
		
	}
	public void updatePlayer(int or, int oc, int r, int c, Actor player) 
	{
		map[or][oc] = CellType.EMPTY;
		if (player.amIPlayerOne()) 
		{
			map[r][c] = CellType.PLAYER_A;
		} else 
		{
			map[r][c] = CellType.PLAYER_B;
		}
	}
}

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map {
	private CellType[][] map;
	private CellType[][] mapOriginal;
	public void repair(int r, int c) 
	{
		map[r][c] = mapOriginal[r][c];
	}
	public Map(int alternate) //Makes map depending on what the user selects
	{
		//makes outer layer of walls no matter which map
		mapOriginal = new CellType[10][10];
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
		if (alternate == 1)
		{
			map[2][1] = CellType.PUDDLE;
			map[1][1] = CellType.PLAYER_A;
			map[8][8] = CellType.PLAYER_B;
			map[4][1]= CellType.BUSH;
			map[5][1]=CellType.BUSH;
			map[6][1]=CellType.BUSH;
			map[7][1]=CellType.BUSH;
			map[8][1]=CellType.BUSH;
			map[1][2]=CellType.PUDDLE;
			map[2][2]=CellType.EMPTY;
			map[3][2]=CellType.WALL;
			map[4][2]=CellType.WAll_B;
			map[5][2]=CellType.WALL;
			map[7][2]=CellType.WALL;
			map[1][3]=CellType.PUDDLE;
			map[2][3]=CellType.PUDDLE;
			map[5][3]=CellType.WALL;
			map[7][3]=CellType.WALL;
			map[2][4]=CellType.EMPTY;
			map[3][4]=CellType.WALL;
			map[4][4]=CellType.BUSH;
			map[5][4]=CellType.WALL;
			map[6][4]=CellType.WAll_B;
			map[7][4]=CellType.WALL;
			map[3][5]=CellType.WALL;
			map[4][5]=CellType.BUSH;
			map[5][5]=CellType.WALL;
			map[7][5]=CellType.WALL;
			map[8][5]=CellType.PUDDLE;
			map[1][6]=CellType.WALL;
			map[3][6]=CellType.WAll_B;
			map[7][6]=CellType.PUDDLE;
			map[8][6]=CellType.PUDDLE;
			map[1][7]=CellType.WALL;
			map[3][7]=CellType.WALL;
			map[6][7]=CellType.WAll_B;
			map[7][7]=CellType.WAll_B;
			map[8][7]=CellType.BUSH;
			map[1][8]=CellType.PUDDLE;
			map[2][8]=CellType.PUDDLE;
			map[3][8]=CellType.PUDDLE;
			map[4][8]=CellType.BUSH;
			map[5][8]=CellType.BUSH;
			map[6][8]=CellType.WALL;
			map[7][8]=CellType.WAll_B;
			for (int i = 0; i < 10; i++) 
			{
				for (int j = 0; j < 10; j++) 
				{
					if (map[i][j] == null) 
					{
						map[i][j] = CellType.EMPTY;
					}
				}
			}
		}
		if (alternate == 2)
		{
			map[1][1] = CellType.PLAYER_A;
			map[8][8] = CellType.PLAYER_B;
			map[1][4] = CellType.BUSH;
			map[2][4] = CellType.BUSH;
			map[3][4] = CellType.BUSH;
			map[4][1] = CellType.BUSH;
			map[4][2] = CellType.BUSH;
			map[4][3] = CellType.BUSH;
			map[5][6] = CellType.BUSH;
			map[5][7] = CellType.BUSH;
			map[5][8] = CellType.BUSH;
			map[7][5] = CellType.BUSH;
			map[8][5] = CellType.BUSH;
			map[2][5] = CellType.WAll_B;
			map[2][6] = CellType.WAll_B;
			map[2][7] = CellType.WAll_B;
			map[5][4] = CellType.WAll_B;
			map[5][5] = CellType.WAll_B;
			map[7][1] = CellType.WAll_B;
			map[7][2] = CellType.WAll_B;
			map[7][3] = CellType.WAll_B;
			map[7][4] = CellType.WAll_B;
			map[4][4] = CellType.WALL;
			map[4][5] = CellType.WALL;
			map[6][4] = CellType.WALL;
			map[6][5] = CellType.WALL;
			map[3][5] = CellType.PUDDLE;
			map[3][6] = CellType.PUDDLE;
			map[3][7] = CellType.PUDDLE;
			map[4][6] = CellType.PUDDLE;
			map[4][7] = CellType.PUDDLE;
			map[5][2] = CellType.PUDDLE;
			map[5][3] = CellType.PUDDLE;
			map[6][2] = CellType.PUDDLE;
			map[6][3] = CellType.PUDDLE;
			for (int i = 0; i < 10; i++) 
			{
				for (int j = 0; j < 10; j++) 
				{
					if (map[i][j] == null) 
					{
						map[i][j] = CellType.EMPTY;
					}
				}
			}
		}
		//fills in all remaining slots with empty
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				mapOriginal[i][j] = map[i][j];
			}
			mapOriginal[0][i] = CellType.WALL;
			mapOriginal[9][i] = CellType.WALL;
		}
		mapOriginal[1][1] = CellType.EMPTY;
		mapOriginal[8][8] = CellType.EMPTY;
	}
	//manually allows for a cell to be changed
	public void updateCell(int r, int c, CellType type) 
	{
		map[r][c] = type;
	}
	//manually allows for a cell to be changed in the original copy
	public void updateOriginalCell(int r, int c, CellType type) 
	{
		mapOriginal[r][c] = type;
	}
	//returns celltype in specified location
	public CellType getCellType(int r, int c) 
	{
		return map[r][c];
	}
	//returns celltype in original copy in specified location
	public CellType getOriginalCellType(int r, int c) 
	{
		return mapOriginal[r][c];
	}
	//returns map
	public CellType[][] updateMap() 
	{
		return map;
	}
	//specifically for bullets, moves the bullet graphically
	public void updateBullet(int or, int oc, int r, int c, Bullet bullet) 
	{
		map[or][oc] = mapOriginal[or][oc];
		if (bullet.amIBullet1()) 
		{
			map[r][c] = CellType.BULLET1;
		}
		else 
		{
			map[r][c] = CellType.BULLET2;
		}
	}
	//specifically for players, moves them graphically
	public void updatePlayer(int or, int oc, int r, int c, Actor player) 
	{
		map[or][oc] = mapOriginal[or][oc];
		if (player.amIPlayerOne()) 
		{
			if (mapOriginal[r][c] == CellType.BUSH) 
			{
				map[r][c] = CellType.BUSH_PLAYER;
			} 
			else if (mapOriginal[r][c] == CellType.PUDDLE) 
			{
				map[r][c] = CellType.PUDDLE_PLAYER;
			} 
			else 
			{
				map[r][c] = CellType.PLAYER_A;
			}
		} else 
		{
			if (mapOriginal[r][c] == CellType.BUSH) 
			{
				map[r][c] = CellType.BUSH_PLAYER;
			} 
			else if (mapOriginal[r][c] == CellType.PUDDLE) 
			{
				map[r][c] = CellType.PUDDLE_PLAYER;
			} 
			else 
			{
				map[r][c] = CellType.PLAYER_B;
			}
		}
	}
}

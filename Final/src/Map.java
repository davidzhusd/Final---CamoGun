import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map {
	private CellType[][] map;
	private CellType[][] mapOriginal;
	public Map() //MOST BASIC MAP
	{
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
		map[1][1] = CellType.PLAYER_A;
		map[8][8] = CellType.PLAYER_B;
		mapOriginal = map;
	}
	public void repair(int r, int c) 
	{
		map[r][c] = mapOriginal[r][c];
	}
	public Map(int alternate) //ACTUAL MAP
	{
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
		map[4][2]=CellType.WALL;
		map[5][2]=CellType.WALL;
		map[7][2]=CellType.WALL;
		map[1][3]=CellType.PUDDLE;
		map[2][3]=CellType.PUDDLE;
		map[5][3]=CellType.WALL;
		map[7][3]=CellType.WALL;
		map[1][4]=CellType.WALL;
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
		map[3][6]=CellType.WALL;
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
		map[6][8]=CellType.WAll_B;
		map[7][8]=CellType.WAll_B;
		//
		for (int i = 0; i < 10; i++) 
		{
			mapOriginal[0][i] = CellType.WALL;
			mapOriginal[9][i] = CellType.WALL;
		}
		for (int i = 1; i < 9; i++) 
		{
			mapOriginal[i][0] = CellType.WALL;
			mapOriginal[i][9] = CellType.WALL;
		}
		mapOriginal[4][1]= CellType.BUSH;
		mapOriginal[5][1]=CellType.BUSH;
		mapOriginal[6][1]=CellType.BUSH;
		mapOriginal[7][1]=CellType.BUSH;
		mapOriginal[8][1]=CellType.BUSH;
		mapOriginal[1][2]=CellType.PUDDLE;
		mapOriginal[2][2]=CellType.EMPTY;
		mapOriginal[3][2]=CellType.WALL;
		mapOriginal[4][2]=CellType.WALL;
		mapOriginal[5][2]=CellType.WALL;
		mapOriginal[7][2]=CellType.WALL;
		mapOriginal[1][3]=CellType.PUDDLE;
		mapOriginal[2][3]=CellType.PUDDLE;
		mapOriginal[5][3]=CellType.WALL;
		mapOriginal[7][3]=CellType.WALL;
		mapOriginal[1][4]=CellType.WALL;
		mapOriginal[2][4]=CellType.EMPTY;
		mapOriginal[3][4]=CellType.WALL;
		mapOriginal[4][4]=CellType.BUSH;
		mapOriginal[5][4]=CellType.WALL;
		mapOriginal[6][4]=CellType.WAll_B;
		mapOriginal[7][4]=CellType.WALL;
		mapOriginal[3][5]=CellType.WALL;
		mapOriginal[4][5]=CellType.BUSH;
		mapOriginal[5][5]=CellType.WALL;
		mapOriginal[7][5]=CellType.WALL;
		mapOriginal[8][5]=CellType.PUDDLE;
		mapOriginal[1][6]=CellType.WALL;
		mapOriginal[3][6]=CellType.WALL;
		mapOriginal[7][6]=CellType.PUDDLE;
		mapOriginal[8][6]=CellType.PUDDLE;
		mapOriginal[1][7]=CellType.WALL;
		mapOriginal[3][7]=CellType.WALL;
		mapOriginal[6][7]=CellType.WAll_B;
		mapOriginal[7][7]=CellType.WAll_B;
		mapOriginal[8][7]=CellType.BUSH;
		mapOriginal[1][8]=CellType.PUDDLE;
		mapOriginal[2][8]=CellType.PUDDLE;
		mapOriginal[3][8]=CellType.PUDDLE;
		mapOriginal[4][8]=CellType.BUSH;
		mapOriginal[5][8]=CellType.BUSH;
		mapOriginal[6][8]=CellType.WAll_B;
		mapOriginal[7][8]=CellType.WAll_B;
	}
	public CellType getCellType(int r, int c) 
	{
		return map[r][c];
	}
	public CellType getOriginalCellType(int r, int c) 
	{
		return mapOriginal[r][c];
	}
	public CellType[][] updateMap() 
	{
		return map;
	}
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
	public void updatePlayer(int or, int oc, int r, int c, Actor player) 
	{
		map[or][oc] = mapOriginal[or][oc];
		if (player.amIPlayerOne()) 
		{
			map[r][c] = CellType.PLAYER_A;
		} else 
		{
			map[r][c] = CellType.PLAYER_B;
		}
	}
}

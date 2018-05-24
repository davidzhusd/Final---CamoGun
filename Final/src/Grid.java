
public class Grid {

	private int numCol;
	private int numRow;
	private Tile[][] grid;
	public Grid(int row, int col)
	{
		numCol = col;
		numRow = row;
		grid = new Tile[row][col];
	}
	
}

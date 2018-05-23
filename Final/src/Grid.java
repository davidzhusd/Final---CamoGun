
public class Grid {

	private int numCol;
	private int numRow;
	private Actor[][] grid;
	public Grid(int row, int col)
	{
		numCol = col;
		numRow = row;
		grid = new Actor[row][col];
	}
	
}

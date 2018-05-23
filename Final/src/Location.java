 
public class Location {
	private int row;
	private int col;
	private Background back;
	public Location(int r, int c, Background back)
	{
		row=r;
		col=c;
		this.back = back;
	}
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return col;
	}
	
	
	public Background getAdjacentBackground(int direction)
	{
		return getAdjacentLocation(direction).getBackground();
	}
	
	public Background getBackground()
	{
		return back;
	}
	
	
	public Location getAdjacentLocation(int direction)
	{
		int rowChange=0;
		int colChange=0;
		int D=direction;
		switch(D)
		{
		case 0: rowChange=-1;
				break;
		case 45: rowChange=-1;
				 colChange=1;
				 break;
		case 90: colChange=1;
				 break;
		case 135: rowChange=1;
				  colChange=1;
				  break;
		case 180: rowChange=1;
				  break;
		case 225: rowChange=1;
				  colChange=-1;
				  break;
		case 270: colChange=-1;
				  break;
		case 315: colChange=-1;
				  rowChange=-1;
				  break;
		default: break;
		}
		return new Location(row+rowChange, col+colChange);
	}
	
}

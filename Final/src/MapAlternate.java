
public class MapAlternate {
Tile[][] map;

	public MapAlternate(int x)
	{
		map = new Tile[10][10];
	}

	public Tile[][] loadMap(int mapNumber)
	{
		
		if (mapNumber == 1)
		{
			//implement later
			return map;
		}
		
		if (mapNumber == 2)
		{
			//implement later
			return map;
		}
		
		if (mapNumber == 3)
		{
			//implement later
			return map;
		}
		
		for (int x = 0; x < 10; x++)
		{
			map[0][x] = new Tile(0,x,new Background(), new Player(0));
			map[9][x] = new Tile(9,x,new Background(), new Player(0));
			map[x][0] = new Tile(x,0,new Background(), new Player(0));
			map[x][9] = new Tile(x,9,new Background(), new Player(0));
		}
		return map;
	}
}

public class MapAlternate {
Tile[][] map;

	public MapAlternate()
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

		for (int x = 0; x < 10; x++){
			for (int y = 0; y < 10; y++){
				map[x][y] = new Tile(x,y,new Background());
			}
		}
		for (int x = 0; x < 10; x++)
		{
			map[0][x] = new Tile(0,x,new Background(), new Wall(0));
			map[9][x] = new Tile(9,x,new Background(), new Wall(0));
			map[x][0] = new Tile(x,0,new Background(), new Wall(0));
			map[x][9] = new Tile(x,9,new Background(), new Wall(0));
		}
		map[5][1] = new Tile(5,1, new Background(), new Player1(0));
		map[1][5] = new Tile(1,5, new Background(), new Player2(0));
		return map;
	}
}
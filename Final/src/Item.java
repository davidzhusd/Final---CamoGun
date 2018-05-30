
public class Item {
	Location myLocation;
	Actor player;
	public Item(Location loc) 
	{
		myLocation = loc;
	}
	public void setPlayer(Actor play) 
	{
		player = play;
	}
	public Actor getPlayer() 
	{
		return player;
	}
	public void setLocation(Location loc) 
	{
		myLocation = loc;
	}
	public Location getLocation() 
	{
		return myLocation;
	}
}

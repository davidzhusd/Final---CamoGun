
public class tile 
{
	private Location myLocation;
	private Background myBackground;
	private Actor myActor;
	public tile(int row, int col Background back, Actor act)
	{
		myLocation=new Location(row, col);
		myBackground=back;
		myActor=act;
	}
	public Location getLocation()
	{
		return myLocation;
	}
	public Background getBackground()
	{
		return myBackground;
	}
	public Actor getActor()
	{
		return myActor;
		
	}
}

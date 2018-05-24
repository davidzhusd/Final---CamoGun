
public class tile 
{
	private Location myLocation;
	private Background myBackground;
	private Actor myActor;
	public tile(Location loc, Background back, Actor act)
	{
		myLocation=loc;
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

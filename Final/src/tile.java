
public class tile 
{
	private Location myLocation;
	private Background myBackground;
	private player myPlayer;
	private bullet myBullet;
	public tile(int row, int col, Background back, player play)
	{
		myLocation=new Location(row, col);
		myBackground=back;
		myPlayer=play;
		myBullet=null;
	}
	public Location getLocation()
	{
		return myLocation;
	}
	public Background getBackground()
	{
		return myBackground;
	}
	public Actor getPlayer()
	{
		return myPlayer;
		
	}
	public void setPlayer(player P)
	{
		myPlayer=p;
	}
	public void receiveBullet(bullet B)
	{
		myBullet=B;
		
	}
}

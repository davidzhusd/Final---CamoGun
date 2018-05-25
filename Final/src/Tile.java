
public class Tile 
{
	private Location myLocation;
	private Background myBackground;
	private Player myPlayer;
	private Bullet myBullet;
	public Tile(int row, int col, Background back, Player play)
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
	public void setPlayer(Player P)
	{
		myPlayer=P;
		
	}
	public void receiveBullet(Bullet B)
	{
		myBullet=B;
		
	}
}

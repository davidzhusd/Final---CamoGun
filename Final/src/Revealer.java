
public class Revealer extends Item {
	public Revealer(Location loc) 
	{
		super(loc);
	}
	public void activate() 
	{
		super.player.addRevealer();
	}
}


public class Revealer extends Item {
	public Revealer(Location loc) 
	{
		super(loc);
	}
	public void activate(Actor player) 
	{
		player.addRevealer();
	}
}

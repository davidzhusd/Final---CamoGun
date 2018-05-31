
public class Shield extends Item{
	public Shield(Location loc) 
	{
		super(loc);
	}
	public void activate(Actor player) 
	{
		player.addShield();
	}
}

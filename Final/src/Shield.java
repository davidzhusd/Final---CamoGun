
public class Shield extends Item{
	public Shield(Location loc) 
	{
		super(loc);
	}
	public void activate() 
	{
		super.player.addShield();
	}
}

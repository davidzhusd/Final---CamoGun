
public class Display {
	Controller control;
	public void displayTitle()
	{
		TitleScreen title = new TitleScreen();
	}
	public void displayGame()
	{
		Game game = new Game();
	}
	public void displayOneWIN() 
	{
		WinOne one = new WinOne();
	}
	public void displayTwoWIN() 
	{
		WinTwo two = new WinTwo();
	}
	public void displayGameAlternate()
	{
		GameAlternate game = new GameAlternate(0,0);
	}
}

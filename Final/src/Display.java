
public class Display {
	Controller control;
	public void displayTitle()
	{
		TitleScreen title = new TitleScreen();
	}
	public void displayGame(int num)
	{
		Game game = new Game(num);
	}
	public void displayOneWIN() 
	{
		WinOne one = new WinOne();
	}
	public void displayTwoWIN() 
	{
		WinTwo two = new WinTwo();
	}
	public void displayInstructions() 
	{
		Instructions ins = new Instructions();
	}
	public void displayCredits() 
	{
		Credits cre = new Credits();
	}
}

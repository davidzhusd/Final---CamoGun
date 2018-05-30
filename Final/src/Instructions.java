

	import javax.swing.JFrame;
	import javax.swing.JLabel;

	public class Instructions extends JFrame{
		public WinOne() 
		{
			JLabel label = new JLabel("Instructions:"
					+ "Player 1 starts at top left corner, move with ASDW, and shoot with Space key"
					+ "Player 2 starts at bottom right corner, move with arrow keys, and shoot with L "
					+ "Players cannot see either their own character or the opposing character,"
					+ "you must deduce the location of your opponent through changes on the background and eliminate it"
					+"Hint: players cannot go through brick walls, may go through and break the breakable walls, and will cause changes to the puddle or bushes when going through them");
			label.setSize(100, 100);
			add(label);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(100, 100);
			setVisible(true);
		}
	}

}

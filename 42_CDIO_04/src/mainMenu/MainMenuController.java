package mainMenu;

import game.GameController;
import stringbanks.Stringbanks_MainMenu;
import board.Board;

public class MainMenuController {

	public void MainMenu()
	{

		Board board = Board.Board();
		board.generateBoard();
		GameController game = new GameController();

		MainMenuBoundary gui = new MainMenuBoundary();
		boolean ingame = true;
		while(ingame)
		{
			String input = gui.MainMenuDropDownMenu();
			if(input.equals(Stringbanks_MainMenu.getString(1)))
			{
				game = new GameController();
				game.startGame();
				ingame = false;
				gui.close();
				
			}
			else if(input.equals(Stringbanks_MainMenu.getString(2)))
			{
				gui.gameRules();
			}
			else
			{
				if(gui.confirmInput())
					ingame = false;
					break;
			}
		}
		gui.close();
	}

}

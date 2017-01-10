package mainMenu;

import board.Board;
import stringbanks.Stringbanks_MainMenu;

public class MainMenuController {


	public void MainMenu()
	{
		board.Board board = new board.Board();
		board.generateBoard();
		MainMenuBoundary gui = new MainMenuBoundary();
		while(true)
		{
			String input = gui.MainMenuDropDownMenu();
			if(input.equals(Stringbanks_MainMenu.getString(1)))
			{
				//game = new GameController();
				//game.startGame();
				gui.close();
				
			}
			else if(input.equals(Stringbanks_MainMenu.getString(2)))
			{
				gui.gameRules();
			}
			else
			{
				if(gui.confirmInput())
					break;
			}
		}
	}

}

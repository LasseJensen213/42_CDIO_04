package game;

import boundary.GameControllerBoundary;
import card.Cardgenerator;
import player.PlayerCreation;
import player.PlayerList;
import player.PlayerManager;


public class GameController {
	private PlayerList pList;
	private PlayerCreation playerCreate;
	private GameControllerBoundary gui;
	private GameLogic gLogic;
	private int playerIndex;

	public GameController() {
		playerCreate = new PlayerCreation();
		pList = new PlayerList();
		playerIndex = 0;								//Turn
		gui = new GameControllerBoundary();
		gLogic = new GameLogic();
	}

	public void startGame()
	{ 	
		
		playerCreate.initPlayers();
		
		pList = PlayerList.getPL();
		Cardgenerator.generateCards();
		
		while(true)
		{
			if(pList.get(playerIndex).isJailed())
			{
				gLogic.inJailTurn(pList.get(playerIndex));
			}
			else
			{
				gLogic.normalTurn(pList.get(playerIndex));
			}
			//Checks to see if the player gets an extra turn
			if(pList.get(playerIndex).getEqualFaceValue()>0)
			{

			}
			else
			{
				playerIndex = pList.nextPlayer(playerIndex);
			}

			if(pList.checkForWinner())
			{
				gui.showWinnerMsg(pList.get(playerIndex).getName());
				break;
			}


		}
		endGameSession();
	}
	
	/**
	 * This resets all the singletons instances, so that new ones can be made for a new game
	 */
	public void endGameSession()
	{
		
	}

}
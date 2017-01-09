package game;

import boundary.GameControllerBoundary;
import player.PlayerList;


public class GameController {

	private PlayerList pList;
	//private PlayerCreation playerCreate;
	//	private CardGenerator cardGen;
	private GameControllerBoundary gui;
	private GameLogic gLogic;
	int playerIndex;

	public GameController() {
		playerIndex = 0;
		gui = new GameControllerBoundary();
		gLogic = new GameLogic();
	}

	public void startGame()
	{
		//playerCreate.createPlayers();
		pList = PlayerList.getPL();
		//cardGen.createCards();
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
	}

}

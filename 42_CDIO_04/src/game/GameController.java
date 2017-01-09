package game;

import player.PlayerList;
import player.PlayerManager;

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
	}

	public void startGame()
	{
		//playerCreate.createPlayers();
		pList = PlayerList.getPL();
		//cardGen.createCards();
		gLogic = new GameLogic();
		while(true)
		{
			if(pList.get(playerIndex))
			{
				gLogic.inPrisonTurn(pList.get(playerTurn));
			}
			else
			{
				gLogic.normalTurn(pList.get(playerTurn));
			}
			//checks whether the player went in jail during his turn
			//And makes sure he doesn't get an extra turn
			if(pList.get(playerIndex).isInjail())
			{
				pList.get(playerTurn).setEqualFaceValue(0);
			}
			//Checks to see if the player gets an extra turn
			if(pList.get(playerTurn).getEqualFaceValue()>0)
			{

			}
			else
			{
				playerIndex = pList.nextPlayer();
			}

			if(pList.checkForWinner())
			{
				gui.showWinnerMsg(pList.get(playerIndex).getName);
				break;
			}


		}
	}

}

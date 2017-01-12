package game;

import board.Board;
import boundary.GameControllerBoundary;
import card.CardDeck;
import card.Cardgenerator;
import desktop_resources.GUI;
import player.PlayerCreation;
import player.PlayerList;


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
			gui.announceTurn(pList.get(playerIndex).getName());
			if(pList.get(playerIndex).isJailed())
			{
				gLogic.inJailTurn(pList.get(playerIndex));
			}
			else
			{
				gLogic.normalTurn(pList.get(playerIndex));
			}
			
			updateAllBalance();
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

	

	public void updateAllBalance()
	{
		for(int i = 0; i<pList.getNPlayers();i++)
		{
			String name = pList.get(i).getName();
			int balance = pList.get(i).getAccount().getBalance();
			gui.updateBalance(name,balance);
		}

	}
	/**
	 * This resets all the singletons instances, so that new ones can be made for a new game
	 */
	public void endGameSession()
	{
		PlayerList.resetPlayerList();
		Board.resetBoard();
		CardDeck.resetCardDeck();
				
	}

}
package game;

import java.util.ArrayList;

import boundary.GameLogicBoundary;
import desktop_resources.GUI;
import dice.DiceCup;
import game.LandOnFieldController;
import player.Player;
import stringbanks.Stringbanks_GameLogic;

public class GameLogic {

	private DiceCup diceCup;
	private PropertyController prop;
	private LandOnFieldController landOn;
	private GameLogicBoundary gui;
	private Bank bank;
	public GameLogic() 
	{
		bank = Bank.getBank();
		diceCup = DiceCup.getDC();
		prop = new PropertyController();
		landOn = new LandOnFieldController();
		gui = new GameLogicBoundary();
	}


	public void normalTurn(Player player)
	{
		int d1,d2;
		if(player.getProperty().nFields() != 0) {
			prop.buyAssets(player);
		}
		if(!player.isBroke()) {
			gui.AskToRollDice(player.getName());
			diceCup.rollDice();
			d1 = diceCup.getDiceValue(0);
			d2 = diceCup.getDiceValue(1);
			gui.showDiceRolling(d1,d2);

			if(d1==d2)
			{
				player.setEqualFaceValue(player.getEqualFaceValue()+1);
			}
			else
			{
				player.setEqualFaceValue(0);
			}


			if(player.getEqualFaceValue()==3)
			{	
				gui.goToJail();
				player.setJailed(true);
				player.setEqualFaceValue(0);
				player.setPassedStart(false);
				int distance;
				distance = (40-player.getPlayerPos()+10)%40;
				gui.movePlayerModel(player.getName(), player.getPlayerPos(), distance);
				updatePlayerPos(player,distance);
				player.setPlayerPos(10);

			}
			else
			{
				gui.movePlayerModel(player.getName(), player.getPlayerPos(), d1+d2);
				updatePlayerPos(player,d1+d2);
				landOn.landOnField(player);
				GUI.setBalance(player.getName(), player.getAccount().getBalance());
			}
			
			if(player.getAccount().getBalance()<=0)
			{
				if(player.getProperty().totalValueOfAssets()/2>Math.abs(player.getAccount().getBalance()))
					prop.sellAssets(player);
			}
			//Checking if the player managed to sell enough assets
			if(player.getAccount().getBalance()<=0)
			{
				gui.playerIsBroke(player.getName());
				playerIsBroke(player);
			}
		}
		else if(player.isBroke()) {
			//message "player is broke"
			gui.playerIsBroke(player.getName());
			playerIsBroke(player);
		}



	}


	public void inJailTurn(Player player)
	{
		ArrayList<String> optionsList = new ArrayList<String>();
		if(player.getProperty().nCards()>0)
		{
			optionsList.add(Stringbanks_GameLogic.inJailTurn(2));
		}
		if(player.getAccount().getBalance()>1000)
		{
			optionsList.add(Stringbanks_GameLogic.inJailTurn(3));
		}
		optionsList.add(Stringbanks_GameLogic.inJailTurn(1));
		String[] options = new String[0];
		String choice = gui.jailChoices(player.getName(),optionsList.toArray(options));
		int d1,d2;
		if(choice.equals(Stringbanks_GameLogic.inJailTurn(1)))
		{
			player.setTimeInJail(player.getTimeInJail()+1);
			diceCup.rollDice();
			d1 = diceCup.getDiceValue(0);
			d2 = diceCup.getDiceValue(1);
			gui.showDiceRolling(d1, d2);
			if(d1==d2)
			{
				player.setTimeInJail(0);
				player.setJailed(false);
				player.setEqualFaceValue(player.getEqualFaceValue()+1);
				gui.movePlayerModel(player.getName(), player.getPlayerPos(), d1+d2);
				updatePlayerPos(player,d1+d2);
				landOn.landOnField(player);

				if(player.getAccount().getBalance()<=0)
				{
					if(player.getProperty().totalValueOfAssets()/2>Math.abs(player.getAccount().getBalance()))
						prop.sellAssets(player);
				}
				//Checking if the player managed to sell enough assets
				if(player.getAccount().getBalance()<=0)
				{
					gui.playerIsBroke(player.getName());
					playerIsBroke(player);
				}
			}
			else if(player.getTimeInJail()==3)
			{
				player.setTimeInJail(0);
				player.setJailed(false);
				player.getAccount().withdraw(1000);
				gui.tooLongTimeInPrison(player.getName());
			}
		}
		else if(choice.equals(Stringbanks_GameLogic.inJailTurn(3)))
		{
			player.setJailed(false);
			player.setTimeInJail(0);
		}
		else if(choice.equals(Stringbanks_GameLogic.inJailTurn(2)))
		{
			player.setJailed(false);
			player.setTimeInJail(0);
		}

	}

	public void playerIsBroke(Player player)
	{
		player.setBroke(true);
		player.getAccount().setBalance(0);
		player.setEqualFaceValue(0);
		int nTer = player.getProperty().nTerritoriesOwned();
		//First loops over the territories, since the houses has to be freed aswell
		for(int i = 0 ; i<nTer;i++)
		{
			System.out.println("--removing territories--");
			player.getProperty().getTerritory(0).setOwner(null);
			player.getProperty().getField(0).setPawned(false);
			GUI.setSubText(player.getProperty().getField(0).getFieldPosition(), "");
			gui.removeOwner(player.getProperty().getTerritory(0).getFieldPosition());

			int housesUsed = player.getProperty().getTerritory(0).getHouse();
			if(housesUsed == 5)
			{
				player.getProperty().getTerritory(0).setHouse(0);
				bank.hotelsFreed(1);
			}
			else{
				bank.housesFreed(housesUsed);;
				player.getProperty().getTerritory(0).setHouse(0);
			}
			player.getProperty().removeField(player.getProperty().getTerritory(0));
		}

		int restOfFields = player.getProperty().nFields();
		for(int i = 0; i<restOfFields;i++)
		{
			player.getProperty().getField(0).setOwner(null); 
			player.getProperty().getField(0).setPawned(false);
			GUI.setSubText(player.getProperty().getField(0).getFieldPosition(), "");
			gui.removeOwner(player.getProperty().getField(0).getFieldPosition());
			player.getProperty().removeField(player.getProperty().getField(0));
		}

		for(int i = 0 ; i<player.getProperty().nCards();i++)
		{
			player.getProperty().removeCard();
		}
		gui.removeCar(player.getName(),player.getPlayerPos());
	}

	public void updatePlayerPos(Player player, int distance)
	{
		for(int i = 0;i<distance;i++ )
		{
			player.setPlayerPos((player.getPlayerPos()+1)%40);
			if(player.getPlayerPos()==1)
			{
				if(player.isPassedStart())
				{
					player.getAccount().deposit(4000);
					gui.passedStart(player.getName());
					gui.updatePlayerBalance(player.getName(), player.getAccount().getBalance());
				}
				else
					player.setPassedStart(true);
			}
		}
	}



}

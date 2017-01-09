package game;

import java.util.ArrayList;

import boundary.GameLogicBoundary;
import dice.DiceCup;
import field.LandOnFieldController;
import player.Player;

public class GameLogic {

	DiceCup diceCup;
	PropertyController prop;
	LandOnFieldController landOn;
	GameLogicBoundary gui;
	public GameLogic() 
	{
		diceCup = DiceCup.getDC();
		prop = new PropertyController();
		landOn = new LandOnFieldController();
		gui = new GameLogicBoundary();
	}
	
	
	public void normalTurn(Player player)
	{
		int d1,d2;
		prop.buyAssets(player);
		gui.AskToRollDice();
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
			player.setJailed(true);
			player.setEqualFaceValue(0);
			int distance;
			distance = 40-player.getPlayerPos()+10;
			gui.movePlayerModel(player.getName(), player.getPlayerPos(), distance);
			updatePlayerPos(player,distance);
			player.setPlayerPos(10);
			
		}
		else
		{
			gui.movePlayerModel(player.getName(), player.getPlayerPos(), d1+d2);
			updatePlayerPos(player,d1+d2);
			landOn.landOnField(player);
			
			if(player.getAccount().getBalance()<=0)
			{
				//prop.sellAssets();
			}
			//Checking if the player managed to sell enough assets
			if(player.getAccount().getBalance()<=0)
			{
				playerIsBroke(player);
			}
		}
		

		
	}
	
	
	public void inJailTurn(Player player)
	{
		ArrayList<String> optionsList = new ArrayList<String>();
		if(player.getProperty().nCards()>0)
		{
			optionsList.add("Brug benådelses kort");
		}
		if(player.getAccount().getBalance()>1000)
		{
			optionsList.add("Betal kautionen på 1000");
		}
		optionsList.add("Kast med terningerne... Brian");
		String[] options = new String[0];
		String choice = gui.jailChoices(optionsList.toArray(options));
		int d1,d2;
		if(choice.equals("Kast med terningerne... Brian"))
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
					//prop.sellAssets();
				}
				//Checking if the player managed to sell enough assets
				if(player.getAccount().getBalance()<=0)
				{
					playerIsBroke(player);
				}
			}
			else if(player.getTimeInJail()==3)
			{
				
			}
		}
		else if(choice.equals("Betal kautionen på 1000"))
		{
			player.setJailed(false);
			player.setTimeInJail(0);
		}
		else if(choice.equals("Brug benådelses kort"))
		{
			player.setJailed(false);
			player.setTimeInJail(0);
		}
		
	}
	
	public void playerIsBroke(Player player)
	{
		player.setBroke(true);
		player.getAccount().setBalance(0);
		for(int i = 0 ; i<player.getProperty().nFields();i++)
		{
			player.getProperty().get(i);
			gui.removeOwner(player.getProperty().get(i).getFieldPosition());
			player.getProperty().removeField(player.getProperty().get(i));
		}
		for(int i = 0 ; i<player.getProperty().nCards();i++)
		{
			
		}
		gui.removeCar(player.getName(),player.getPlayerPos());
	}
	
	public void updatePlayerPos(Player player, int distance)
	{
		for(int i = 0;i<distance;i++ )
		{
			player.setPlayerPos((player.getPlayerPos()+1)%40);
			if(player.getPlayerPos()==0)
			{
				if(player.isPassedStart())
					player.getAccount().deposit(4000);
				else
					player.setPassedStart(true);
			}
		}
	}
	
	

}

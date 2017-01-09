package game;

import boundary.GameLogicBoundary;
import dice.DiceCup;
import field.LandOnFieldController;
import player.Player;

public class GameLogic {

	DiceCup diceCup;
	PropertyController prop;
	LandOnFieldController landOn;
	GameLogicBoundary gui = new GameLogicBoundary();
	public GameLogic() 
	{
		diceCup = DiceCup.getDC();
		prop = new PropertyController();
		landOn = new LandOnFieldController();
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
			player.setPlayerPos(10);
			
		}
		else
		{
			landOn.landOnField(player);
			
			if(player.getAccount().getBalance()<=0)
			{
				prop.sellAssets();
			}
			//Checking if the player managed to sell enough assets
			if(player.getAccount().getBalance()<=0)
			{
				
			}
		}
		

		
	}
	
	
	public void inJailTurn(Player player)
	{
		
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
		gui.removeCar(player.getName(),player.getPlayerPos());
	}
	
	

}

package boundary;

import desktop_resources.GUI;
import stringbanks.Stringbanks_GameLogic;

public class GameLogicBoundary {

	public GameLogicBoundary() {
		// TODO Auto-generated constructor stub
	}
	
	public  void AskToRollDice(String name)
	{
		GUI.getUserButtonPressed(String.format(Stringbanks_GameLogic.normalTurn(0), name), 
								 Stringbanks_GameLogic.normalTurn(1));
	}
	
	public void showDiceRolling(int d1, int d2)
	{
		GUI.setDice(d1, d2);
	}
	
	public void movePlayerModel(String name, int pos, int distance)
	{
		
	}
	
	public void updatePlayerBalance(String name, int balance)
	{
		GUI.setBalance(name, balance);
	}
	
	public void removeOwner(int fieldNumber)
	{
		GUI.removeOwner(fieldNumber);
	}
	
	public void removeCar(String name, int fieldNumber)
	{
		GUI.removeCar(fieldNumber, name);
	}
	
	public String jailChoices(String name, String[] options)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_GameLogic.inJailTurn(0), name), options);
	}

}

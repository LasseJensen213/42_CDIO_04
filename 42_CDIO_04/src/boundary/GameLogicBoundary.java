package boundary;

import desktop_resources.GUI;

public class GameLogicBoundary {

	public GameLogicBoundary() {
		// TODO Auto-generated constructor stub
	}
	
	public  void AskToRollDice()
	{
		GUI.getUserButtonPressed("KAST MED TERNINGERNE BRIAN!", "SÅ KAST DOG!");
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
	
	public String jailChoices(String[] options)
	{
		return GUI.getUserButtonPressed("DU ER I FÆNGSEL BRIAN", options);
	}

}

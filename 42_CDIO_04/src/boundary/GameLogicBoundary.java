package boundary;

import java.util.concurrent.TimeUnit;

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
		//only moves the player on the board. Doesn't actually update their position
		for(int i = 0; i<distance; i++)
		{
			GUI.removeCar(pos+1, name);
			pos = (pos+1)%40;
			GUI.setCar(pos+1, name);
			try {
				TimeUnit.MILLISECONDS.sleep(100);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void updatePlayerBalance(String name, int balance)
	{
		GUI.setBalance(name, balance);
	}
	
	public void removeOwner(int fieldNumber)
	{
		GUI.removeOwner(fieldNumber+1);
	}
	
	public void removeCar(String name, int fieldNumber)
	{
		GUI.removeCar(fieldNumber+1, name);
	}
	
	public String jailChoices(String name, String[] options)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_GameLogic.inJailTurn(0), name), options);
	}

	public void playerIsBroke(String name)
	{
		GUI.showMessage(String.format(Stringbanks_GameLogic.normalTurn(2), name));
	}
	
	public void goToJail() {
		GUI.showMessage("De har slået 3 ens og rykker derfor i fængsel");
	}
}

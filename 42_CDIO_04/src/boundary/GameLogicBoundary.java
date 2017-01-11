package boundary;

import java.util.Random;
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
		Random rand = new Random();
		int faceValue1, faceValue2;
		int x1 = rand.nextInt(4)+4;
		int y1 = rand.nextInt(4)+4;
		//Second dice's position is relative to the first
		int x2 = x1+rand.nextInt(5)-2;
		int y2 = y1+rand.nextInt(5)-2;

		if(x1==x2 && y1 == y2)
		{
			x1++;
		}

		int rotation1 =rand.nextInt(360);
		int rotation2 =rand.nextInt(360);
		//Simulates The dice rolling
		


				for(int i = 0; i<1;i++)
				{
					faceValue1 = rand.nextInt(6)+1;
					faceValue2 = rand.nextInt(6)+1;
					for(int k = 0; k<12;k++)
					{
						GUI.setDice(faceValue1, rotation1, x1, y1, faceValue2, rotation2, x2, y2);
						rotation1 = (rotation1+10)%360;
						rotation2 = (rotation2+10)%360;
						try {
							TimeUnit.MILLISECONDS.sleep(13);
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println("Roll dice InterruptedException");
						}
					}
				}
			//Shows the real result
			GUI.setDice(d1, rotation1, x1, y1, d2, rotation2, x2, y2);


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

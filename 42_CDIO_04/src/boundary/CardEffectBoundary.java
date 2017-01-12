package boundary;

import java.util.concurrent.TimeUnit;

import desktop_resources.GUI;
import stringbanks.Stringbank_Card;

public class CardEffectBoundary {

	private static int sleep = 100; //Number of ms the system sleeps 400 ms is normal.


	/**
	 * Moves the player model around on the board and skips the start field
	 * This does not update the player's actual position in the game
	 * 
	 * @param name
	 * @param playerPos - the players starting position
	 * @param distance -  the distance to the new position 
	 */
	public static void moveFigure(String name, int playerPos, int distance){

		//only moves the player on the board. Doesn't actually update their position
		GUI.removeCar(playerPos+1, name);

		if(distance > 0) {
			for(int i = 0; i<distance; i++)
			{

				GUI.removeCar(playerPos+1, name);
				playerPos =(playerPos+1)%40;
				GUI.setCar(playerPos+1, name);
				try {
					TimeUnit.MILLISECONDS.sleep(sleep);

				} catch (InterruptedException e) {
					System.out.println("WHY U NO SLEEP. CardEffectBoundary");
					// TODO Auto-generated catch block
					e.printStackTrace();


				}
			}
		}
		else if(distance < 0) {
			for(int i = 0; i<Math.abs(distance); i++)
			{

				GUI.removeCar(playerPos+1, name);
				if(playerPos == 0){
					playerPos = 39;
				}
				else{
					playerPos =((playerPos-1)%40);
				}
				GUI.setCar(playerPos+1, name);
				try {
					TimeUnit.MILLISECONDS.sleep(sleep);

				} catch (InterruptedException e) {
					System.out.println("WHY U NO SLEEP. CardEffectBoundary");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	}


	public static void showMessage(int i) {
		GUI.showMessage(Stringbank_Card.getMessages(i));
	}

	public static void youDraw() {
		String message = "De trak kortet:";
		message = String.format(message);
		GUI.showMessage(message);
	}

}

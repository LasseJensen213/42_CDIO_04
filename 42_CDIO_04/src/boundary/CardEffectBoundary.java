package boundary;

import java.util.concurrent.TimeUnit;

import desktop_resources.GUI;

public class CardEffectBoundary {

	private static int sleep = 0; //Number of ms the system sleeps 400 ms is normal.


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
		for(int i = 0; i<distance; i++)
		{

			GUI.removeCar(playerPos, name);
			playerPos =(playerPos+1)%40;
			GUI.setCar(playerPos, name);
			try {
				TimeUnit.MILLISECONDS.sleep(sleep);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();


			}
		}


	}




}

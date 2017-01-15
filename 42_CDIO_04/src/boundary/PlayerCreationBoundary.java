package boundary;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import stringbanks.Stringbanks_PlayerCreation;

public class PlayerCreationBoundary {

	Stringbanks_PlayerCreation s = new Stringbanks_PlayerCreation();

	
	public PlayerCreationBoundary() {


		
	}
	
	
	/**
	 * Adds the player and sets the player's car on the board
	 * @param name
	 * @param balance
	 * @param car
	 */
	public void addPlayer(String name, int balance, Car car) {
		GUI.addPlayer(name, balance, car);
		GUI.setCar(1, name);

	}
	/**
	 * Shows a message on the board
	 * 0 : chooseName <br>
 	 * 1 : nameToLong <br>
     * 2 : noInput <br>
     * 3 : nameTaken <br>
     * 4 : chooseColor <br>
     * 5 : chooseNumPlayers <br> 
	 * @param i
	 */
	public void showMessage(int i) {
		GUI.showMessage(s.getMessages(i));
	}
	
	/**
	 * Returns the different kind of colors the players car can be.
	 * @param i
	 * @return
	 */
	public String getColors(int i) {
		return s.getColors(i);
	}
	
	/**
	 * Returns one of the following messages
	 * 0 : chooseName <br>
 	 * 1 : nameToLong <br>
     * 2 : noInput <br>
     * 3 : nameTaken <br>
     * 4 : chooseColor <br>
     * 5 : chooseNumPlayers <br> 
	 * @param i
	 * @return
	 */
	public String getMessages(int i) {
		return s.getMessages(i);
		
	}
	
	/**
	 * Returns user string
	 * @param i
	 * @return
	 */
	public String getUserString(int i) {
		return GUI.getUserString(s.getMessages(i));
	}
	
	/**
	 * Makes the players state how many players there is in the game.
	 * @return
	 */
	public int chooseNPlayers() {
		return Integer.parseInt(GUI.getUserSelection(s.getMessages(5), new String[]{"2","3","4","5","6"}));
	}
	
	/**
	 * Makes the players choose a color for their car
	 * @param colorArr
	 * @return
	 */
	public String chooseColor(String[] colorArr) {
		return GUI.getUserSelection(s.getMessages(4),colorArr);
	}
}

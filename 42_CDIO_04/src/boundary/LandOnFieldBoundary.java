package boundary;

import desktop_resources.GUI;
import stringbanks.Stringbanks_LandOnFieldBoundary;

public class LandOnFieldBoundary {
	Stringbanks_LandOnFieldBoundary s = new Stringbanks_LandOnFieldBoundary();

	public static boolean buyChoice(){
		String[] options = {"Ja", "Nej"};
		return GUI.getUserButtonPressed("Vil du købe?", options).equals(options[0]);
	}
	
	public static void moveToJail(String name, int pos){
		GUI.removeCar(pos, name);
		GUI.setCar(10, name);
	}
	
	public static void setPlayerColorOnField(String name, int number){
	GUI.setOwner(number, name);
	}
	
	public static void payOtherPlayer(String s, int i) {
		String message = "De skal betale @s @d kroner.";
		message = String.format(message,s, i);
		GUI.showMessage(message);
		
	}
	
	public static void payTax(int rent) {
		String message = "De skal betale @d i skat";
		message = String.format(message, rent);
		GUI.showMessage(message);
	}
	
	/**
	 * Displays a message, when a player lands on a field. <br>
	 * 0 : landOnJail  <br> 
	 * 1 : landOnStart <br>
	 * 2 : landOnGoToJail <br>
	 * 3 : landOnChance <br> 
	 * @param number
	 * 
	 */
	public static void displayMessage(int number) {
		Stringbanks_LandOnFieldBoundary s = new Stringbanks_LandOnFieldBoundary();
		
		GUI.showMessage(s.getMessages(number));
	}
	
	public static void displayCard(String txt) {
		GUI.displayChanceCard(txt);
	}
}

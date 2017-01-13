package boundary;

import desktop_resources.GUI;
import field.Field;
import field.Ownable;
import stringbanks.Stringbanks_LandOnFieldBoundary;

public class LandOnFieldBoundary {
	Stringbanks_LandOnFieldBoundary s = new Stringbanks_LandOnFieldBoundary();

	public static boolean buyChoice(Field f){
		String[] options = {"Ja", "Nej"};
		return GUI.getUserButtonPressed("Vil du købe " + f.getTitle() +". Pris: " + ((Ownable)f).getPrice(), options).equals(options[0]);
	}
	
	public static void moveToJail(String name, int pos){
		GUI.removeCar(pos+1, name);
		GUI.setCar(10+1, name);
	}
	
	public static void setPlayerColorOnField(String name, int number){
	GUI.setOwner(number+1, name);
	}
	
	public static void payOtherPlayer(String s, int i) {
		String message = "De skal betale %s Kr. %d.";
		message = String.format(message,s, i);
		GUI.showMessage(message);
		
	}
	
	public static boolean chooseTax() {
		boolean statement = false;
		String[] choices = {"4000","10% af alt hvad de ejer"};
		String message = "Vælg imellem at betale";		
		
		String input = GUI.getUserSelection(message, choices);
		if(input.equals(choices[0])) {
			statement = true;
		}
		else if(input.equals(choices[1]))
			statement = false;
		return statement;
	}
	
	public static void payTax(int rent) {
		String message = "De skal betale %d i skat";
		message = String.format(message, rent);
		GUI.showMessage(message);
	}
	
	public static void payOwner(int rent, String name) {
		String message = "De skal betale %d i leje til %s";
		message = String.format(message, rent, name);
		GUI.showMessage(message);
	}
	
	public static void youLandOn(String name) {
		String message = "De landede på %s";
		message = String.format(message, name);
		GUI.showMessage(message);
	}
	
	public static void parkingLotMoney(int money) {
		String message = "De tager pengene på Parkeringspladsen. Modtag %d";
		message = String.format(message, money);
		GUI.showMessage(message);
	}
	
	/**
	 * Displays a message, when a player lands on a field. <br>
	 * 0 : landOnJail  <br> 
	 * 1 : landOnStart <br>
	 * 2 : landOnGoToJail <br>
	 * 3 : landOnChance <br> 
	 * 4 : pawned <br>
	 * @param number
	 * 
	 */
	public static void displayMessage(int number) {
		Stringbanks_LandOnFieldBoundary s = new Stringbanks_LandOnFieldBoundary();
		if(number==3) {
			GUI.getUserButtonPressed(s.getMessages(number), "Træk");
		}
		else
			GUI.showMessage(s.getMessages(number));
	}
	
	public static void displayCard(String txt) {
		GUI.setChanceCard(txt);
		GUI.displayChanceCard(txt);
	}
	
	public static boolean cantAffordToBuy()
	{
		Stringbanks_LandOnFieldBoundary s = new Stringbanks_LandOnFieldBoundary();
		return GUI.getUserLeftButtonPressed(s.getMessages(5), s.getMessages(6), s.getMessages(7));
	}
}

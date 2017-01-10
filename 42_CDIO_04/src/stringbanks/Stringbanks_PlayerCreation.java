package stringbanks;

public class Stringbanks_PlayerCreation {

	String chooseName = "Indtast deres navn.";
	String nameToLong = "Deres navn er for langt - Indtast venligt et andet navn";
	String noInput = "Player";
	String nameTaken = "Det indtastede navn er allerede blevet valgt. Indtast venligst et andet navn";
	String chooseColor = "Vælg en farve til deres bil";
	String chooseNumPlayers = "Vælg antallet af spillere";
	
	String messages[] = {chooseName,nameToLong,noInput, nameTaken,chooseColor,chooseNumPlayers};
	
	
	//Choose Color:
	
	String colorMessages[] = {chooseColor};
	String colors[] = {"Blå", "Grøn", "Rød", "Gul", "Hvid", "Pink"};
	
	/**
	 * 0 : chooseName <br>
	 * 1 : nameToLong <br>
	 * 2 : noInput <br>
	 * 3 : nameTaken <br>
	 * 4 : chooseColor <br>
	 * 5 : chooseNumPlayers <br>
	 * @param number
	 * @return
	 */
	public String getMessages(int number) {
		return messages[number];
	}
	
	public String getColors(int number) {
		return colors[number];
	}

}
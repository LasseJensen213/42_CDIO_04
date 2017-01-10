package stringbanks;

public class Stringbanks_LandOnFieldBoundary {
	
	
	String landOnJail = "De er på besøg i fængsel";
	String landOnStart = "De er landet på \"START\"";
	String landOnGoToJail = "De skal i fængsel";
	String landOnChance = "Træk et chancekort";

	String messages[] = {landOnJail,landOnStart,landOnGoToJail,landOnChance};
	
	
	/**
	 * 0 : landOnJail  <br>
	 * 1 : landOnStart <br>
	 * 2 : landOnGoToJail <br>
	 * 3 : landOnChance <br>
	 * @param number
	 * @return landOnField message
	 */
	
	public String getMessages(int number) {
		return messages[number];
	}
}

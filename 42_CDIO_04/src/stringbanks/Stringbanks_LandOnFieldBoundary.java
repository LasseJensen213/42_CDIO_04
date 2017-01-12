package stringbanks;

public class Stringbanks_LandOnFieldBoundary {
	
	
	private String landOnJail = "De er på besøg i fængsel";
	private String landOnStart = "De er landet på \"START\"";
	private String landOnGoToJail = "De skal i fængsel";
	private String landOnChance = "Træk et chancekort";
	private String pawned = "Feltet er pantsæt, og de skal derfor ikke betale nogen leje";
	private String cantAffordToBuy = "Du har ikke penge nok til at købe dette felt";
	private String chooseToPawn = "Pantsæt";
	private String chooseNotTo = "Nej - gå videre";

	private String messages[] = {landOnJail,landOnStart,landOnGoToJail,landOnChance,pawned,cantAffordToBuy,chooseToPawn,chooseNotTo};
	
	
	/**
	 * 0 : landOnJail  <br>
	 * 1 : landOnStart <br>
	 * 2 : landOnGoToJail <br>
	 * 3 : landOnChance <br>
	 * 4 : pawned <br>
	 * 5 : cantAffordToPawn<br>
	 * 6 : chooseToPawn<br>
	 * 7 : chooseNotTo<br>
	 * @param number
	 * @return landOnField message
	 */
	
	public String getMessages(int number) {
		return messages[number];
	}
}

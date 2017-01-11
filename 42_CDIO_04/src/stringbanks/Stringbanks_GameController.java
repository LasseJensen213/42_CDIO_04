package stringbanks;

public class Stringbanks_GameController {
	
	private static String winnerMsg = "%s er den heldige kartoffel";
	private static String announceTurn = "Det er %s' tur";
	
	private static String[] messages = {winnerMsg,announceTurn};
	
	/**0 = winnerMsg
	 * 1 = announceTUrn (Needs player name)
	 * @param i
	 */
	public static String get(int i)
	{
		return messages[i];
	}

}

package stringbanks;

public class Stringbanks_GameLogic {

	private static String inJailMenuMsg = "%s du er i fængsel, vælg fra følgende muligheder";
	private static String inJailRollDice = "Kast med terninger";
	private static String inJailUseCard = "Brug benådelses kort";
	private static String inJailPayBail = "Betal kaution: 1000kr";
	
	private static String normalTurnMenuMsg = "%s: Kast med terningerne";
	private static String normalTurnThrowDice = "Kast";
	
	private static String playerIsBroke = "%s er gået konkurs";
	private static String passedStart = "%s har modtaget 4000 kr, for at passere start";
	private static String tooLongInJail = "%s har været i fængsel i for lang tid, betal 1000 kr til banken";
	
	
	private static String[] normalTurn = {normalTurnMenuMsg,normalTurnThrowDice, playerIsBroke,passedStart, tooLongInJail };
	private static String[] inJailTurn = {inJailMenuMsg, inJailRollDice, inJailUseCard, inJailPayBail};
	
	/**
	 * 0 = normalTurnMsg(needs player name)<br>
	 * 1 = normalTurnThrowDice<br>
	 * 2 = playerIsBroke (Needs name)<br>
	 * 3 = passedStart (needs name)<br>
	 * 4 = tooLongInJail (needs name)<br>
	 * @param i
	 * @return
	 */
	public static String normalTurn(int i)
	{
		return normalTurn[i];
	}
	
	/**
	 * 0 = inJailMenuMsg(needs player name)<br>
	 * 1 = inJailRollDice<br>
	 * 2 = inJailUseCard<br>
	 * 3 = inJailPayBail<br>
	 * @param i
	 * @return
	 */
	public static String inJailTurn(int i)
	{
		return inJailTurn[i];
	}

	

}

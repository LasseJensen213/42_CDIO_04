package stringbanks;

public class Stringbanks_GameLogic {

	private static String inJailMenuMsg = "%s du er i fængsel, vælg fra følgende muligheder";
	private static String inJailRollDice = "Kast med terninger";
	private static String inJailUseCard = "Brug benådelses kort";
	private static String inJailPayBail = "Betal kaution: 1000kr";
	
	private static String normalTurnMenuMsg = "%s: Kast med terningerne";
	private static String normalTurnThrowDice = "Kast";
	
	private static String[] normalTurn = {normalTurnMenuMsg,normalTurnThrowDice};
	private static String[] inJailTurn = {inJailMenuMsg, inJailRollDice, inJailUseCard, inJailPayBail};
	
	/**
	 * 0 = normalTurnMsg(needs player name)<br>
	 * 1 = normalTurnThrowDice<br>
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

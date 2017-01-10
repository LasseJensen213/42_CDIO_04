package stringbanks;

import desktop_codebehind.Car;

public class Stringbanks_MainMenu {

	private static String menuMsg  		  = "Vælg fra menuen";
	private static String startGame 	  = "Start spil";
	private static String showRules		  = "Vis spillets regler";
	private static String rules           = "REGLER REGLER BLA BLA BLA\n BLA BLA BLA";
	private static String closeGame       = "Luk spillet";
	private static String confirmInputMsg = "Er du sikker på at du vil lukke spillet?";
	private static String yes             = "Ja";
	private static String no			  = "Nej";
	
	private static String[] allMsgs = {menuMsg,startGame,showRules,rules,closeGame,confirmInputMsg,yes,no};
	
	/**
	 * 0 = menuMsg, 1=startGame, 2=showRules, 3=rules,<br> 
	 * 4=closeGame, 5=confirmInputMsg, 6=yes, 7=no
	 * @param i
	 * @return
	 */
	public static String getString(int i)
	{
		return allMsgs[i];
	}
	
}

package stringbanks;

public class Stringbanks_Property {

	private static String mainPropertyMenuMsg = "%s: Vælg mellem at bygge huse/hoteller, bytte grunde, pantsætte grunde, eller sælge huse og hoteller";
	private static String whereToBuyHouses = "Vælg hvor du vil bygge huse (Hold musen over feltet, for at se prisen)";
	private static String whereToUpgradeHotel = "Vælg hvor du vil bygge hotel (Prisen er den samme som hus-prisen + 4 huse)";
	private static String chooseWhatToTradeWith = "Vælg en af %s's grunde";
	private static String chooseWhoToTradeWith = "Hvem vil du bytte med?"; 
	private static String goBack = "Tilbage";
	private static String pass = "Videre";
	private static String confirmTradeMsg = "%s vil du gerne bytte %s med %s";
	private static String confirmTradeYes = "Ja";
	private static String confirmTradeNo = "Nej";
	private static String chooseYourLot = "Vælg en af dine grunde du vil bytte med";
	private static String chooseWhatToSell = "%s: Vælg en grund du vil pantsætte. nuværende balance: %d";
	private static String choosePawnOptionsForField = "%s: ";
	
	private static String dePawnOption ="Ophæv pantsætning";

	private static String pawnOption = "Pantsæt";
	private static String sellHotelOption = "Sælg hotel";
	private static String sellHouseOption = "Sælg et hus";
	private static String sellOrPawnOption = "Salg og pantsætning";
	private static String buyHouseOption = "Køb huse";
	private static String buyHotelOption = "Køb hotel";
	private static String tradeOption = "Byt grunde";
	private static String pawnIdentifier = "[PANTSAT]";
	private static String pawnedDescription = "Pantsat";
	
	private static String surrender = "Giv op";
	private static String confirmMsg = "Er du sikker på at du vil give op?";
	private static String confirmYes = "Ja";
	private static String confirmNo = "Nej";
	
	private static String wantsMoney = "Hvor mange penge vil De have oveni?";
	private static String payekstra = "Hvor mange penge vil De betale oveni?";
	private static String pay = "Betale penge";
	private static String receive = "Modtage penge";
	private static String justTrade = "Ingen af overstående - Handlen går lige over!";
	
	private static String[] strings = {mainPropertyMenuMsg, whereToBuyHouses, 
									  whereToUpgradeHotel,chooseWhatToTradeWith,
									  chooseWhoToTradeWith,goBack,pass, confirmTradeMsg, 
									  confirmTradeYes,confirmTradeNo,chooseYourLot,buyHouseOption,
									  buyHotelOption,tradeOption,chooseWhatToSell, choosePawnOptionsForField,
									  pawnOption, sellHotelOption,sellHouseOption, sellOrPawnOption, 
									  pawnedDescription, dePawnOption,pawnIdentifier,surrender,confirmMsg,
									  confirmYes,confirmNo,wantsMoney,payekstra, pay, receive, justTrade};
		
	/**
	 * 0 = mainPropertMenuMsg<br>
	 * 1 = whereToBuyHouses<br>
	 * 2 = whereToUpgradeHotel<br>
	 * 3 = chooseWhatToTradeWith<br>
	 * 4 = chooseWhoToTradeWith<br>
	 * 5 = goBack<br>
	 * 6 = pass<br>
	 * 7 = confirmTradeMsg<br>
	 * 8 = confirmTradeYes<br>
	 * 9 = confirmTradeNo<br>
	 * 10 = chooseYourLot<br>
	 * 11 = buyHouseOption<br>
	 * 12 = buyHotelOption<br>
	 * 13 = tradeOption <br>
	 * 14 = chooseWhatToSell<br>
	 * 15 = choosePawnOptionsForField<br>
	 * 16 = pawnOption<br>
	 * 17 = sellHotelOption<br>
	 * 18 = sellHouseOption<br>
	 * 19 = sellOrPawnOption<br>
	 * 20 = pawnedDescription<br>
	 * 21 = dePawnOption<br>
	 * 22 = pawnIdentifier<br>
	 * 23 = surrender<br>
	 * 24 = confirmMsg <br>
	 * 25 = confirmYes <br>
	 * 26 = confirmNo <br>
	 * 27 = wantsMoney <br>
	 * 28 = payekstra <br>
	 * 29 = pay <br>
	 * 30 = receive <br>
	 * 31 = justTrade <br>
	 * @param i 
	 * @return
	 */
	public static String get(int i)
	{
		return strings[i];
	}

}

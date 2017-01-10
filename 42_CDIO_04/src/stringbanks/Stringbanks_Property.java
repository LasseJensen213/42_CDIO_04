package stringbanks;

public class Stringbanks_Property {

	private static String mainPropertyMenuMsg = "Vælg mellem at bygge huse/hoteller eller bytte grunde";
	private static String whereToBuyHouses = "Vælg hvor du vil bygge huse";
	private static String whereToUpgradeHotel = "Vælg hvor du vil bygge hotel";
	private static String chooseWhatToTradeWith = "Vælg en af %s's grunde";
	private static String chooseWhoToTradeWith = "Hvem vil du bytte med?"; 
	private static String goBack = "Tilbage";
	private static String pass = "Videre";
	private static String confirmTradeMsg = "%s vil du gerne bytte %s med %s";
	private static String confirmTradeYes = "Ja";
	private static String confirmTradeNo = "Nej";
	private static String chooseYourLot = "Vælg en af dine grunde du vil bytte med";
	
	private static String buyHouseOption = "Køb huse";
	private static String buyHotelOption = "Køb hotel";
	private static String tradeOption = "Byt grunde";
	
	private static String[] strings = {mainPropertyMenuMsg, whereToBuyHouses, 
									  whereToUpgradeHotel,chooseWhatToTradeWith,
									  chooseWhoToTradeWith,goBack,pass, confirmTradeMsg, 
									  confirmTradeYes,confirmTradeNo,chooseYourLot,buyHouseOption,
									  buyHotelOption,tradeOption};
		
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
	 * @param i 
	 * @return
	 */
	public static String get(int i)
	{
		return strings[i];
	}

}

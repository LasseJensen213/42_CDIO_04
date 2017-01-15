package boundary;

import desktop_resources.GUI;
import stringbanks.Stringbanks_Property;

public class PropertyBoundary {


	public PropertyBoundary() {
		// TODO Auto-generated constructor stub
	}


	public String chooseWhereToBuyHouses(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(1), options);
	}

	public String chooseWhereToUpgradeHotel(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(2), options);
	}

	public String chooseWhatToBuy(String name, String[] options)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_Property.get(0), name), options);
	}

	public String chooseWhoToTradeWith(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(4), options);
	}

	public String sellMenu(String name, String[] options, int balance)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_Property.get(14), name, balance), options);
	}

	public String pawnMenu(String fieldName, String[] options, int balance)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_Property.get(15), fieldName, balance), options);
	}


	public String chooseYourLots(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(10), options);
	}

	public String chooseWhatToTradeWith(String[] options, String playerName)
	{
		return GUI.getUserButtonPressed(String.format(Stringbanks_Property.get(3), playerName), options);
	}

	public static void housePrice(int pris) {
		String message = "Hver hus koster %d <br> Hvert hotel koster %d + 4 huse";
		message = String.format(message, pris, pris);
		GUI.showMessage(message);
	}

	public static String tradeAmountOption(){
		String[] options = {Stringbanks_Property.get(30), Stringbanks_Property.get(29), Stringbanks_Property.get(31), Stringbanks_Property.get(5)};
//		return GUI.getUserSelection("Vil de modtage eller betale penge i handlen?", options);
		return GUI.getUserButtonPressed("Vil de modtage eller betale penge i handlen?", options);
	}

	public boolean confirmTrade(String opposingPlayer, String otherPlayersField, String yourField)
	{
		return GUI.getUserLeftButtonPressed(String.format(Stringbanks_Property.get(7), opposingPlayer,otherPlayersField,yourField), 
				Stringbanks_Property.get(8), 
				Stringbanks_Property.get(9));
	}

	public void updateHouseCount(int fieldNumber, int houseCount)
	{
		GUI.setHouses(fieldNumber+1, houseCount);
	}

	public void updateHotelPlacement(int fieldNumber, boolean hasHotel)
	{
		GUI.setHouses(fieldNumber+1, 0);
		GUI.setHotel(fieldNumber+1, hasHotel);
	}
	//Gets called when someone buys a house / upgrades to hotel
	public void updatePlayerBalance(String name, int balance)
	{
		GUI.setBalance(name, balance);
	}

	public void setOwner(String name, int fieldNumber)
	{
		GUI.setOwner(fieldNumber+1, name);
	}

	public void pawnField(int fieldNumber)
	{
		GUI.setSubText(fieldNumber+1, Stringbanks_Property.get(20));
	}

	public boolean confirmSurrender()
	{
		return GUI.getUserLeftButtonPressed(Stringbanks_Property.get(24), 
				Stringbanks_Property.get(25), Stringbanks_Property.get(26));
	}
}

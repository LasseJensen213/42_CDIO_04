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
	
	public String chooseWhatToBuy(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(0), options);
	}
	
	public String chooseWhoToTradeWith(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(4), options);
	}
	
	
	public String chooseYourLots(String[] options)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(10), options);
	}
	
	public String chooseWhatToTradeWith(String[] options, String playerName)
	{
		return GUI.getUserButtonPressed(Stringbanks_Property.get(3), options);
	}
	
	public boolean confirmTrade(String opposingPlayer, String otherPlayersField, String yourField)
	{
		return GUI.getUserLeftButtonPressed(Stringbanks_Property.get(7), 
											Stringbanks_Property.get(8), 
											Stringbanks_Property.get(9));
	}
	
	public void updateHouseCount(int fieldNumber, int houseCount)
	{
		GUI.setHouses(fieldNumber, houseCount);
	}
	
	public void updateHotelPlacement(int fieldNumber, boolean hasHotel)
	{
		GUI.setHouses(fieldNumber, 0);
		GUI.setHotel(fieldNumber, hasHotel);
	}
	//Gets called when someone buys a house / upgrades to hotel
	public void updatePlayerBalance(String name, int balance)
	{
		GUI.setBalance(name, balance);
	}
	
	public void setOwner(String name, int fieldNumber)
	{
		GUI.setOwner(fieldNumber, name);
	}
}
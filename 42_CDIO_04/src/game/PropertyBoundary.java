package game;

import desktop_resources.GUI;

public class PropertyBoundary {

	
	public PropertyBoundary() {
		// TODO Auto-generated constructor stub
	}

	
	public String chooseWhereToBuyHouses(String[] options)
	{
		return GUI.getUserButtonPressed("Vælg hvilken grund du vil købe huse på", options);
	}
	
	public String chooseWhereToUpgradeHotel(String[] options)
	{
		return GUI.getUserButtonPressed("Vælg hvilken grund du vil købe hoteller på", options);
	}
	
	public String chooseWhatToBuy(String[] options)
	{
		return GUI.getUserButtonPressed("Købs menu:", options);
	}
	
	public String chooseWhoToTradeWith(String[] options)
	{
		return "";
	}
	
	public String chooseWhatToTradeWith(String[] options)
	{
		return "";
	}
	
	public String confirmTrade(String currentPlayer, String opposingPlayer)
	{
		return "";
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
}

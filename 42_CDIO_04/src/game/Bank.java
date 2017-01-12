package game;

import desktop_resources.GUI;

public class Bank {
	private static Bank INSTANCE;
	
	private final int MAX_HOUSES = 32;
	private final int MAX_HOTELS = 12;
	private int housesUsed;
	private int hotelsUsed;
	
	public Bank()
	{
		housesUsed=0;
		hotelsUsed=0;
	}

	public int getMAX_HOUSES() {
		return MAX_HOUSES;
	}

	public int getMAX_HOTELS() {
		return MAX_HOTELS;
	}

	public int getHousesUsed() {
		return housesUsed;
	}

	public int getHotelsUsed() {
		return hotelsUsed;
	}

	public void setHousesUsed(int housesUsed) {
		this.housesUsed = housesUsed;
	}

	public void setHotelsUsed(int hotelsUsed) {
		this.hotelsUsed = hotelsUsed;
	}
	
	public void useHouses(int amount)
	{
		housesUsed+=amount;
	}
	
	public void housesFreed(int amount)
	{
		housesUsed-=amount;
	}

	public void useHotels(int amount)
	{
		hotelsUsed += amount;
	}
	
	public void hotelsFreed(int amount)
	{
		hotelsUsed -=amount;
	}
	
	public static Bank getBank()
	{
		if(INSTANCE==null)
			INSTANCE = new Bank();
		return INSTANCE;
	}
	public void noBuildings(int i) {
		GUI.setHotel(i+1, false);
		GUI.setHouses(i+1, 0);
	}
}

package field;

import java.awt.Image;

public class Territory extends Ownable {
	private int house;
	private boolean hotel;
	private String id;
	
	public Territory(String desc, String subtext, String title, int pos, int price, int rent, int priceIncr, String id) {
		super(desc, subtext, title, pos, price, rent);
		this.id = id;
		hotel = false;
		house = 0;
	}

	public void addHouse(int amount) {
		house +=amount;
	}
	
	
	public void removeHouse(int amount) {
		house -= amount;
	}
	
	public boolean hasHotel()
	{
		return hotel;
	}
	
	public void setHotel(boolean hasHotel)
	{
		this.hotel = hasHotel;
	}
	
	
	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}

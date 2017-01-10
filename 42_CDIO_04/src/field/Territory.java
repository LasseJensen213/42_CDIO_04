package field;

import java.awt.Image;

public class Territory extends Ownable {
	private int house;
	private int hotel;
	private String id;
	
	public Territory(String desc, String subtext, String title, int pos, int price, int rent, int priceIncr, String id) {
		super(desc, subtext, title, pos, price, rent);
		this.id = id;
		house = 0;
		hotel = 0;
	}
	
	
	//Adds and removes houses
	
	public void addHouse(int amount) {
		house +=amount;
	}
	
	public void removeHouse(int amount) {
		house -= amount;
	}
	
	
	//Getters and Setters
	
	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

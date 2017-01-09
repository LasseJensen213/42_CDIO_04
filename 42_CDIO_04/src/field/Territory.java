package field;

import java.awt.Image;

public class Territory extends Ownable {
	private int house;
	private int hotel;
	private String id;
	
	public Territory(String desc, String subtext, String title, Image i, int pos, int price, int rent, int priceIncr, String id) {
		super(desc, subtext, title, i, pos, price, rent);
		this.id = id;
		house = 0;
		hotel = 0;
	}

	public void addHouse(int amount) {
		house +=amount;
	}
	
	
	public void removeHouse(int amount) {
		house -= amount;
	}
	
	public void addHotel(int amount) {
		if(house==5) {
			house = 0;
			hotel = 1;
		}
	}
	
	public void removeHotel(int amount) {
		if(hotel==1) {
			hotel = 0;
			house = 4;
		}
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

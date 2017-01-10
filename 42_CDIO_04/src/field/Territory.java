package field;

import java.awt.Color;
import java.util.Arrays;

public class Territory extends Ownable {
	private int house;
	private String id;
	private int seriesMax;
	private Color color;
	private int rent[];
	private int housePrice;

	
	
	
	
	
	public Territory(String desc, String subtext, String title, int pos, int price, int[] rent, int series, Color color, int housePrice) {
		super(desc, subtext, title, pos, price);
		house = 0;

		this.seriesMax = series;
		this.color = color;
		this.rent = rent;
		this.housePrice = housePrice;

	}
	
	
	//Adds and removes houses
	
	public void addHouse(int amount) {
		house +=amount;
	}
	

	
	public int getSeriesMax() {
		return seriesMax;
	}

	public void setSeriesMax(int seriesMax) {
		this.seriesMax = seriesMax;
	}

	public int getRent(int i) {
		return rent[i];
	}

	public void setRent(int[] rent) {
		this.rent = rent;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
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


	public String getId() {
		return id;


	public int getSeries() {
		return seriesMax;
	}

	public void setSeries(int series) {
		this.seriesMax = series;

	}

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Territory [house=" + house + ", seriesMax=" + seriesMax + ", color=" + color + ", rent="
				+ Arrays.toString(rent) + ", housePrice=" + housePrice + ", getPrice()=" + getPrice() + ", getOwner()="
				+ getOwner() + ", isPawned()=" + isPawned() + ", toString()=" + super.toString() + ", getDesc()="
				+ getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()="
				+ getFieldPosition() + ", getClass()=" + getClass() + "]";
	}

}

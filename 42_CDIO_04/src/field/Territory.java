package field;

import java.awt.Color;

public class Territory extends Ownable {
	private int house;
	private int seriesMax;
	private Color color;
	private static int rent[];
	
	
	
	
	
	public Territory(String desc, String subtext, String title, int pos, int price, int[] rent, int series, Color color) {
		super(desc, subtext, title, pos, price);
		house = 0;
		this.seriesMax = series;
		this.color = color;
		this.rent = rent;
	}

	public void addHouse(int amount) {
		house +=amount;
	}
	
	
	public void removeHouse(int amount) {
		house -= amount;
	}
	

	

	
	
	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}



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


}

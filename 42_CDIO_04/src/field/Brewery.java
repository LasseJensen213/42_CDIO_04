package field;

import java.awt.Color;

public class Brewery extends Ownable{
	private int rent;
	String image;
	Color color;
	
	public Brewery(String desc, String subtext, String title, int pos, int price, int rent, String image, Color color) {
		super(desc, subtext, title,  pos, price);
			this.rent = rent;
			this.image = image;
			this.color = color;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getImage() {
		return image;
	}

	
	
	
	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Brewery [rent=" + rent + ", getPrice()=" + getPrice() + ", getOwner()=" + getOwner() + ", isPawned()="
				+ isPawned() + ", toString()=" + super.toString() + ", getDesc()=" + getDesc() + ", getSubtext()="
				+ getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()=" + getFieldPosition()
				+ ", getClass()=" + getClass();
	}

	
	
	
}
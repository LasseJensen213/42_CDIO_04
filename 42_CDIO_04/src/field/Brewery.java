package field;

import java.awt.Image;

import dice.DiceCup;

public class Brewery extends Ownable{
	
	private int amountOwned;
 
	
	//String desc, String subtext, String title, Image i, int pos, int price, int rent, int priceIncr
	
	public Brewery(String desc, String subtext, String title, Image i, int pos, int price, int rent) {
		super(desc, subtext, title, i, pos, price, rent);	
	}
	
	
	//calcute rent in regards to facevalue of dice and amount of breweries owned
	
	public void calculateRent() {
		if(amountOwned == 1) {
			setRent(DiceCup.getDiceTotal());
		}
		if(amountOwned == 2) {
			setRent(2 * DiceCup.getDiceTotal());
		}
	}
	

}

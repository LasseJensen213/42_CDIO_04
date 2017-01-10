package field;

import java.awt.Image;

public class Fleet extends Ownable{
	private int amountOwned;


	public Fleet(String desc, String subtext, String title, Image i, int pos, int price, int rent) {
		super(desc, subtext, title, i, pos, price, rent);
	}
	
	
	//Calculates rent for 1 to 4 "amountOwned" of fleets
	
	public void calculateRent() {
		if(amountOwned == 1){
			setRent(500);
		}
		if(amountOwned == 2){
			setRent(1000);
		}
		if(amountOwned == 3){
			setRent(2000);
		}
		if(amountOwned == 4){
			setRent(4000);
		}
	}
	
	
	//Getters and setters for "amountOwned" of fleets owned

	public int getAmountOwned() {
		return amountOwned;
	}

	public void setAmountOwned(int amountOwned) {
		this.amountOwned = amountOwned;
	}
	
}

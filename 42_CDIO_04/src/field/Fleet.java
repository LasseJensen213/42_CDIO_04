package field;

import java.util.Arrays;

public class Fleet extends Ownable{

	private int amountOwned;
  private int rent[];


	public Fleet(String desc, String subtext, String title, Image i, int pos, int price, int rent) {
		super(desc, subtext, title, i, pos, price, rent);
    this.rent = rent;
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
  
  //Getters and setters for "rent"
	}

	public int[] getRent() {
		return rent;
	}

	public void setRent(int[] rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Fleet [rent=" + Arrays.toString(rent) + ", getPrice()=" + getPrice() + ", getOwner()=" + getOwner()
				+ ", isPawned()=" + isPawned() + ", toString()=" + super.toString() + ", getDesc()=" + getDesc()
				+ ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()="
				+ getFieldPosition() + ", getClass()=" + getClass();
	}
	

}

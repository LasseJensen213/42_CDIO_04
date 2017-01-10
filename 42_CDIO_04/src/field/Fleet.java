package field;

import java.util.Arrays;

public class Fleet extends Ownable{

    private int rent[];


	public Fleet(String desc, String subtext, String title, int pos, int price, int[] rent) {
		super(desc, subtext, title, pos, price);
    this.rent = rent;
	}
	
	
	//Calculates rent for 1 to 4 "amountOwned" of fleets
	
	public int calculateRent(int amountOwned) {
		int rent = 0;
		if(amountOwned == 1){
			rent = 500;
		}
		else if(amountOwned == 2){
			rent =  1000;
		}
		else if(amountOwned == 3){
			rent = 2000;
		}
		else if(amountOwned == 4){
			rent = 4000;
		}
		return rent;
		
	}
	
	

  
  //Getters and setters for "rent"


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

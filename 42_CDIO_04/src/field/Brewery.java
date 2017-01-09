package field;

public class Brewery extends Ownable{
	private int rent;
	
	public Brewery(String desc, String subtext, String title, int pos, int price, int rent) {
		super(desc, subtext, title,  pos, price);
			this.rent = rent;
	}

	
	
}

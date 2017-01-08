package field;

public class Fleet extends Ownable{
	private int price;
	private int rent;

	public Fleet(String desc, String subtext, String title, int pos, int price, int rent) {
		super(desc,subtext,title,pos);
		this.price = price;
		this.rent = rent;

	}
}

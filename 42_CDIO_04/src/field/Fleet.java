package field;

public class Fleet extends Ownable{
	private int rent;

	public Fleet(String desc, String subtext, String title, int pos, int price, int rent) {
		super(desc,subtext,title,pos,price);
		this.rent = rent;


	}
}

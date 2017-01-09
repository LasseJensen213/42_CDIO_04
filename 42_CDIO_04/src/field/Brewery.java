package field;

public class Brewery extends Ownable{
	private int rent;
	
	public Brewery(String desc, String subtext, String title, int pos, int price, int rent) {
		super(desc, subtext, title,  pos, price);
			this.rent = rent;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Brewery [rent=" + rent + ", getPrice()=" + getPrice() + ", getOwner()=" + getOwner() + ", isPawned()="
				+ isPawned() + ", toString()=" + super.toString() + ", getDesc()=" + getDesc() + ", getSubtext()="
				+ getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()=" + getFieldPosition()
				+ ", getClass()=" + getClass();
	}

	
	
	
}

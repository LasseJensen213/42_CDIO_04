package field;

public class ParkingLot extends Field {

	private static int taxMoney;
	String image;
	
	
	
	public ParkingLot(String desc, String subtext, String title, int pos, String image) {
		super(desc,subtext,title,pos);
		taxMoney = 0;
		this.image = image;
	}
	public static int getTaxMoney() {
		return taxMoney;
	}
	public static void setTaxMoney(int tax) {
		taxMoney = tax;
	}
	
	public String getImage() {
		return image;
	}
	@Override
	public String toString() {
		return "ParkingLot [getDesc()=" + getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle()
				+ ", getFieldPosition()=" + getFieldPosition() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}
	
	
	
	
	
	
	
}

package field;

public class ParkingLot extends Field {

	private static int taxMoney;
	
	
	
	
	public ParkingLot(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
		taxMoney = 0;
	}
	public static int getTaxMoney() {
		return taxMoney;
	}
	public static void setTaxMoney(int tax) {
		taxMoney = tax;
	}
	
	
	
	
	
	
	
}

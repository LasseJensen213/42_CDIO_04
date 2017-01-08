package field;

public class ParkingLot extends Field {

	private static int taxMoney = 0;
	
	public ParkingLot(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
	}

	public static int getTaxMoney() {
		return taxMoney;
	}

	public static void setTaxMoney(int taxMoney) {
		ParkingLot.taxMoney = taxMoney;
	}


	
}

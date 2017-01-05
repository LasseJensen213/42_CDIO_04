package board;

import java.awt.Image;

import javax.swing.ImageIcon;

import field.Brewery;
import field.Chance;
import field.Fleet;
import field.GoToJail;
import field.Jail;
import field.ParkingLot;
import field.Start;
import field.Tax;
import field.Territory;
public class FieldGenerator {

	//Image Array
	//First 4 images is for the fleet, the [4] is for the parking lot. the [5] is for the jail, [6] is chance,
	private Image im[] = new Image[10];



	//Territory related information.
	private final static int territoryPrice[] = {1000,1500,2000,3000,4000,4300,4750,5000,5500,6000,8000};
	private final static int territoryRent[] = {100,300,500,700,1000,1300,1600,2000,2600,3200,4000};
	private final static int territoryPlace[] = {2,5,6,8,10,11,13,14,16,17,19};

	//Labor Camp related information.
	private final static int laborCampPrice[] = {2500,2500};
	private final static int laborCampBaseRent[] = {100,100};
	private final static int laborCampPlace[] = {7,18};

	//Fleet related information.
	private final static int fleetPrice[] = {4000,4000,4000,4000};
	private final static int fleetPlace[] = {4,9,15,20};

	//Tax related information.
	private final static int tax_TaxAmount[] = {2000,4000};
	private final static int tax_TaxRate[] = {0,10};
	private final static int taxPlace[] = {3,21};

	private static Territory territoryFields[] = new Territory[22];
	private static Brewery breweryFields[] = new Brewery[2];
	private static Fleet fleetFields[] = new Fleet[4];
	private static ParkingLot parkingLotField;
	private static Jail jailField;
	private static Start startField;
	private static Tax taxFields[] = new Tax[2];
	private static Chance chanceFields[] = new Chance[6];
	private static GoToJail goToJailField;

	public void initTerritoryFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		int rent = 0;
		int priceIncr = 0;
		String id = "";
		for(int i = 0;i<territoryFields.length;i++) {

			territoryFields[i] = new Territory(desc, subtext, title, null, pos, price, rent, priceIncr, id);
		}
	}

	public void initBreweryFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		int rent = 0;
		Image image = null;

		for(int i = 0;i<breweryFields.length;i++) {
			breweryFields[i] = new Brewery(desc,subtext,title,image,pos,price,rent);
		}
	}


	private void loadImageArray() {
		//ImageIconArray
		ImageIcon ii[] = new ImageIcon[im.length];
		
		for(int i = 0;i<im.length;i++) {
			switch(i) {
			case 0 :  {
				ii[6] = new ImageIcon("src/images/questionmark.jpg");
				break;
			} 
			case 1 : {
				
			}
			
			}
			}
		}
//ImageIcon ii = new ImageIcon("src/images/questionmark.jpg");
//	im[0] = ii.getImage(); 
	

	public void initFleetFields() {
		loadImageArray();
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;

		for(int i = 0;i<fleetFields.length;i++) {
			fleetFields[i] = new Fleet(desc,subtext,title,im[i],pos);
		}
	}

	public void initParkingLot() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
	
	    ParkingLot parkingLotField = new ParkingLot(desc,subtext,title,im[4],pos);
		
	}

	
	public void initJail() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
	
	    Jail jailField = new Jail(desc,subtext,title,im[5],pos);
	}
	
	public void initStart() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
	
	    Start startField = new Start(desc,subtext,title,im[5],pos);
	}
	
	public void initTax() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int tax = 0;
		int percentage = 0;
	
	    Tax TaxField = new Tax(desc,subtext,title,null,pos, tax, percentage);
	}
	
	public void initChance() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
	
	    Chance ChanceField = new Chance(desc,subtext,title,im[6],pos);
	}
	
	public void initGoToJail() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
	
	    GoToJail ChanceField = new GoToJail(desc,subtext,title,im[6],pos);
	}
}

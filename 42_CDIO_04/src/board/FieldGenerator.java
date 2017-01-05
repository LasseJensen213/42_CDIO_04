package board;

import java.awt.Color;
import java.awt.Image;

import field.Brewery;
import field.Chance;
import field.Fleet;
import field.GoToJail;
import field.Jail;
import field.ParkingLot;
import field.Start;
import field.Tax;
import field.Territory;
import stringbanks.Stringbanks_Fields;
public class FieldGenerator {


	static Stringbanks_Fields strBank = new Stringbanks_Fields();

	//GUI Colours
	private static Color bgColors[] = new Color[40];
	private static Color fgColors[] = new Color[40];
	
	//Fields;
	private static Territory territoryFields[];
	private static Brewery breweryFields[];
	private static Fleet fleetFields[];
	private static ParkingLot parkingLotField;
	private static Jail jailField;
	private static Start startField;
	private static Tax[] taxFields;
	private static Chance[] chanceFields;
	private static GoToJail goToJailField;

	public FieldGenerator() {
		territoryFields = new Territory[22];
		breweryFields = new Brewery[2];
		fleetFields = new Fleet[4];
		parkingLotField = new ParkingLot("","","",0);
		jailField = new Jail("","","",0);
		startField = new Start("","","",0);
		taxFields = new Tax[2];
		chanceFields = new Chance[6];
		goToJailField = new GoToJail("","","",0);
		
		FieldGenerator.initBreweryFields();
		FieldGenerator.initChance();
		FieldGenerator.initFleetFields();
		FieldGenerator.initGoToJail();
		FieldGenerator.initJail();
		FieldGenerator.initParkingLot();
		FieldGenerator.initStart();
		FieldGenerator.initTax();
		FieldGenerator.initTerritoryFields();
		FieldGenerator.initBgColor();
		FieldGenerator.initFgColor();
		
		
	}
	//Territory related information.
	private final static int territoryPrice[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
	private final static int territoryRent[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
	private final static int territoryPlace[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
	private final static int territoryIncr[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};

	//Tax related information.
	private final static int breweryPrice[] = {3000,3000};
	private final static int breweryBaseRent[] = {100,100};
	private final static int breweryPlace[] = {12,28};

	//Fleet related information.
	private final static int fleetPrice[] = {4000,4000,4000,4000};
	private final static int fleetPlace[] = {5,15,25,35};

	//Tax related information.
	private final static int taxAmount[] = {2000,4000};
	private final static int taxRate[] = {0,10};
	private final static int taxPlace[] = {4,38};

	//Chance related information
	private final static int chancePlace[] = {2,7,17,22,33,36};








	public static void initBgColor() {
		for(int i = 0;i<bgColors.length;i++) {
			bgColors[i] = Color.YELLOW;
		}
	}

	public static void initFgColor() {
		for(int i = 0;i<fgColors.length;i++) {
			fgColors[i] = Color.GREEN;
		}
	}
	public static void initTerritoryFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		int rent = 0;
		int priceIncr = 0;
		String id = "";
		for(int i = 0;i<territoryFields.length;i++) {
			desc = strBank.getTerritoryDescArray(i);
			subtext = strBank.getTerritorySubtextArray(i);
			title = strBank.getTerritoryNameArray(i);
			pos = territoryPlace[i];
			price = territoryPrice[i];
			rent = territoryRent[i];
			priceIncr = territoryIncr[i];

			territoryFields[i] = new Territory(desc, subtext, title, pos, price, rent, priceIncr, id);
		}
	}

	public static void initBreweryFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		int rent = 0;

		for(int i = 0;i<breweryFields.length;i++) {
			desc = strBank.getBreweryDescriptionArray(i);
			subtext = strBank.getBrewerySubtextArray(i);
			title = strBank.getBreweryNameArray(i);
			pos = breweryPlace[i];
			price = breweryPrice[i];
			rent = breweryBaseRent[i];

			breweryFields[i] = new Brewery(desc,subtext,title,pos,price,rent);
		}
	}





	public static void initFleetFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;

		for(int i = 0;i<fleetFields.length;i++) {
			pos = fleetPlace[i];
			desc = strBank.getFleetDescriptionArray(i);
			subtext = strBank.getFleetSubtextArray(i);
			title = strBank.getFleetNameArray(i);
			fleetFields[i] = new Fleet(desc,subtext,title,pos);
		}
	}

	public static void initParkingLot() {

		String desc = strBank.getField34Description();
		String subtext = strBank.getField34subtext();
		String title = strBank.getField34Name();
		int pos = 20;
		parkingLotField = new ParkingLot(desc,subtext,title,pos);

	}


	public static void initJail() {
		String desc = strBank.getField30Description();
		String subtext = strBank.getField30subtext();
		String title = strBank.getField30Name();
		int pos = 10;

		jailField = new Jail(desc,subtext,title,pos);
	}

	public static void initStart() {
		String desc = strBank.getField1Description();
		String subtext = strBank.getField1subtext();
		String title = strBank.getField1Name();
		int pos = 0;
		System.out.println(desc + " : " + subtext + " : " + title);

		startField = new Start(desc,subtext,title,pos);
	}

	public static void initTax() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int tax = 0;
		int percentage = 0;

		for(int i = 0;i<taxFields.length;i++) {
			desc = strBank.getTaxDescriptionArray(i);
			subtext = strBank.getTaxSubtextArray(i);
			title = strBank.getTaxNameArray(i);
			pos = taxPlace[i];
			tax = taxAmount[i];
			percentage = taxRate[i];

			taxFields[i] = new Tax(desc,subtext,title,pos, tax, percentage);
		}

	}

	public static void initChance() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;

		for(int i = 0;i<chanceFields.length;i++) {
			desc = strBank.getChanceDescription();
			subtext = strBank.getChancesubtext();
			title = strBank.getChanceName();
			pos = chancePlace[i];
			chanceFields[i] = new Chance(desc,subtext,title,pos);
		}
	}

	public static void initGoToJail() {
		String desc = strBank.getField31Description();
		String subtext = strBank.getField31subtext();
		String title = strBank.getField31Name();;
		int pos = 30;

		goToJailField = new GoToJail(desc,subtext,title,pos);
	}

	public static Color getBgColors(int i) {
		return bgColors[i];
	}

	public static Color getFgColors(int i) {
		return fgColors[i];
	}


	public static Territory getTerritoryFields(int i) {
		return territoryFields[i];
	}

	public static Brewery getBreweryFields(int i) {
		return breweryFields[i];
	}

	public static Fleet getFleetFields(int i) {
		return fleetFields[i];
	}

	public static ParkingLot getParkingLotField() {
		return parkingLotField;
	}

	public static Jail getJailField() {
		return jailField;
	}

	public static Start getStartField() {
		return startField;
	}

	public static Tax getTaxFields(int i) {
		return taxFields[i];
	}

	public static Chance getChanceFields(int i) {
		return chanceFields[i];
	}

	public static GoToJail getGoToJailField() {
		return goToJailField;
	}


}

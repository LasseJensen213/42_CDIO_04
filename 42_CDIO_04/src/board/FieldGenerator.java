package board;

import java.awt.Color;
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
		}
	
	
	//Territory related information.
	//Rent:
	private final static int hvidovrevejRent[] = {50,250,750,2250,4000,6000};
	private final static int rødovrevejRent[] = {50,250,750,2250,4000,6000};
	private final static int roskildevejRent[] = {100,600,1800,5400,8000,11000};
	private final static int valbyLanggadeRent[] = {100,600,1800,5400,8000,11000};
	private final static int allégadeRent[] = {150,800,2000,6000,9000,12000};
	private final static int frederiksbergAlléRent[] = {200,1000,3000,9000,12500,15000};
	private final static int bülowsvejRent[] = {200,1000,3000,9000,12500,15000};
	private final static int glKongevejRent[] = {250,1250,3750,10000,14000,18000};
	private final static int bernstoffsvejRent[] = {300,1400,4000,11000,15000,19000};
	private final static int hellerupvejRent[] = {300,1400,4000,11000,15000,19000};
	private final static int strandvejenRent[] = {350,1600,4400,12000,16000,20000};
	private final static int trianglenRent[] = {350,1800,5000,14000,17500,21000};
	private final static int østerbrogadeRent[] = {350,1800,5000,14000,17500,21000};
	private final static int grønningenRent[] = {400,2000,6000,15000,18500,22000};
	private final static int kgsNytorvRent[] = {450,2200,6600,16000,19500,23000};
	private final static int bredgadeRent[] = {450,2200,6600,16000,19500,23000};
	private final static int østergadeRent[] = {500,2400,7200,17000,20500,24000};
	private final static int vimmelskaftetRent[] = {550,2600,7800,18000,22000,25000};
	private final static int amagertorvRent[] = {550,2600,7800,18000,22000,25000};
	private final static int nygadeRent[] = {600,3000,9000,20000,43000,28000};
	private final static int frederiksberggadeRent[] = {700,3500,10000,22000,26000,30000};
	private final static int rådhuspladsenRent[] = {1000,4000,12000,28000,34000,40000};
	
	//Prices on houses
	private final static int territoryHousePrice[] = {1000,1000,2000,2000,3000,3000,4000,4000};
	
	private final static int territoryPrice[] = {1200,1200,2000,2000,2400,2800,2800,3200,3600,3600,4000,4400,4400,4800,5200,5200,5600,6000,6000,6400,7000,8000};
	private final static int territoryRent[][] = {hvidovrevejRent,rødovrevejRent,roskildevejRent,valbyLanggadeRent,allégadeRent,frederiksbergAlléRent
			,bülowsvejRent,glKongevejRent,bernstoffsvejRent,hellerupvejRent,strandvejenRent,trianglenRent,østerbrogadeRent
			,grønningenRent,kgsNytorvRent,bredgadeRent,østergadeRent,vimmelskaftetRent,amagertorvRent,nygadeRent,frederiksberggadeRent,rådhuspladsenRent};
	private final static int territoryPlace[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
	private final static int territorySeriesMax[] = {2,3,3,3,3,3,3,2};
	private final static Color orangeColor = new Color(237, 123, 16);
	private final static Color territoryColor[] = {Color.BLUE,orangeColor,Color.GREEN, Color.GRAY,Color.RED,Color.WHITE,Color.YELLOW,Color.MAGENTA};
	

	private final static int breweryPrice[] = {3000,3000};
	private final static int breweryBaseRent[] = {100,100};
	private final static int breweryPlace[] = {12,28};
	private final static String breweryPic[] = {"resources/pics/TuborgSquash.png","resources/pics/CocaCola.jpg"};
	private final static Color breweryColor = new Color(24, 160, 6);
	
	//Fleet related information.
	private final static int fleetPrice[] = {4000,4000,4000,4000};
	private final static int fleetPlace[] = {5,15,25,35};
	private final static int fleetRent[] = {500,1000,2000,4000};

	//Tax related information.
	private final static int taxAmount[] = {4000,2000};
	private final static int taxRate[] = {10,0};
	private final static int taxPlace[] = {4,38};

	//Chance related information
	private final static int chancePlace[] = {2,7,17,22,33,36};

	private final static String parkingLotImage = "resources/pics/Redcar.gif";


	public static void initFields() {
		territoryFields = new Territory[22];
		breweryFields = new Brewery[2];
		fleetFields = new Fleet[4];
		parkingLotField = new ParkingLot("","","",0,"");
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



	public static void initBgColor() {
		for(int i = 0;i<bgColors.length;i++) {
			bgColors[i] = Color.YELLOW;
		}
	}

	public static void initFgColor() {
		for(int i = 0;i<fgColors.length;i++) {
			fgColors[i] = Color.BLACK;
		}
	}
	public static void initTerritoryFields() {		
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		
		Color color = Color.BLACK;
		int seriesMax = 0;
		int seriesMaxReached = 0;
		int counter = 0;
		int housePrice = 0;
		for(int i = 0;i<territoryFields.length;i++) {
			int rent[] = new int[6];

			desc = strBank.getTerritoryDescArray(i);
			subtext = strBank.getTerritorySubtextArray(i);
			title = strBank.getTerritoryNameArray(i);
			pos = territoryPlace[i];
			for(int r = 0;r<6;r++) {
				rent[r] = territoryRent[i][r];
			}
			
			price = territoryPrice[i];
			
			
			if((seriesMaxReached < 8) && counter == territorySeriesMax[seriesMaxReached]) {
				seriesMaxReached++;
				counter = 0;
			}
			if(!(seriesMaxReached>7)) {
				seriesMax = territorySeriesMax[seriesMaxReached];
			}
			color = territoryColor[seriesMaxReached];
			housePrice = territoryHousePrice[seriesMaxReached];
			territoryFields[i] = new Territory(desc, subtext, title, pos, price, rent, seriesMax, color, housePrice);
			
			
			counter++;
		}
	}

	public static void initBreweryFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		Color color;
		int pos = 0;
		int price = 0;
		int rent = 0;
		String image = "";

		for(int i = 0;i<breweryFields.length;i++) {
			desc = strBank.getBreweryDescriptionArray(i);
			subtext = strBank.getBrewerySubtextArray(i);
			title = strBank.getBreweryNameArray(i);
			pos = breweryPlace[i];
			price = breweryPrice[i];
			rent = breweryBaseRent[i];
			image = breweryPic[i];
			color = breweryColor;
			

			breweryFields[i] = new Brewery(desc,subtext,title,pos,price,rent,image,color);
		}
	}





	public static void initFleetFields() {
		String desc = "";
		String subtext = "";
		String title = "";
		int pos = 0;
		int price = 0;
		int rent[] = new int[4];

		for(int i = 0;i<fleetFields.length;i++) {
			pos = fleetPlace[i];
			desc = strBank.getFleetDescriptionArray(i);
			subtext = strBank.getFleetSubtextArray(i);
			title = strBank.getFleetNameArray(i);
			price = fleetPrice[i];
			
			for(int r = 0;r<rent.length;r++) {
				rent[r] = fleetRent[r];
			}
			
			fleetFields[i] = new Fleet(desc,subtext,title,pos,price,rent);
		}
	}

	public static void initParkingLot() {

		String desc = strBank.getField34Description();
		String subtext = strBank.getField34subtext();
		String title = strBank.getField34Name();
		String image = parkingLotImage;
		int pos = 20;
		parkingLotField = new ParkingLot(desc,subtext,title,pos,image);

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

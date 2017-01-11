package stringbanks;

public class Stringbanks_Fields {
	
	
	/**
	 * Chance Card information
	 */
	private String ChanceName = "Prøv Lykken";
	private String ChanceDescription = "Træk et chancekort på dette felt";
	private String Chancesubtext = " ";
	
	//Start information
	private String field1Name = "Start";
	private String field1Description = "";
	private String field1subtext = "";

	/**
	 * <
	 */
	//Territory information
	private String field2Name = "Rødovrevej";
	private String field2Description = "";
	private String field2subtext = "";
	
	private String field3Name = "Hvidovrevej"; 
	private String field3Description = "";
	private String field3subtext = "";

	private String field4Name = "Roskildevej"; 
	private String field4Description = "";
	private String field4subtext = "";
	
	private String field5Name = "Valby Langgade";
	private String field5Description = "";
	private String field5subtext = "";
	
	private String field6Name = "Allégade";
	private String field6Description = "";
	private String field6subtext = "";
	
	private String field7Name = "Frederiksberg Allé";
	private String field7Description = "";
	private String field7subtext = "";
	
	private String field8Name = "Bülowsvej";
	private String field8Description = "";
	private String field8subtext = "";
	
	private String field9Name = "Gl Kongevej";
	private String field9Description = "";
	private String field9subtext = "";
	
	private String field10Name = "Bernstorffsvej";
	private String field10Description = "";
	private String field10subtext = "";
	
	private String field11Name = "Hellerupvej";
	private String field11Description = "";
	private String field11subtext = "";

	private String field12Name = "Strandvejen";
	private String field12Description = "";
	private String field12subtext = "";
	
	private String field13Name = "Trianglen";
	private String field13Description = "";
	private String field13subtext = "";
	
	private String field14Name = "Østerbrogade";
	private String field14Description = "";
	private String field14subtext = "";
	
	private String field15Name = "Grønningen";
	private String field15Description = "";
	private String field15subtext = "";
	
	private String field16Name = "Bredgade";
	private String field16Description = "";
	private String field16subtext = "";
	
	private String field17Name = "Kgs Nytorv";
	private String field17Description = "";
	private String field17subtext = "";
	
	private String field18Name = "Østergade";
	private String field18Description = "";
	private String field18subtext = "";
	
	private String field19Name = "Amargertorv";
	private String field19Description = "";
	private String field19subtext = "";

	private String field20Name = "Vimmelskaftet";
	private String field20Description = "";
	private String field20subtext = "";
	
	private String field21Name = "Nygade";
	private String field21Description = "";
	private String field21subtext = "";
	
	private String field22Name = "Frederiksberggade";
	private String field22Description = "";
	private String field22subtext = "";
	
	private String field23Name = "Rådhuspladsen";
	private String field23Description = "";
	private String field23subtext = "";
	
	
	
	//Fleet information
	private String field24Name = "Helsingør- <br> Helsingborg";
	private String field24Description = "";
	private String field24subtext = "";
	
	private String field25Name = "Mols-Linien";
	private String field25Description = "";
	private String field25subtext = "";
	
	private String field26Name = "Gedser- <br> Rostock";
	private String field26Description = "";
	private String field26subtext = "";
	
	private String field27Name = "Rødby- <br> Puttgarden";
	private String field27Description = "";
	private String field27subtext = "";

	
	//Tax information
	private String field28Name = "Indkomstskat";
	private String field28Description = "";
	private String field28subtext = "";
	
	private String field29Name = "Statsskat";
	private String field29Description = "";
	private String field29subtext = "";
	
	//Jail information	
	private String field30Name = "Fængsel";
	private String field30Description = "";
	private String field30subtext = "";
	
	//GoToJail information
	private String field31Name = "De Fængsles";
	private String field31Description = "";
	private String field31subtext = "";
	
	
	//Brewery information
	private String field32Name = "Tuborg";
	private String field32Description = "";
	private String field32subtext = "";
	
	private String field33Name = "Coca-Cola";
	private String field33Description = "";
	private String field33subtext = "";
	
	
	//Parking Lot information
	private String field34Name = "Parkering";
	private String field34Description = "";
	private String field34subtext = "Parkering";
	
	
	//Territory arrays
	String territoryNameArray[] = {field2Name, field3Name,field4Name, field5Name,field6Name, field7Name,field8Name, field9Name,field10Name, 
			field11Name,field12Name, field13Name,field14Name, field15Name,field16Name, field17Name,field18Name, field19Name,field20Name, 
			field21Name,field22Name, field23Name};
	
	String territoryDescArray[] = {field2Description, field3Description,field4Description, field5Description,field6Description, field7Description,
			field8Description, field9Description,field10Description,field11Description,field12Description, field13Description,
			field14Description,field15Description,field16Description, field17Description,field18Description, field19Description,
			field20Description,field21Description,field22Description, field23Description};
	
	String territorySubtextArray[] = {field2subtext, field3subtext,field4subtext, field5subtext,field6subtext, field7subtext,field8subtext, 
			field9subtext,field10subtext,field11subtext,field12subtext, field13subtext,field14subtext, field15subtext,field16subtext, 
			field17subtext,field18subtext, field19subtext,field20subtext, field21subtext,field22subtext, field23subtext};

	//Fleet Arrays
	String fleetNameArray[] = {field24Name, field25Name, field26Name, field27Name};
	String fleetDescriptionArray[] = {field24Description, field25Description, field26Description,field27Description};
	String fleetSubtextArray[] = {field24subtext, field25subtext, field26subtext, field27subtext};
	
	
	//Tax Arrays
	String taxNameArray[] = {field28Name, field29Name};
	String taxDescriptionArray[] = {field28Description,field29Description};
	String taxSubtextArray[] = {field28subtext,field29subtext};
	
	//Brewery Arrays
	String breweryNameArray[] = {field32Name,field33Name};
	String breweryDescriptionArray[] = {field32Description,field33Description};
	String brewerySubtextArray[] = {field32subtext,field33subtext};
	
	
	
	//start information
	public String getField1Name() {
		return field1Name;
	}

	public String getField1Description() {
		return field1Description;
	}

	public String getField1subtext() {
		return field1subtext;
	}
	
	
	
	//Chance information
	public String getChanceName() {
		return ChanceName;
	}


	public String getChanceDescription() {
		return ChanceDescription;
	}

	public String getChancesubtext() {
		return Chancesubtext;
	}

	
	//Get fleet information
	public String getFleetNameArray(int i) {
		return fleetNameArray[i];
	}

	public String getFleetDescriptionArray(int i) {
		return fleetDescriptionArray[i];
	}

	public String getFleetSubtextArray(int i) {
		return fleetSubtextArray[i];
	}

	
	//Get tax array
	public String getTaxNameArray(int i) {
		return taxNameArray[i];
	}

	public String getTaxDescriptionArray(int i) {
		return taxDescriptionArray[i];
	}

	public String getTaxSubtextArray(int i) {
		return taxSubtextArray[i];
	}

	
	//Get brewery information
	public String getBreweryNameArray(int i) {
		return breweryNameArray[i];
	}

	public String getBreweryDescriptionArray(int i) {
		return breweryDescriptionArray[i];
	}

	public String getBrewerySubtextArray(int i) {
		return brewerySubtextArray[i];
	}

	
	//Get Territory information
	public String getTerritoryNameArray(int i) {
		return territoryNameArray[i];
	}

	public String getTerritoryDescArray(int i) {
		return territoryDescArray[i];
	}

	public String getTerritorySubtextArray(int i) {
		return territorySubtextArray[i];
	}

	
	/**
	 * Get parkinglot Name
	 */
	public String getField34Name() {
		return field34Name;
	}
	
	/**
	 * Get parkinglot description
	 */
	public String getField34Description() {
		return field34Description;
	}
	/**
	 * Get parkinglot subtext
	 */
	public String getField34subtext() {
		return field34subtext;
	}

	
	/**
	 * Jail Name
	 * @return field30Name
	 */
	public String getField30Name() {
		return field30Name;
	}

	public String getField30Description() {
		return field30Description;
	}

	public String getField30subtext() {
		return field30subtext;
	}
	/**
	 * Go To Jail information
	 */
	public String getField31Name() {
		return field31Name;
	}
	/**
	 * Go To Jail information
	 */
	public String getField31Description() {
		return field31Description;
	}
	/**
	 * Go To Jail information
	 */
	public String getField31subtext() {
		return field31subtext;
	}
	
	
	
	
	
	
}

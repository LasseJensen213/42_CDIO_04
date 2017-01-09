package stringbanks;

public class Stringbank_Card {

	// Specialcard
	private static String pardon = "Ryk brikken frem til det nærmeste rederi"
			+ " og betal ejeren to gange den leje, han ellers er berettiget til."
			+ " Hvis selskabet ikke ejes af nogen, kan de købe det af banken";
	private static String bailout = "I anledning af konges fødselsdag benådes "
			+ "De herved for fængsel. Dette kort kan opbevares, indtil"
			+ " De får brug for det, eller de kan sælge det.";
	private static String jailed = "Gå i fængsel. Ryk direkte til fængslet."
			+ " Selv om De passerer ”START”, indkasserer De ikke kr. 4.000.";
	private static String matadorlegat = "De modtager ”Matador-legatet for værdigt trængende”"
			+ " på kr. 40.000. ved værdigt trængende forstås, at Deres formue,"
			+ " dvs. Deres kontante penge + skøder + bygninger, ikke overstiger kr. 15.000.";

	private static String[] specialcard = {pardon,bailout,jailed,matadorlegat};


	//Player-pays-Player card
	private static String ppp1 = "De skal holde familiefest og får tilskud fra hver medspiller på kr. 500.";
	private static String ppp2 = "De har lagt penge ud til et sammenskudsgilde."
			+ " Mærkværdigvis betaler alle straks. Modtag fra hver medspiller kr. 500";
	private static String ppp3 = "Det er Deres fødselsdag. Modtag af hver medspiller kr. 200."; 

	private static String[] playerPaysPlayerCard = {ppp1,ppp2,ppp3};


	//Receive Money card
	private static String rm1 = "Deres præmieobligation er udtrukket. De modtager kr. 1.000 af banken";
	private static String rm2 = "De har vundet i Klasselotteriet. Modtag kr. 500.";
	private static String rm3 = "De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken.";
	private static String rm4 = "Modtag udbytte af Deres aktier - kr. 1.000.";
	private static String rm5 = "Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken.";
	private static String rm6 = "De har solgt nogle gamle møbler på auktion. Modtag kr. 1.000 af banken.";
	private static String rm7 = "Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.";
	private static String rm8 = "De havde en række med elleve rigtige i tipning. Modtag kr. 1.000.";
	private static String rm9 = "Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000.";

	private static String[] receiveMoneyCard  = {rm1,rm2,rm3,rm4,rm5,rm6,rm7,rm8,rm9};

	//Pay Money Card
	private static String pm1 = "De har købt 4 nye dæk til Deres vogn. Betal kr. 1.000.";
	private static String pm2 = "De har fået en parkeringsbøde. Betal kr. 200 i bøde.";
	private static String pm3 = "Betal for vognvask og smøring kr. 300.";
	private static String pm4 = "Betal kr. 3.000 for reparation af Deres vogn.";
	private static String pm5 = "De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200.";
	private static String pm6 = "De har modtaget Deres tandlægeregning. Betal kr. 2.000.";
	private static String pm7 = "Betal kr. 200 for levering af 2 kasser øl. ";
	private static String pm8 = "Betal Deres bilforsikring - kr. 1.000.";
	private static String pm9 = "Ejendomsskatterne er steget. Ekstraudgifterne er: kr. 800 pr. hus, kr. 2.300 pr. hotel.";
	private static String pm10 = "Oliepriserne er steget, og De skal betale: kr. 500 pr. hus, kr. 2.000 pr. hotel";

	private static String[] payMoneyCard = {pm1,pm2,pm3,pm4,pm5,pm6,pm7,pm8,p9,pm10};

	//Move Figure Card
	private static String mf1 = "Ryk frem til ”START”.";
	private static String mf2 = "Tag ind på Rådhuspladsen.";
	private static String mf3 = "Ryk frem til Vimmelskaftet. Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf4 = "Ryk tre felter tilbage.";
	private static String mf5 = "Ryk frem til Strandvejen. Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf6 = "Ryk frem til Grønningen. Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf7 = "Tag med Mols-Linien. Flyt brikken frem, og Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf8 = "Tag med den nærmeste færge. Flyt brikken frem, og Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf9 = "Ryk frem til Frederiksberg Allé. Hvis De passerer ”START”, indkassér da kr. 4.000.";
	private static String mf10 = "Ryk tre felter frem";

	private static String[] moveFigureCard ={mf1,mf2,mf3,mf4,mf5,mf6,mf7,mf8,mf9,mf10};

}

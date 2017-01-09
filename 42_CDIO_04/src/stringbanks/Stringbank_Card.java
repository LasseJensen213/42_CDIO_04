package stringbanks;

public class Stringbank_Card {

	// Specialcard
	private static String pardon = "Ryk brikken frem til det n�rmeste rederi"
			+ " og betal ejeren to gange den leje, han ellers er berettiget til."
			+ " Hvis selskabet ikke ejes af nogen, kan de k�be det af banken";
	private static String bailout = "I anledning af konges f�dselsdag ben�des "
			+ "De herved for f�ngsel. Dette kort kan opbevares, indtil"
			+ " De f�r brug for det, eller de kan s�lge det.";
	private static String jailed = "G� i f�ngsel. Ryk direkte til f�ngslet."
			+ " Selv om De passerer �START�, indkasserer De ikke kr. 4.000.";
	private static String matadorlegat = "De modtager �Matador-legatet for v�rdigt tr�ngende�"
			+ " p� kr. 40.000. ved v�rdigt tr�ngende forst�s, at Deres formue,"
			+ " dvs. Deres kontante penge + sk�der + bygninger, ikke overstiger kr. 15.000.";

	private static String[] specialcard = {pardon,bailout,jailed,matadorlegat};


	//Player-pays-Player card
	private static String ppp1 = "De skal holde familiefest og f�r tilskud fra hver medspiller p� kr. 500.";
	private static String ppp2 = "De har lagt penge ud til et sammenskudsgilde."
			+ " M�rkv�rdigvis betaler alle straks. Modtag fra hver medspiller kr. 500";
	private static String ppp3 = "Det er Deres f�dselsdag. Modtag af hver medspiller kr. 200."; 

	private static String[] playerPaysPlayerCard = {ppp1,ppp2,ppp3};


	//Receive Money card
	private static String rm1 = "Deres pr�mieobligation er udtrukket. De modtager kr. 1.000 af banken";
	private static String rm2 = "De har vundet i Klasselotteriet. Modtag kr. 500.";
	private static String rm3 = "De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken.";
	private static String rm4 = "Modtag udbytte af Deres aktier - kr. 1.000.";
	private static String rm5 = "V�rdien af egen avl fra nyttehaven udg�r kr. 200, som De modtager af banken.";
	private static String rm6 = "De har solgt nogle gamle m�bler p� auktion. Modtag kr. 1.000 af banken.";
	private static String rm7 = "Grundet dyrtiden har De f�et gageforh�jelse. Modtag kr. 1.000.";
	private static String rm8 = "De havde en r�kke med elleve rigtige i tipning. Modtag kr. 1.000.";
	private static String rm9 = "Kommunen har eftergivet et kvartals skat. H�v i banken kr. 3.000.";

	private static String[] receiveMoneyCard  = {rm1,rm2,rm3,rm4,rm5,rm6,rm7,rm8,rm9};

	//Pay Money Card
	private static String pm1 = "De har k�bt 4 nye d�k til Deres vogn. Betal kr. 1.000.";
	private static String pm2 = "De har f�et en parkeringsb�de. Betal kr. 200 i b�de.";
	private static String pm3 = "Betal for vognvask og sm�ring kr. 300.";
	private static String pm4 = "Betal kr. 3.000 for reparation af Deres vogn.";
	private static String pm5 = "De har v�ret en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200.";
	private static String pm6 = "De har modtaget Deres tandl�geregning. Betal kr. 2.000.";
	private static String pm7 = "Betal kr. 200 for levering af 2 kasser �l. ";
	private static String pm8 = "Betal Deres bilforsikring - kr. 1.000.";
	private static String pm9 = "Ejendomsskatterne er steget. Ekstraudgifterne er: kr. 800 pr. hus, kr. 2.300 pr. hotel.";
	private static String pm10 = "Oliepriserne er steget, og De skal betale: kr. 500 pr. hus, kr. 2.000 pr. hotel";

	private static String[] payMoneyCard = {pm1,pm2,pm3,pm4,pm5,pm6,pm7,pm8,p9,pm10};

	//Move Figure Card
	private static String mf1 = "Ryk frem til �START�.";
	private static String mf2 = "Tag ind p� R�dhuspladsen.";
	private static String mf3 = "Ryk frem til Vimmelskaftet. Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf4 = "Ryk tre felter tilbage.";
	private static String mf5 = "Ryk frem til Strandvejen. Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf6 = "Ryk frem til Gr�nningen. Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf7 = "Tag med Mols-Linien. Flyt brikken frem, og Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf8 = "Tag med den n�rmeste f�rge. Flyt brikken frem, og Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf9 = "Ryk frem til Frederiksberg All�. Hvis De passerer �START�, indkass�r da kr. 4.000.";
	private static String mf10 = "Ryk tre felter frem";

	private static String[] moveFigureCard ={mf1,mf2,mf3,mf4,mf5,mf6,mf7,mf8,mf9,mf10};

}

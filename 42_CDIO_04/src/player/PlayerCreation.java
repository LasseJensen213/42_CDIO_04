package player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import desktop_resources.GUI;
import stringbanks.Stringbanks_PlayerCreation;

public class PlayerCreation {

	//adding and defining colors from java import
	private ArrayList<String> availableColors;
	private Map<String,Color>colorMap;
<<<<<<< HEAD
	private Color[] colors = {Color.blue,Color.green, Color.red, Color.yellow, Color.white, Color.pink};
=======
	private Color[] colors = {Color.BLUE,Color.GREEN, Color.RED, Color.YELLOW, Color.WHITE, Color.PINK};

	Stringbanks_PlayerCreation s = new Stringbanks_PlayerCreation();
	PlayerList pList;
>>>>>>> branch 'develop' of https://github.com/LasseJensen213/42_CDIO_04


<<<<<<< HEAD
	//Creating the players
	public void createPlayers(Player player) {
		String name = player.getName();
		int balance = player.getAccount().getBalance();
		GUI.addPlayer(name, balance, player.getCar() );
		GUI.setCar(1, name);
=======


	public PlayerCreation()
	{	pList = PlayerList.getPL();
		availableColors = new ArrayList<String>();
		colorMap = new HashMap<String,Color>();
		for(int i = 0; i<colors.length;i++)
		{
			availableColors.add(s.getColors(i));
			colorMap.put(s.getColors(i), colors[i]);
		}


	}




	/**
	 * Creates players:
	 */
	public void initPlayers() {
		int nPlayers = chooseNPlayers();
		pList.setNPlayers(nPlayers);
		for(int i = 0;i<nPlayers;i++){
			String name = chooseName(pList);
			int balance = 30000;
			Color color = getColor(chooseColor());
			Builder car = new Car.Builder();
			car.primaryColor(color).typeUfo();
			GUI.addPlayer(name, balance);
			GUI.setCar(1, name);
			pList.addPlayer(name, car, balance);
		}





>>>>>>> branch 'develop' of https://github.com/LasseJensen213/42_CDIO_04
	}

	//Choose name for players
	public String chooseName(PlayerList pList)
	{ 
		int nPlayersInList = pList.getPlayerList().size();
		while(true)
		{
			String name = GUI.getUserString(String.format(Stringbank_PlayerCreation.get/*STRINGBANKBESKED!!!*/, nPlayersInList+1));
			if(name.length()>16)
			{
				GUI.showMessage(Stringbank_PlayerCreation.get/*STRINGBANKBESKED!!!*/);
				continue;
			}
			else if(name.length()==0)
			{
				name = Stringbank_PlayerCreation.getPlayerName()+" "+(nPlayersInList+1);
			}
			if(pList.nameTaken(name))
			{
				GUI.showMessage(Stringbank_PlayerCreation.get/*STRINGBANKBESKED!!!*/);
			}
			else 
				return name;
		}
	}


	public String chooseColor() {
		availableColors = new ArrayList<String>();
		colorMap = new HashMap<String,Color>();
		
		for(int i = 0; i<colors.length;i++) {
			availableColors.add(Stringbank_PlayerCreation.getColor(i));
			colorMap.put(Stringbank_PlayerCreation.getColor(i), colors[i]);
		}

		
		String[] colorArr = availableColors.toArray(new String[]{});
		String color = GUI.getUserSelection(Stringbank_PlayerCreation.get/*STRINGBANKBESKED!!!*/,colorArr);

		//removes colors already chosen by other players
		availableColors.remove(color);
		return color;
	}


	public int chooseNPlayers()
	{
		return Integer.parseInt(GUI.getUserSelection(Stringbank_PlayerCreation.get/*STRINGBANKBESKED!!!*/, new String[]{"2","3","4","5","6"}));
	}

}

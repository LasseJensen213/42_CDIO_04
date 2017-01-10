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
	private Color[] colors = {Color.blue,Color.green, Color.red, Color.yellow, Color.white, Color.pink};


	//Creating the players
	public void createPlayers(Player player) {
		String name = player.getName();
		int balance = player.getAccount().getBalance();
		GUI.addPlayer(name, balance, player.getCar() );
		GUI.setCar(1, name);
	}

	//Choose name for players
	public String chooseName(PlayerManager playerManager)
	{ 
		int nPlayersInList = playerManager.getPlayerList().size();
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
			if(playerManager.nameTaken(name))
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

package player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import stringbanks.Stringbanks_PlayerCreation;

public class PlayerCreation {

	//adding and defining colors from java import
	private ArrayList<String> availableColors;
	private Map<String,Color>colorMap;
	private Color[] colors = {Color.BLUE,Color.GREEN, Color.RED, Color.YELLOW, Color.WHITE, Color.PINK};

	Stringbanks_PlayerCreation s = new Stringbanks_PlayerCreation();
	PlayerList pList;




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

			Car car = new Car.Builder().primaryColor(color).typeTractor().build();
			pList.addPlayer(name, car, balance);
			GUI.addPlayer(name, balance, car);
			GUI.setCar(1, name);

		}





	}

	//Choose name for players
	public String chooseName(PlayerList pList)
	{ 
		int nPlayersInList = pList.getPlayerList().size();
		while(true)
		{
			String name = GUI.getUserString(s.getMessages(0));
			if(name.length()>16)
			{
				GUI.showMessage(s.getMessages(1));
				continue;
			}
			else if(name.length()==0)
			{
				name = s.getMessages(2)+" "+(nPlayersInList+1);
			}
			if(pList.nameTaken(name))
			{
				GUI.showMessage(s.getMessages(3));
			}
			else 
				return name;
		}
	}

	public Color getColor (String color) {
		return colorMap.get(color);

	}

	public String chooseColor() {
		String[] colorArr = availableColors.toArray(new String[]{});
		String color = GUI.getUserSelection(s.getMessages(4),colorArr);

		//removes colors already chosen by other players
		availableColors.remove(color);
		return color;

	}


	public int chooseNPlayers()
	{
		return Integer.parseInt(GUI.getUserSelection(s.getMessages(5), new String[]{"2","3","4","5","6"}));
	}
}

package player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import boundary.PlayerCreationBoundary;
import desktop_codebehind.Car;

public class PlayerCreation {

	//adding and defining colors from java import
	private ArrayList<String> availableColors;
	private Map<String,Color>colorMap;
	private Color[] colors = {Color.BLUE,Color.GREEN, Color.RED, Color.YELLOW, Color.WHITE, Color.PINK};

	PlayerList pList;
	PlayerCreationBoundary pCB;




	public PlayerCreation() {
	pCB = new PlayerCreationBoundary();
	pList = PlayerList.getPL();
	availableColors = new ArrayList<String>();
	colorMap = new HashMap<String,Color>();
	for(int i = 0; i<colors.length;i++)
	{
		availableColors.add(pCB.getColors(i));
		colorMap.put(pCB.getColors(i), colors[i]);
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

			Car car = new Car.Builder().primaryColor(color).typeCar().build();
			pList.addPlayer(name, car, balance);
			pCB.addPlayer(name,balance,car);
			
			

		}





	}

	//Choose name for players
	public String chooseName(PlayerList pList)
	{ 
		int nPlayersInList = pList.getPlayerList().size();
		while(true)
		{
			String name = pCB.getUserString(0);
			if(name.length()>16)
			{
				pCB.showMessage(1);;
				continue;
			}
			else if(name.length()==0)
			{
				name = pCB.getMessages(2)+" "+(nPlayersInList+1);
			}
			if(pList.nameTaken(name))
			{
				pCB.showMessage(3);
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
		String color = pCB.chooseColor(colorArr);

		//removes colors already chosen by other players
		availableColors.remove(color);
		return color;

	}


	public int chooseNPlayers()
	{
		return pCB.chooseNPlayers();
	}
}

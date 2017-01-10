package player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import desktop_codebehind.Car;
import desktop_codebehind.Car.Builder;
import desktop_resources.GUI;
import stringbanks.Stringbanks_PlayerCreation;

public class PlayerCreation {

	//adding and defining colors from java import
	private ArrayList<String> availableColors;
	private Map<String,Color>colorMap;
	private Color[] colors = {Color.BLUE,Color.GREEN, Color.RED, Color.YELLOW, Color.WHITE, Color.PINK};

	Stringbanks_PlayerCreation s = new Stringbanks_PlayerCreation();
	PlayerManager pMan;




	public PlayerCreation()
	{	pMan = new PlayerManager();
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
		for(int i = 0;i<nPlayers;i++){
			String name = chooseName(pMan);
			int balance = 30000;
			Color color = getColor(chooseColor());
			Builder car = new Car.Builder();
			car.primaryColor(color).typeUfo();
			GUI.addPlayer(name, balance);
			GUI.setCar(1, name);
			pMan.addPlayer(name, car, balance);
		}





	}

	//Choose name for players
	public String chooseName(PlayerManager playerManager)
	{ 
		int nPlayersInList = playerManager.getPlayerList().size();
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
			if(playerManager.nameTaken(name))
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

	//	public void initPlayers()
	//	{
	//		//First choose number of players
	//		//nPlayers = playerCreateGUI.chooseNPlayers();
	//
	//		for(int i = 0; i<nPlayers;i++)
	//		{
	//			String name = playerCreate.chooseName(this);
	//			String color = playerCreate.chooseColor();//Chooses the color for the car
	//			addPlayer(name);
	//			playerList.get(i).setCar(playerCreate.getColor(color));
	//			playerCreate.addPlayerToBoard(playerList.get(i));
	//
	//
	//		}
	//
	//	}


}

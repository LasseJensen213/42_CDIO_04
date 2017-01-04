package player;

import java.util.ArrayList;
import gui.PlayerCreationGUI;

public class PlayerManager {

	private ArrayList<Player>playerList;
	private PlayerCreationGUI playerCreateGUI;

	private int nPlayers;
	
	public PlayerManager() 
	{
		this.playerList = new ArrayList<Player>();
		this.playerList.clear();
		this.playerCreateGUI = new PlayerCreationGUI();	
		
	
	}

	public void setNPlayers(int nPlayers)
	{
		this.nPlayers = nPlayers;
	}
	
	public void addPlayer(String name)
	{
		playerList.add(new Player(name));
	}
	
	public int getNPlayers()
	{
		return nPlayers;
	}
	
	public Player get(int index)
	{
		if(playerList.size()==0)
			return null;
		
		return playerList.get(index);
	}
	
	public ArrayList<Player> getPlayerList()
	{
		return playerList;
	}
	
	
	
	public void initPlayers()
	{
		//First choose number of players
		nPlayers = playerCreateGUI.chooseNPlayers();
		
		for(int i = 0; i<nPlayers;i++)
		{
			String name = playerCreateGUI.chooseName(this);
			String color = playerCreateGUI.chooseColor();//Chooses the color for the car
			addPlayer(name);
			playerList.get(i).setCar(playerCreateGUI.getColor(color));
			playerCreateGUI.addPlayerToBoard(playerList.get(i));
				
			
		}
		
	}
	
	
	/**
	 * Checks to see if a name is already taken by  a player in the player list
	 * @param name
	 * @return
	 * true if taken<br>
	 * false if not<br>
	 */
	
	public boolean nameTaken(String name)
	{
		for(int i = 0; i<playerList.size() ;i++)
		{
			if(playerList.get(i).getName().equals(name))
				return true;
		}
		return false;
	}
	
	
	
	/**
	 * Pass the turn to the next valid player
	 */
	public int nextPlayer(int index)
	{
		boolean turnSwitched = false;
		while(!turnSwitched)
		{
			index = ++index%nPlayers;
			//Hvis den næste spiller ikke er gået fallit, så er det hans tur
			if(!playerList.get(index).isBroke())
			{
				turnSwitched = true;
			}
		}
		return index;
	}
	
	/**
	 * 
	 * @return true if there is a winner<br>
	 * false if there is none<br>
	 *
	 */
	public boolean checkForWinner()
	{
		int activePlayers = 0;
		for(int i = 0; i<nPlayers;i++)
		{
			if(!playerList.get(i).isBroke())
			{
				activePlayers++;
			}
			if(activePlayers>1)
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * Checks if the player with the index in the ArrayList is broke
	 * @param index
	 * @return
	 */
	public boolean checkIfBroke(int index)
	{
		if(playerList.get(index).getAccount().getBalance()<=0)
		{
			return true;
		}
		return false;
	}
	
	

	
	
	
	
	
}

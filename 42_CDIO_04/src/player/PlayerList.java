package player;

import java.util.ArrayList;

import desktop_codebehind.Car;

public class PlayerList {
	
	private ArrayList<Player>playerList;

	private static PlayerList INSTANCE;


	private int nPlayers;
	
	public PlayerList() 
	{
		this.playerList = new ArrayList<Player>();
		this.playerList.clear();
		
	
	}

	public static void resetPlayerList() {
		INSTANCE = null;
	}
	
	public void setNPlayers(int nPlayers)
	{
		this.nPlayers = nPlayers;
	}
	
	public void addPlayer(String name,Car car,int i)
	{
		playerList.add(new Player(name,car,i));
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
	
	
	public static PlayerList getPL()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new PlayerList();
		}
		return INSTANCE;
	}
	
	
	
	
	
}

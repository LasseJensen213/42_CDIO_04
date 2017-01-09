package game;

import boundary.PropertyBoundary;
import field.Ownable;
import field.Territory;
import player.Player;
import player.PlayerList;
import stringbanks.Stringbanks_Property;

public class PropertyController {

	private final int MAX_HOUSES = 32;
	private final int MAX_HOTELS = 12;
	private int housesUsed = 0;
	private int hotelsUsed = 0;
	PropertyBoundary gui; 
	PlayerList pList;

	public PropertyController()
	{
		gui = new PropertyBoundary();
		pList = PlayerList.getPL();
	}

	/**
	 * This is the menu where you choose whether you want to buy houses/hotels or trade with other players
	 * @param player
	 */
	public void buyAssets(Player player)
	{
		while(true)
		{
			String[] options = new String[0];
			Territory[] validHousePlacements = getValidHousePlacements(player);
			Territory[] validHotelUpgrades = getValidHotelsUpgrades(player);
			Player[] validTradePlayers = validPlayersToTradeWith(player);
			int cheapestHouse = cheapestHousePrice(validHousePlacements);
			int cheapestHotel = cheapestHousePrice(validHotelUpgrades);

			if(validHousePlacements.length>0 && housesUsed < MAX_HOUSES && player.getAccount().getBalance()>cheapestHouse)
				options = addToArray(options,Stringbanks_Property.get(11));

			if(validHotelUpgrades.length>0 && hotelsUsed < MAX_HOTELS && player.getAccount().getBalance()>cheapestHotel)
				options = addToArray(options,Stringbanks_Property.get(12));

			if(canTrade(player) && validTradePlayers.length>0)
				options = addToArray(options, Stringbanks_Property.get(13));

			options =  addToArray(options,Stringbanks_Property.get(6));

			String choice = gui.chooseWhatToBuy(options);

			if(choice.equals(Stringbanks_Property.get(11)))
			{
				buyHouse(player);
			}
			else if(choice.equals(Stringbanks_Property.get(12)))
			{
				buyHotel(player);
			}
			else if(choice.equals(Stringbanks_Property.get(13)))
			{
				tradeWithPlayer(player);
			}
			else if(choice.equals(Stringbanks_Property.get(6)))
			{
				break;
			}
		}

	}
	/**
	 * This is the menu for buying houses
	 * @param player
	 */
	public void buyHouse(Player player)
	{
		while(true)
		{	
			String options[] = new String[0];
			Territory[] validFields = getValidHousePlacements(player);
			if(player.getAccount().getBalance()>cheapestHousePrice(validFields) && housesUsed<MAX_HOUSES )
			{
				for(Territory t : validFields)
				{
					options = addToArray(options,t.getTitle());
				}
			}
			options = addToArray(options, Stringbanks_Property.get(5));

			String choice = gui.chooseWhereToBuyHouses(options);

			if(choice.equals(Stringbanks_Property.get(5)))
				break;
			for(int i = 0; i<validFields.length;i++)
			{
				if(validFields[i].getTitle().equals(choice) )
				{
					validFields[i].addHouse(1);
					player.getAccount().withdraw(validFields[i].getHousePrice());
					housesUsed++;
					gui.updateHouseCount(validFields[i].getFieldPosition(), validFields[i].getHouse());
					gui.updatePlayerBalance(player.getName(), player.getAccount().getBalance());
				}
			}

		}


	}

	/**
	 * This is the menu for buying Hotels
	 * @param player
	 */
	public void buyHotel(Player player)
	{
		while(true)
		{
			String[] options = new String[0];
			Territory[] validFields = getValidHotelsUpgrades(player);

			for(Territory t : validFields)
			{
				if(player.getAccount().getBalance()>t.getHousePrice() && hotelsUsed<MAX_HOTELS)
				{
					options = addToArray(options, t.getTitle());
				}

			}


			options = addToArray(options, Stringbanks_Property.get(5));

			String choice = gui.chooseWhereToUpgradeHotel(options);
			if(choice.equals(Stringbanks_Property.get(5)))
			{
				break;
			}
			for(int i = 0; i<validFields.length;i++)
			{
				if(validFields[i].getTitle().equals(choice))
				{
					validFields[i].addHouse(1);
					housesUsed-=4;
					hotelsUsed++;
					player.getAccount().withdraw(validFields[i].getHousePrice());
					gui.updatePlayerBalance(player.getName(), player.getAccount().getBalance());
					gui.updateHotelPlacement(validFields[i].getFieldPosition(), true);
				}
			}
		}



	}

	/**
	 * A player chooses someone to trade with and what to trade 
	 * @param player
	 */
	public void tradeWithPlayer(Player player)
	{
		while(true)
		{
			Player[] players = validPlayersToTradeWith(player);
			String[] options = new String[0];
			for(int i = 0; i<players.length;i++)
			{
				options = (String[]) addToArray(options,players[i].getName());
			}
			options = (String[]) addToArray(options,Stringbanks_Property.get(5));

			String choice = gui.chooseWhoToTradeWith(options);
			if(choice.equals(Stringbanks_Property.get(5)))
			{
				break;
			}
			for(int i = 0; i<players.length;i++)
			{
				if(choice.equals(players[i].getName()))
				{
					Ownable yourField = chooseYourAssetForTrade(player);
					//if yourField or otherPlayersField is null that means 
					//the player has chosen to go back in the menu
					if(yourField!=null){
						Ownable otherPlayersField = chooseAssetForTrade(players[i]);
						if(otherPlayersField!=null)
						{
							if(gui.confirmTrade(players[i].getName(),otherPlayersField.getTitle(),yourField.getTitle()))
							{
								player.getProperty().removeField(yourField);
								player.getProperty().addField(otherPlayersField);
								gui.setOwner(player.getName(), otherPlayersField.getFieldPosition());
								players[i].getProperty().removeField(otherPlayersField);
								players[i].getProperty().addField(yourField);
								gui.setOwner(players[i].getName(), yourField.getFieldPosition());
							}
						}
					}

				}
			}
		}	
	}

	/**
	 * A player choose one of his own assets that he wants to use to trade with
	 * @param player
	 * @return
	 */
	public Ownable chooseYourAssetForTrade(Player player)
	{
		String[] options = new String[0];
		Ownable[] assets = tradableAssets(player); 
		for(Ownable o :assets)
		{
			options = addToArray(options, o.getTitle());
		}
		options = addToArray(options, Stringbanks_Property.get(5));

		String choice = gui.chooseYourLots(options);

		for(int i = 0; i<assets.length;i++)
		{
			if(assets[i].getTitle().equals(choice))
				return assets[i];
		}
		return null;

	}
	
	
	/**
	 * a Player choose another player's field, that he wishes to trade for
	 * @param player
	 * @return
	 */
	public Ownable chooseAssetForTrade(Player player)
	{
		String[] options = new String[0];
		Ownable[] assets = tradableAssets(player); 
		for(Ownable o :assets)
		{
			options = addToArray(options, o.getTitle());
		}
		options = addToArray(options, Stringbanks_Property.get(5));

		String choice = gui.chooseWhatToTradeWith(options, player.getName());

		for(int i = 0; i<assets.length;i++)
		{
			if(assets[i].getTitle().equals(choice))
				return assets[i];
		}
		return null;

	}
	
	
	
	public int cheapestHousePrice(Territory[] territories)
	{
		int result = 500000;
		for(Territory t : territories)
		{
			if(t.getHousePrice()<result)
				result = t.getHousePrice();
		}
		return result;
	}

	/**
	 * Returns an Array of Ownable fields that has no houses built upon them
	 * @param player
	 * @return
	 */
	public Ownable[] tradableAssets(Player player)
	{
		Ownable[] result = new Ownable[0];
		for(int k = 0; k<player.getProperty().nFields();k++)
		{
			//Checks if the Field has any structures
			if(player.getProperty().getField(k) instanceof Territory &&
					((Territory)player.getProperty().getField(k)).getHouse()==0)
			{
				result = addToArray(result, player.getProperty().getField(k));
			}
			//These are the breweries and fleets
			else
			{
				result = addToArray(result, player.getProperty().getField(k));
			}
		}
		return result;
	}

	/**
	 * returns true of the player has anything to trade with
	 * @param player
	 * @return
	 */
	public boolean canTrade(Player player)
	{
		for(int k = 0; k<player.getProperty().nFields();k++)
		{
			//Checks if the Field has any structures
			if(player.getProperty().getField(k) instanceof Territory &&
					((Territory)player.getProperty().getField(k)).getHouse()==0)
			{
				return true;
			}
			else
			{
				return true;
			}
		}
		return false;
	}


	/**
	 * This method calculates the total worth of all the-<br>
	 * player's owned fields + houses/hotels
	 * @param p
	 * @return
	 */
	public int calculateAssets(Player p)
	{
		int result = 0;
		return result;
	}

	/**
	 * Returns an array of all the players that actually has something to trade with
	 * @param player
	 * @return
	 * Player[]
	 */
	public Player[] validPlayersToTradeWith(Player player)
	{
		Player[] validPlayers = new Player[0];
		for(int i = 0; i<pList.getNPlayers();i++)
		{
			if(pList.get(i)==player)
				continue;
			for(int k = 0; k<pList.get(i).getProperty().nFields();k++)
			{
				//Checks if the Field has any structures
				if(canTrade(pList.get(i)))
				{
					validPlayers = addToArray(validPlayers, pList.get(i));
				}
			}	
		}
		return validPlayers;
	}
	
	public Territory[] getValidHousePlacements(Player p)
	{
		int nDiffSeries = p.getProperty().nDifferentSeries();
		// a 2-dimensional array has to be uses here since territories are grouped by some ID
		// on the game board this is color that they've got in common
		Territory[][] series = new Territory[nDiffSeries][0];
		int[][] numOfHousesSeries = new int[nDiffSeries][0];
		
		//Placeholder for the different ID's
		String[] id = {"Y","R","B","BL","W"};
		for(int i = 0; i<series.length;i++)
		{
			int smallestNumOfHouses = 4;
			int nPartSeries = p.getProperty().nParticularSeries(id[i]);
			Territory[] singleSeries = new Territory[nPartSeries];
			int[] numOfHouses = new int[0];
			if(singleSeries.length == 0)
			{
				i--;
				continue;
			}
			for(int k = 0; k<singleSeries.length;k++)
			{
				int housePrice = p.getProperty().getTerritoryOfId(id[i], k).getHousePrice();
				if(housePrice<p.getAccount().getBalance())
				{
					singleSeries =  addToArray(singleSeries, p.getProperty().getTerritoryOfId(id[i], k));

					int houseCount = singleSeries[k].getHouse();
					numOfHouses = addToArray(numOfHouses,houseCount);

					if(houseCount<smallestNumOfHouses)
						smallestNumOfHouses = houseCount;
				}

			}
			//The last index in the numOfHouses array is the smallest number of houses of that series
			//This is needed to be known since there has to be an equal distribution of houses
			numOfHouses =  addToArray(numOfHouses,smallestNumOfHouses);
			series =  addToTwoDimensionalArray(series, singleSeries);
			numOfHousesSeries = addToTwoDimensionalArray(numOfHousesSeries, numOfHouses );
		}
		Territory[] result = new Territory[0];
		for(int outer = 0; outer<series.length;outer++)
		{
			if(numOfHousesSeries[outer][numOfHousesSeries[outer].length-1]==4)
				continue;

			for(int inner = 0; inner<series[outer].length;inner++)
			{
				if(numOfHousesSeries[outer][inner]==numOfHousesSeries[outer][numOfHousesSeries[outer].length-1])
					result = addToArray(result, series[outer][inner]);
			}

		}
		return result;


	}

	/**
	 * Returns an array of the names of the territories where you can upgrade to hotel<br>
	 * @param p
	 * @return
	 */
	public Territory[] getValidHotelsUpgrades(Player p)
	{
		Territory[] result = new Territory[0];
		for(int i = 0; i<p.getProperty().nFields();i++)
		{
			if(((Territory)p.getProperty().getField(i)).getHouse()==4)
			{
				result = addToArray(result,(Territory)p.getProperty().getField(i));
			}
		}
		return result;
	}





	public String[] addToArray(String[] array, String element)
	{
		String[] result = new String[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}
	public Player[] addToArray(Player[] array, Player element)
	{
		Player[] result = new Player[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}

	public int[] addToArray(int[] array, int element)
	{
		int[] result = new int[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}
	public Territory[] addToArray(Territory[] array, Territory element)
	{
		Territory[] result = new Territory[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}

	public Ownable[] addToArray(Ownable[] array, Ownable element)
	{
		Ownable[] result = new Ownable[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}

	public Territory[][] addToTwoDimensionalArray(Territory[][] array, Territory[] element)
	{
		Territory[][] result = new Territory[array.length+1][];
		for(int outer = 0;outer<array.length;outer++)
		{
			for(int inner = 0; inner<array[outer].length;inner++)
			{
				result[outer] = addToArray(result[outer],array[outer][inner]);
			}

		}
		result[result.length-1] = element;
		return result;
	}

	public Player[][] addToTwoDimensionalArray(Player[][] array, Player[] element)
	{
		Player[][] result = new Player[array.length+1][];
		for(int outer = 0;outer<array.length;outer++)
		{
			for(int inner = 0; inner<array[outer].length;inner++)
			{
				result[outer] = addToArray(result[outer],array[outer][inner]);
			}

		}
		result[result.length-1] = element;
		return result;
	}

	public Ownable[][] addToTwoDimensionalArray(Ownable[][] array, Ownable[] element)
	{
		Ownable[][] result = new Ownable[array.length+1][];
		for(int outer = 0;outer<array.length;outer++)
		{
			for(int inner = 0; inner<array[outer].length;inner++)
			{
				result[outer] = addToArray(result[outer],array[outer][inner]);
			}

		}
		result[result.length-1] = element;
		return result;
	}

	public int[][] addToTwoDimensionalArray(int[][] array, int[] element)
	{
		int[][] result = new int[array.length+1][];
		for(int outer = 0;outer<array.length;outer++)
		{
			for(int inner = 0; inner<array[outer].length;inner++)
			{
				result[outer] = addToArray(result[outer],array[outer][inner]);
			}

		}
		result[result.length-1] = element;
		return result;
	}

	public String[][] addToTwoDimensionalArray(String[][] array, String[] element)
	{
		String[][] result = new String[array.length+1][];
		for(int outer = 0;outer<array.length;outer++)
		{
			for(int inner = 0; inner<array[outer].length;inner++)
			{
				result[outer] = addToArray(result[outer],array[outer][inner]);
			}

		}
		result[result.length-1] = element;
		return result;
	}


}

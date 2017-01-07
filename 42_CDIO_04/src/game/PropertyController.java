package game;

import field.Territory;
import player.Player;
import player.PlayerList;

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

	public void buyAssets(Player player)
	{
		while(true)
		{
			String[] options = new String[0];
			Territory[] validHousePlacements = getValidHousePlacements(player);
			Territory[] validHotelUpgrades = getValidHotelsUpgrades(player);
			
			if(validHousePlacements.length>0 && housesUsed<MAX_HOUSES && player.getAccount().getBalance()>2000)
				options = (String[]) addToArray(options,"Køb huse");
			
			if(validHotelUpgrades.length>0 && hotelsUsed < MAX_HOTELS && player.getAccount().getBalance()>5000)
				options = (String[]) addToArray(options,"Køb hoteller");
			
			options = (String[]) addToArray(options,"Gå videre");
			
			String choice = gui.chooseWhatToBuy(options);
			
			if(choice.equals("Køb huse"))
			{
				buyHouse(player);
			}
			else if(choice.equals("Køb hoteller"))
			{
				buyHotel(player);
			}
			else if(choice.equals("Gå videre"))
			{
				break;
			}
		}
		
	}
	public void buyHouse(Player player)
	{
		while(true)
		{	
			String options[] = new String[0];
			Territory[] validFields = getValidHousePlacements(player);
			if(player.getAccount().getBalance()>2000 && housesUsed<MAX_HOUSES )
			{
				for(Territory t : validFields)
				{
					options = (String[]) addToArray(options,t.getTitle());
				}
			}
			options = (String[]) addToArray(options, "Gå tilbage");
			
			String choice = gui.chooseWhereToBuyHouses(options);
			
			if(choice.equals("Gå tilbage"))
				break;
			for(int i = 0; i<validFields.length;i++)
			{
				if(validFields[i].getTitle().equals(choice) )
				{
					validFields[i].addHouse(1);
					player.getAccount().withdraw(2000);
					housesUsed++;
					gui.updateHouseCount(validFields[i].getFieldPosition(), validFields[i].getHouse());
					gui.updatePlayerBalance(player.getName(), player.getAccount().getBalance());
				}
			}
			
		}
		
		
	}
	
	public void buyHotel(Player player)
	{
		while(true)
		{
			String[] options = new String[0];
			Territory[] validFields = getValidHotelsUpgrades(player);
			if(player.getAccount().getBalance()>5000 && hotelsUsed<MAX_HOTELS)
			{
				for(Territory t : validFields)
				{
					options = (String[]) addToArray(options, t.getTitle());
				}
			}
			
			options = (String[]) addToArray(options, "Gå tilbage");
			
			String choice = gui.chooseWhereToUpgradeHotel(options);
			if(choice.equals("Gå tilbage"))
			{
				break;
			}
			for(int i = 0; i<validFields.length;i++)
			{
				if(validFields[i].getTitle().equals(choice))
				{
					validFields[i].setHouse(0);
					validFields[i].setHotel(true);
					housesUsed-=4;
					hotelsUsed++;
					player.getAccount().withdraw(5000);
					gui.updatePlayerBalance(player.getName(), player.getAccount().getBalance());
					gui.updateHotelPlacement(validFields[i].getFieldPosition(), true);
				}
			}
		}
		
		
		
	}

	public void trade()
	{
		
	}
	
	public Player[] validPlayersToTradeWith(Player player)
	{
		Player[] validPlayers = new Player[0];
		for(int i = 0; i<pList.getNPlayers();i++)
		{
			if(pList.get(i)==player)
				continue;
			validPlayers = (Player[]) addToArray(validPlayers,pList.get(i));
		}
		return validPlayers;
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
		for(int i = 0 ; i<p.getProperty().nFields();i++)
		{
			//Ownable fields are missing a getPawnPrice method
			result+=p.getProperty().get(i).getPrice();
			//Needs proper price for selling a house
			result+=((Territory)p.getProperty().get(i)).getHouse()*1234;
			//Territory needs a hasHotel boolean
			if(((Territory)p.getProperty().get(i)).hasHotel())
			{
				result+=5000;
			}
		}
		return result;
	}

	public Territory[] getValidHousePlacements(Player p)
	{
		int nDiffSeries = p.getProperty().nDifferentSeries();
		Territory[][] series = new Territory[nDiffSeries][0];
		Integer[][] numOfHousesSeries = new Integer[nDiffSeries][0];
		int smallestNumOfHouses = 4;
		//Placeholder for the different ID's
		String[] id = {"Y","R","B","BL","W"};
		for(int i = 0; i<series.length;i++)
		{
			int nPartSeries = p.getProperty().nParticularSeries(id[i]);
			Territory[] singleSeries = new Territory[0];
			Integer[] numOfHouses = new Integer[0];
			if(singleSeries.length == 0)
			{
				i--;
				continue;
			}
			for(int k = 0; k<singleSeries.length;k++)
			{
				if(!p.getProperty().getTerritoryOfId(id[i], k).hasHotel())
				{
					singleSeries =  (Territory[]) addToArray(singleSeries, p.getProperty().getTerritoryOfId(id[i], k));
					
					int houseCount = singleSeries[k].getHouse();
					numOfHouses = (Integer[]) addToArray(numOfHouses,houseCount);
					
					if(houseCount<smallestNumOfHouses)
						smallestNumOfHouses = houseCount;
				}
				
			}
			//The last index in the numOfHouses array is the smallest number of houses of that series
			//This is needed to be known since there has to be an equal distribution of houses
			numOfHouses = (Integer[]) addToArray(numOfHouses,smallestNumOfHouses);
			series = (Territory[][]) addToTwoDimensionalArray(series, singleSeries);
			numOfHousesSeries = (Integer[][]) addToTwoDimensionalArray(numOfHousesSeries, numOfHouses );
		}
		Territory[] result = new Territory[0];
		for(int outer = 0; outer<series.length;outer++)
		{
			if(numOfHousesSeries[outer][numOfHousesSeries[outer].length-1]==4)
				continue;
			
			for(int inner = 0; inner<series[outer].length;inner++)
			{
				if(numOfHousesSeries[outer][inner]==numOfHousesSeries[outer][numOfHousesSeries[outer].length-1])
					result = (Territory[]) addToArray(result, series[outer][inner]);
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
			if(((Territory)p.getProperty().get(i)).getHouse()==4)
			{
				result =  (Territory[]) addToArray(result,p.getProperty().get(i));
			}
		}
		return result;
	}
	
	
	
	
	
	public Object[] addToArray(Object[] array, Object element)
	{
		Object[] result = new Object[array.length+1];
		for(int i = 0; i<array.length;i++)
		{
			result[i] = array[i];
		}
		result[result.length-1] = element;
		return result;
	}
	
	public Object[][] addToTwoDimensionalArray(Object[][] array, Object[] element)
	{
		Object[][] result = new Object[array.length+1][];
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

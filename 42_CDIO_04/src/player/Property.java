package player;


import java.awt.Color;
import java.util.ArrayList;

import card.Card;
import field.Brewery;
import field.Fleet;
import field.Ownable;
import field.Territory;

public class Property {

	private Ownable[] fieldsOwned;
	private Card[] bailCards;

	public Property() {
		fieldsOwned = new Ownable[0];
		bailCards = new Card[0];

	}

	public int nFields()
	{
		return fieldsOwned.length;
	}
	
	public int nCards()
	{
		return bailCards.length;
	}

	public int nBreweriesOwned()
	{
		int result = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Brewery)
			{
				result++;
			}
		}
		return result;

	}
	
	public int nTerritoriesOwned()
	{
		int result = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Territory)
				result++;
		}
		return result;
	}

	public int nFleetsOwned()
	{
		int result = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Fleet)
			{
				result++;
			}
		}
		return result;
	}

	public void addField(Ownable newlyOwned)
	{
		Ownable[] newOwnableArr = new Ownable[nFields()+1];
		//First checks if the player already has the field
		//if he doesn't then it is added at the end of the array
		if(hasField(newlyOwned))
		{

		}
		else
		{
			int nFields = nFields();
			for(int i = 0; i<nFields;i++)
			{
				newOwnableArr[i]=fieldsOwned[i];
			}
			newOwnableArr[newOwnableArr.length-1] = newlyOwned;
			fieldsOwned = newOwnableArr;

		}

	}

	public void removeField(Ownable notOwned)
	{

		if(hasField (notOwned))
		{
			int nFields = nFields();
			for(int i = 0; i<nFields;i++)
			{
				if(fieldsOwned[i]==notOwned)
				{			
					fieldsOwned[i] = null;
					break;
				}
			}
			//now removes the fields
			Ownable[] newOwnableArr = new Ownable[nFields()-1];
			int newOwnableIndex = 0;
			for(int i = 0; i<nFields;i++)
			{
				if(fieldsOwned[i]!=null)
				{
					newOwnableArr[newOwnableIndex] = fieldsOwned[i];
					newOwnableIndex++;
				}
			}
			//updates the Fields Owned Array
			fieldsOwned=newOwnableArr;
		}

	}
	/**
	 * removes one bail out card from the players cards
	 */
	public void removeCard()
	{
		if(bailCards.length==0){
			
		}
		else
		{
			Card[] newBailCards = new Card[bailCards.length-1];
			for(int i = 1; i<bailCards.length;i++)
			{
				newBailCards[i-1] = bailCards[i];
			}
			bailCards = newBailCards;
		}
	}
	
	/**
	 * returns the n'th territory <br>
	 * If there are no Territories then it will return null<br>
	 * @param n
	 * @return
	 */
	public Territory getTerritory(int index)
	{
		int territoriesReached = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Territory)
			{
				if(territoriesReached == index)
					return (Territory)fieldsOwned[i];
				territoriesReached++;
			}
		}
		return null;
	}
	/**
	 * returns the n'th brewery <br>
	 * If there are no breweries then it will return null<br>
	 * @param index
	 * @return
	 */
	public Brewery getBrewery(int index)
	{
		int breweriesReached = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Brewery)
			{
				if(breweriesReached == index)
					return (Brewery)fieldsOwned[i];
				breweriesReached++;
			}
		}
		return null;
	}
	
	/**
	 * returns the n'th fleet <br>
	 * If there are no fleets then it will return null<br>
	 * @param index
	 * @return
	 */
	public Fleet getFleet(int index)
	{
		int fleetReached = 0;
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(fieldsOwned[i] instanceof Fleet)
			{
				if(fleetReached == index)
					return (Fleet)fieldsOwned[i];
				fleetReached++;
			}
		}
		return null;
	}
	/**
	 * Returns the n'th territory that belongs to the group.<br>
	 * Returns null if there are no Territories of the particular id.<br>
	 * Since the Fields are not ordered, it's index is not important<br>
	 * this is mainly used to loop through<br>
	 * @param id = the group
	 * @param index = the n'th territory
	 * @return
	 */
	public Territory getTerritoryOfId(Color series, int index)
	{
		int fieldsIndex = 0;
		int sameIdReached = 0;
		int nPart = nParticularSeries(series);
		for(int i = 0; i<nPart;i++)
		{
			if(fieldsOwned[fieldsIndex] instanceof Territory && 
			  ((Territory)fieldsOwned[i]).getColor().equals(series))		
			{
				if(sameIdReached==index)
					return (Territory)fieldsOwned[i];
				sameIdReached++;
			}
			fieldsIndex++;
		}
		return null;
	}
	
	/**
	 * Checks if the player owns a particular field
	 * @param field
	 * @return
	 * true - if he owns the field<br>
	 * false - if he doesn't own the field<br>
	 */
	public boolean hasField(Ownable field)
	{
		for(int i = 0; i<fieldsOwned.length;i++)
		{
			if(fieldsOwned[i]==field)
			{
				return true;
			}
		}
		return false;
	}

	public Card getCard(int i)
	{
		return bailCards[i];
	}
	

	public Ownable getField(int i)
	{
		return fieldsOwned[i];
	}

	/**
	 * Returns the number of different series the player owns<br>
	 * If he has more than one in a series it still only counts as one<br>
	 * fx, if the player owns 2 blue territories and 1 black, <br>
	 * then he owns territories of 2 different series and 2 will be returned<br>
	 * @return
	 */
	public int nDifferentSeries()
	{
		ArrayList<Color> alreadyCounted = new ArrayList<Color>();
		boolean isIn = false;
		int nTer = nTerritoriesOwned();
		for(int i = 0; i<nTer;i++)
		{
			isIn = false;
			for(int k = 0; k<alreadyCounted.size();k++)
			{
				if(getTerritory(i).getColor().equals(alreadyCounted.get(k)))
				{
					isIn = true;
				}
			}
			if(!isIn)
				alreadyCounted.add(getTerritory(i).getColor());
		}
		return alreadyCounted.size();
	}
	
	

	/**
	 * Returns the number of territories the player owns that has the same color
	 * @param id = the territory group
	 * @return
	 */
	public int nParticularSeries(Color series)
	{
		int result = 0;
		int nTer = nTerritoriesOwned();
		for(int i = 0;i<nTer;i++)
		{
			if(series.equals(getTerritory(i).getColor()))
			{
				result++;
			}
		}
		return result;
	}
	
	/**
	 * Returns true if the player owns the complete series with the same color
	 * @param series
	 * @return
	 */
	public boolean completeSeries(Color series)
	{
		if(getTerritoryOfId(series, 0)==null)
		{
			return false;
		}
		else
		{
			int max = getTerritoryOfId(series, 0).getSeries();
			int owned = nParticularSeries(series);
			return max == owned;
		}
		
	}
	
	public int totalValueOfAssets()
	{
		int result = 0;
		int nTer = nTerritoriesOwned();
		int nBre = nBreweriesOwned();
		int nFle = nFleetsOwned();
		for(int i = 0; i<nTer;i++)
		{
			result += getTerritory(i).getHouse()*getTerritory(i).getHousePrice();
			result+= getTerritory(i).getPrice();
		}
		for(int i = 0; i<nBre;i++)
		{
			result += getBrewery(i).getPrice();
		}
		for(int i = 0; i<nFle ; i++)
		{
			result += getFleet(i).getPrice();
		}
		return result;
	}
	
	
	
	
	
	

}

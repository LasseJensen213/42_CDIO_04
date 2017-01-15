package player;


import java.awt.Color;
import java.util.ArrayList;

import card.Bail;
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

	/**
	 * 
	 * @return
	 * total number of fields owned
	 */
	public int nFields()
	{
		return fieldsOwned.length;
	}
	
	/**
	 * 
	 * @return
	 * number of Bail cards held
	 */
	public int nCards()
	{
		return bailCards.length;
	}

	/**
	 * 
	 * @return
	 * number of breweries owned
	 */
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
	
	/**
	 * 
	 * @return Number of territories owned
	 */
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

	/**
	 * 
	 * @return
	 * Number of fleets owned
	 */
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

	/**
	 * adds the field to the end of the field array
	 * @param newlyOwned
	 */
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

	/**
	 * Removes the field in the array, thus making the array shorter
	 * @param notOwned
	 */
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
	 * and sets the InUse to false
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
			((Bail)bailCards[0]).setInUse(false);;
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
		int sameIdReached = 0;
		for(int i = 0; i<fieldsOwned.length;i++)
		{
			if(fieldsOwned[i] instanceof Territory && 
			  ((Territory)fieldsOwned[i]).getColor().equals(series))		
			{
				if(sameIdReached==index)
					return (Territory)fieldsOwned[i];
				sameIdReached++;
			}
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

	
	/**
	 * Adds a card to the players hand, the cards should only be Bail cards
	 * @param newCard
	 */
	public void addCard(Card newCard) {
		Card[] card = new Card[bailCards.length+1];
		for(int i = 0;i<bailCards.length;i++) {
			card[i] = bailCards[i];
			
		}
		card[card.length-1] = newCard;
		bailCards = card;
		
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
	
	/**
	 * 
	 * @return
	 * the  total sum of all the player's owned field's prices 
	 * and the price of the houses/hotels on the player's fields
	 */
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
	
	/**
	 * This is totalValueOfAssets but with the price of pawned fields subtracted
	 * @return
	 */
	public int totalValueOfSellableAssets()
	{
		int result = totalValueOfAssets();
		int nFields = nFields();
		for(int i = 0; i<nFields;i++)
		{
			if(getField(i).isPawned())
				result-=getField(i).getPrice();
		}
		return result;
	}
	
	
	
	/**
	 * Used for the menu where you buy houses/hotels
	 * @param series
	 * @return
	 */
	public int lowestNumOfHousesInSeries(Color series)
	{
		int nTer = nParticularSeries(series); //- The number of territories with the color
		int minHouses = 6;
		for(int i = 0; i<nTer;i++)
		{
			int nHouse = getTerritoryOfId(series,i).getHouse();
			if(nHouse<minHouses)
				minHouses = nHouse;
		}
		return minHouses;
	}
	/**
	 * Used for the menu where you sell houses/hotels
	 * @param series
	 * @return
	 */
	public int highestNumOfHousesInSeries(Color series)
	{
		int nTer = nParticularSeries(series);
		int maxHouses = 0;
		for(int i = 0; i<nTer;i++)
		{
			int nHouse = getTerritoryOfId(series,i).getHouse();
			if(nHouse>maxHouses)
				maxHouses = nHouse;
		}
		return maxHouses;
	}
	
	public boolean seriesHasPawnedFields(Color series)
	{
		int nTer = nParticularSeries(series);
		for(int i = 0; i<nTer;i++)
		{
			if(getTerritoryOfId(series, i).isPawned())
				return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	

}
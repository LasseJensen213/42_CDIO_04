package player;


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
		for(int i = 0; i<nFields();i++)
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
		for(int i = 0; i<nFields();i++)
		{
			if(fieldsOwned[i] instanceof Territory)
				result++;
		}
		return result;
	}

	public int nFleetsOwned()
	{
		int result = 0;
		for(int i = 0; i<nFields();i++)
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
			for(int i = 0; i<nFields();i++)
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
			for(int i = 0; i<nFields();i++)
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
			for(int i = 0; i<nFields();i++)
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
		else{
			Card[] newBailCards = new Card[bailCards.length-1];
			for(int i = 1; i<bailCards.length;i++)
			{
				newBailCards[i-1] = bailCards[i];
			}
			return newBailCards;
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
		for(int i = 0; i<nFields();i++)
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
		for(int i = 0; i<nFields();i++)
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
		for(int i = 0; i<nFields();i++)
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
	public Territory getTerritoryOfId(String id, int index)
	{
		int fieldsIndex = 0;
		int sameIdReached = 0;
		for(int i = 0; i<nParticularSeries(id);i++)
		{
			if(fieldsOwned[fieldsIndex] instanceof Territory && 
			  ((Territory)fieldsOwned[i]).getId().equals(id))		
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
		ArrayList<String> alreadyCounted = new ArrayList<String>();
		boolean isIn = false;
		for(int i = 0; i<nTerritoriesOwned();i++)
		{
			isIn = false;
			for(int k = 0; k<alreadyCounted.size();k++)
			{
				if(getTerritory(i).getId().equals(alreadyCounted.get(k)))
				{
					isIn = true;
				}
			}
			if(!isIn)
				alreadyCounted.add(getTerritory(i).getId());
		}
		return alreadyCounted.size();
	}
	
	

	/**
	 * Returns the number of territories the player owns that has the same id
	 * @param id = the territory group
	 * @return
	 */
	public int nParticularSeries(String id)
	{
		int result = 0;
		for(int i = 0;i<nTerritoriesOwned();i++)
		{
			if(id.equals(getTerritory(i).getId()))
			{
				result++;
			}
		}
		return result;
	}
	
	
	
	
	
	

}

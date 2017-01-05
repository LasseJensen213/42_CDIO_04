package player;

import field.Brewery;
import field.Fleet;
import field.Ownable;

public class Property {

	private Ownable[] fieldsOwned;
	//private Cards[] bailCards;
	
	public Property() {
		fieldsOwned = new Ownable[0];
		//bailCards = new Cards[0];
		
	}
	
	public int NFields()
	{
		return fieldsOwned.length;
	}
	
	public int NBreweriesOwned()
	{
		int result = 0;
		for(int i = 0; i<NFields();i++)
		{
			if(fieldsOwned[i] instanceof Brewery)
			{
				result++;
			}
		}
		return result;
		
	}
	
	public int NFleetsOwned()
	{
		int result = 0;
		for(int i = 0; i<NFields();i++)
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
		Ownable[] newOwnableArr = new Ownable[NFields()+1];
		for(int i = 0; i<NFields();i++)
		{
			newOwnableArr[i]=fieldsOwned[i];
		}
		newOwnableArr[newOwnableArr.length-1] = newlyOwned;
		fieldsOwned = newOwnableArr;
	}
	
	public void lostOwnership(Ownable notOwned)
	{
		
			//First checks that the player actually owns the field
			//Also removes any duplicate fields (If the field is in the array multiple times)
			boolean owns = false;
			int nOwned = 0;
			for(int i = 0; i<NFields();i++)
			{
				if(fieldsOwned[i]==notOwned)
				{
					owns = true;
					nOwned++;
					fieldsOwned[i] = null;
				}
			}
			
			//now removes the fields
			Ownable[] newOwnableArr = new Ownable[NFields()-nOwned];
			int newOwnableIndex = 0;
			for(int i = 0; i<NFields();i++)
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

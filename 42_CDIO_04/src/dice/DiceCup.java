package dice;
import java.util.*;
public class DiceCup {
	//Dice Cup
	private ArrayList<Dice> diceList;

	public DiceCup(int numOfDice, int numOfSides)
	{
		diceList = new ArrayList<Dice>();
		for(int i=0 ; i<numOfDice;i++)
		{
			diceList.add(new Dice(numOfSides));
		}
	}

	public int getDiceValue(int diceNumber)
	{
		return diceList.get(diceNumber).getFaceValue();
	}

	public void rollDice()
	{
		for(int i = 0; i<diceList.size();i++)
		{
			diceList.get(i).roll();
		}
	}

	public void changeDice(int numOfSides)
	{
		int size = diceList.size();
		diceList.clear();
		for(int i=0 ; i<size;i++)
		{
			diceList.add(new Dice(numOfSides));
		}
	}

	public int getDiceTotal()
	{
		int total = 0;
		for(int i = 0; i<diceList.size();i++)
		{
			total = total + getDiceValue(i);
		}
		return total;
	}
}
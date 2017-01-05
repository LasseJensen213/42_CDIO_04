package dice;

public class DiceCupTest {
	//test with dice values decided beforehand. this is intended for two players
	private int[][] diceResult= {{4,4},{5,5},{6,4},{2,1},{2,2},{5,5},{1,1},
								{3,2},{2,2},{1,2},{5,5},{6,4},{1,1},{1,1},
								{1,1},{1,2},{1,2},{2,3},{1,2},{3,2},{1,2},{2,4}};
	
	private int diceIndex = 0;
	
	public DiceCupTest(int numOfDice, int numOfSides) {
		
	}
	
	public int getDiceValue(int diceNumber)
	{
		return diceResult[diceIndex][diceNumber];
	}
	
	public void rollDice()
	{
		diceIndex = ++diceIndex%diceResult.length;
	}
	
	public void changeDice(int numOfSides)
	{
	}

	public int getDiceTotal()
	{
		return diceResult[diceIndex][0]+diceResult[diceIndex][1];
	}
}

package dice;

import java.util.Random;

public class Dice {
	
	private int faceValue;
	private int numOfSides;
	private Random rand = new Random();
	
	public Dice(int numOfSides)
	{
		this.numOfSides = numOfSides;
		this.faceValue = rand.nextInt(numOfSides)+1;
	}
	
	///getters and setters
	
	public int getFaceValue()
	{
		return this.faceValue;
	}
	
	public void setFaceValue(int faceValue)
	{
		this.faceValue = faceValue;
	}
	
	public int getNumOfSides()
	{
		return this.numOfSides;
	}
	
	public void setNumOfSides(int numOfSides)
	{
		this.numOfSides = numOfSides;
	}
	
	public void roll()
	{
		this.faceValue = rand.nextInt(this.numOfSides)+1; 
	}

}

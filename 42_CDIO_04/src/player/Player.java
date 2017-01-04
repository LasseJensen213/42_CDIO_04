package player;

import java.awt.Color;
import desktop_codebehind.Car;

public class Player 
{
	private Car car;
	private String name;
	private Account account;
	private boolean broke;
	private int playerPos;
	private int nFleetsOwned;
	private int nLaborOwned;
	private int lastDiceResult; // Bruges til labor camp

	public Player(String name)
	{
		this.name = name;
		this.broke = false;
		account = new Account(30000);
		car = new Car.Builder().build();//Default random coloured car
		this.playerPos = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isBroke() {
		return broke;
	}

	public void setBroke(boolean broke) {
		this.broke = broke;
	}

	public int getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(int playerPos) {
		this.playerPos = playerPos;
	}
	
	public int getFleetsOwned()
	{
		return nFleetsOwned;
	}
	
	public int getLaborOwned()
	{
		return nLaborOwned;
	}
	
	public void setFleetsOwned(int nFleetsOwned)
	{
		this.nFleetsOwned = nFleetsOwned;
	}
	
	public void setLaborOwned(int nLaborOwned)
	{
		this.nLaborOwned = nLaborOwned;
	}
	
	public int getDiceResult()
	{
		return this.lastDiceResult;
	}
	
	public void setDiceResult(int diceResult)
	{
		this.lastDiceResult = diceResult;
	}
	
	public Car getCar()
	{
		return car;
	}
	
	
	/**
	 * Creates new car object with the color that's input
	 * @param color
	 */
	public void setCar(Color color)
	{
		car = new Car.Builder().primaryColor(color).build();
	}
	
	
	
}

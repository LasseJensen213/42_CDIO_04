package player;

import desktop_codebehind.Car;
import dice.DiceCup;

public class Player 
{
	private Car car;
	private String name;
	private Account account;
	private boolean broke;
	private boolean jailed;
	private boolean passedStart;
	private int playerPos;
	
	//How many times the player has 
	private int equalFaceValue;
	private int timeInJail;
	private Property property;
	private int totalFaceValue;
	DiceCup diceCup = DiceCup.getDC();

	public int getEqualFaceValue() {
		return equalFaceValue;
	}
	
	public void setEqualFaceValue(int equalFaceValue) {
		this.equalFaceValue = equalFaceValue;
	}
	
	

	public int getTotalFaceValue() {
		return totalFaceValue;
	}

	public void setDiceTotalFaceValue() {
		this.totalFaceValue = diceCup.getDiceTotal();
	}
	public void setTotalFaceValue(int totalFaceValue) {
		this.totalFaceValue = totalFaceValue;
	}



	public Player(String name , Car car , int startBalance)
	{
		this.name = name;
		this.timeInJail = 0;
		this.setEqualFaceValue(0);
		this.broke = false;
		this.jailed = false;
		this.passedStart = false;
		account = new Account(startBalance);
		this.car = car;
		this.property = new Property();
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
	
	public Car getCar()
	{
		return car;
	}
	
	
	/**
	 * Creates new car object with the color that's input
	 * @param color
	 */
	public void setCar(Car car)
	{
		this.car = car;
	}

	public boolean isJailed() {
		return jailed;
	}

	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}

	public boolean isPassedStart() {
		return passedStart;
	}

	public void setPassedStart(boolean passedStart) {
		this.passedStart = passedStart;
	}

	public int getTimeInJail() {
		return timeInJail;
	}

	public void setTimeInJail(int timeInJail) {
		this.timeInJail = timeInJail;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	public void equalFaceValue() {
		if(!(equalFaceValue == 0)) {
			if(diceCup.isEqual()) {
				equalFaceValue++; 
			}
			else
				equalFaceValue = 0;
		}		
	}
	public void gotoJail() {
		if(equalFaceValue == 3) 
			jailed = true;
	}
	
}

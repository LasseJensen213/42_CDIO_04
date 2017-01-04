package player;

public class Account {
	private int balance;
	
	
	public Account(int balance)
	{
		this.balance = balance;
	}
	
	public boolean withdraw(int amount)
	{
		this.balance -= amount;
		return true;
	}
	
	public boolean deposit(int amount)
	{
		this.balance += amount;
		return true;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}

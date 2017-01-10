package player;

public class Account {
	private int balance;
	
	
	public Account(int balance)
	{
		this.balance = balance;
	}
	
	//withdraw and deposit methods
	
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
	
	//Getters and setters for balance

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

	//Transfer of "amount" to account "a"
	
	public void transfer(int amount, Account a) {
		
    //Makes sure you can't transfer money you don't have
		withdraw(amount);
    
		if(amount>this.balance) {
			amount = this.balance;
		}	
		a.deposit(amount);
	}
	
	

}

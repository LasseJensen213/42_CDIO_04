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
	

	//Transfer of "amount" to account "a"
	
	public void transfer(int amount, Account a)
	{
		//checks if the amount is greater than this accounts balance, since only available funds can be transfered
		
		if(amount>this.balance)
		{
			amount = this.balance;
		}
		withdraw(amount);
		a.deposit(amount);
	}
	
	

}

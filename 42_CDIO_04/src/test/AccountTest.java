package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import desktop_codebehind.Car;
import player.Account;
import player.Player;

public class AccountTest {
	private Player p1, p2;
	
	
	@Before
	public void setup() throws Exception {
		this.p1 = new Player("kim", new Car.Builder().build(), 1000);
		this.p2 = new Player("kim", new Car.Builder().build(), 1000);
	}
	
	@Test
	public void withdrawTest() {
		p1.getAccount().withdraw(600);
		assertTrue(p1.getAccount().getBalance() == 400);	
	}
	
	@Test
	public void transferTest() {
		p1.getAccount().transfer(500, p2.getAccount());
		assertTrue(p2.getAccount().getBalance() == 1500);
	}
	@Test
	public void setAccountTest() {
		Account account = new Account(0);
		int expected = 1;
		account.setBalance(expected);
		int actual = account.getBalance();
		assertEquals(expected,actual);
	}
	@Test
	public void getBalancetest() {
		Account account = new Account(40000);
		int expected = 40000;
		int actual = account.getBalance();
		assertEquals(expected,actual);		
	}	
}

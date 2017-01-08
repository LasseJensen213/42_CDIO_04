package field;

import java.awt.Image;

import player.Player;

public abstract class Ownable extends Field {
	private int price;
	private int rent;
	private Player owner;
	private boolean pawned;
	
	
	public Ownable(String desc, String subtext, String title, int pos, int price, int rent) {
		super(desc,subtext,title,pos);
		this.price = price;
		this.rent = rent;
		pawned = false;
		owner = null;
		
	}


	public int getPrice() {
		return price;
	}


	public int getRent() {
		return rent;
	}


	public Player getOwner() {
		return owner;
	}


	public boolean isPawned() {
		return pawned;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setRent(int rent) {
		this.rent = rent;
	}


	public void setOwner(Player owner) {
		this.owner = owner;
	}


	public void setPawned(boolean pawned) {
		this.pawned = pawned;
	}

	
	
	
	
}

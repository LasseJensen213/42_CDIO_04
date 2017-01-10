package field;

import java.awt.Image;

import player.Player;

public abstract class Ownable extends Field {
	private int price;
	private int rent;
	private Player owner;
	private boolean pawned;
	
	
	public Ownable(String desc, String subtext, String title, Image i, int pos, int price, int rent) {
		super(desc,subtext,title,i,pos);
		this.price = price;
		this.rent = rent;
		pawned = false;
		owner = null;
		
	}
	
	//Set owner for "player" to null
	
	public void freeOwner(Player player, int pos) {
		if(this.getOwner != null) {
			if(this.getOwner().getName().equals(player.getName())) {
				this.setOwner(null);
			}
		}
	}
	
	//Getters and Setters
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public boolean isPawned() {
		return pawned;
	}

	public void setPawned(boolean pawned) {
		this.pawned = pawned;
	}

}

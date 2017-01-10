package field;

import java.awt.Image;

import player.Player;

public abstract class Ownable extends Field {
	private int price;
	private Player owner;
	private boolean pawned;
	
	
	public Ownable(String desc, String subtext, String title, int pos, int price) {
		super(desc,subtext,title,pos);
		this.price = price;
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


	public int getPrice() {
		return price;
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


	


	public void setOwner(Player owner) {
		this.owner = owner;
	}


	public void setPawned(boolean pawned) {
		this.pawned = pawned;
	}


	@Override
	public String toString() {
		return "Ownable [price=" + price + ", owner=" + owner + ", pawned=" + pawned + ", getDesc()=" + getDesc()
				+ ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()="
				+ getFieldPosition() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	


	
	
}

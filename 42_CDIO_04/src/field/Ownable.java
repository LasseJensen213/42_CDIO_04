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

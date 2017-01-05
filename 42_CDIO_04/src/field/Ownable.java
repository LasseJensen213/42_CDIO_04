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

}

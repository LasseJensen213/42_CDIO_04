package controller;


import player.Player;



public class LandOnField {

	public void landOnTax(Player player){
		player.getAccount().withdraw(field.Tax.getTax());
	}

	public void landOnBrewery(Player player){
		
		if(field.Ownable.getOwner() == null){
			
			if(player.getAccount().getBalance()>field)
			{
			
			}
		}
		
	}
	      
}

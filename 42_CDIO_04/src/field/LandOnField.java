package field;

import board.Board;
import boundary.LandOnFieldBoundary;
import player.Player;

public class LandOnField {


	public void landOnField(Player player){
		Board b = new Board();
		field.Field f = b.getField(player.getPlayerPos());

		if(f instanceof Territory){
			landOnTerritory(player,(Territory)f);
		}
		else if(f instanceof Brewery){
			landOnBrewery(player,(Brewery)f);
		}
		else if(f instanceof Fleet){
			landOnFleet(player,(Fleet)f);
		}
		else if(f instanceof Chance){
			landOnChance(player,(Chance)f);
		}
		else if(f instanceof GoToJail){
			landOnGoToJail(player,(GoToJail)f);
		}
		else if(f instanceof Jail){
			landOnJail(player,(Jail)f);
		}
		else if(f instanceof ParkingLot){
			landOnParkingLot(player);
		}
		else if(f instanceof Start){
			landOnStart(player,(Start)f);
		}
		else if(f instanceof Tax){
			landOnTax(player,(Tax)f);
		}
	}

	// mangler udregning af leje
	public void landOnTerritory(Player player, Territory f){
		if(f.getOwner() == null){
			if(player.getAccount().getBalance()>(f.getPrice())){
				if(LandOnFieldBoundary.buyChoice()){
					player.getAccount().withdraw(f.getPrice());
					f.setOwner(player);
				}
			}
		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else {
			// mangler metode til at tr�kke dobbelt op p� husleje og huse. 1000 er et midlertidigt tal.

			player.getAccount().transfer(1000, f.getOwner().getAccount());
		}
	}
	// mangler udregning af leje
	public void landOnBrewery(Player player, Brewery f){
		if(f.getOwner() == null){
			if(player.getAccount().getBalance()>(f.getPrice())){
				if(LandOnFieldBoundary.buyChoice()){
					player.getAccount().withdraw(f.getPrice());
					f.setOwner(player);
				}
			}
		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else {
			// mangler metode til at tr�kke dobbelt op p� husleje og huse. 1000 er et midlertidigt tal.

			player.getAccount().transfer(1000, f.getOwner().getAccount());
		}
	}
	// mangler udregning af leje
	public void landOnFleet(Player player, Fleet f){
		if(f.getOwner() == null){
			if(player.getAccount().getBalance()>(f.getPrice())){
				if(LandOnFieldBoundary.buyChoice()){
					player.getAccount().withdraw(f.getPrice());
					f.setOwner(player);
				}
			}
		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else {
			// mangler metode til at tr�kke dobbelt op p� husleje og huse. 1000 er et midlertidigt tal.

			player.getAccount().transfer(1000, f.getOwner().getAccount());
		}
	}
	//f�rdig
	public void landOnTax(Player player, Tax f){
		player.getAccount().withdraw(f.getTax());
		ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+f.getTax());
	}
	//f�rdig
	public void landOnParkingLot(Player player){
		player.getAccount().deposit(ParkingLot.getTaxMoney());
		ParkingLot.setTaxMoney(0);
	}
	//f�rdig
	public void landOnJail(Player player, Jail f){

	}
	//f�rdig
	public void landOnGoToJail(Player player, GoToJail f){

		LandOnFieldBoundary.moveToJail(player.getName(), player.getPlayerPos());
		player.setPlayerPos(10);
		player.setJailed(true);

	}
	//ikke lavet
	public void landOnStart(Player player, Start f){
	}
	//ikke lavet
	public void landOnChance(Player player, Chance f){

	}
	
	
}



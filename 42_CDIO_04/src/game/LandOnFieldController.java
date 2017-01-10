package game;

import board.Board;
import boundary.LandOnFieldBoundary;
import card.Bail;
import card.Card;
import card.CardDeck;
import card.CardEffect;
import card.GoToJailCard;
import card.MovePlayer;
import card.TransferMoney;
import desktop_resources.GUI;
import field.Brewery;
import field.Chance;
import field.Fleet;
import field.GoToJail;
import field.Jail;
import field.ParkingLot;
import field.Start;
import field.Tax;
import field.Territory;
import player.Player;

public class LandOnFieldController {
	CardDeck cardDeck = new CardDeck();
	CardEffect cE = new CardEffect();
	Card card;


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
	
	
	
	public void landOnTerritory(Player player, Territory f){
		if(f.getOwner() == null){
			if(player.getAccount().getBalance()>(f.getPrice())){
				if(LandOnFieldBoundary.buyChoice()){
					player.getAccount().withdraw(f.getPrice());
					((Territory)f).setOwner(player);
				}
			}
		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else {

			int houses = f.getHouse();
			int rent = f.getRent(houses);
			if(houses == 0) {
				rent = rent*2;
			}

			player.getAccount().transfer(rent, f.getOwner().getAccount());
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
			int rent = player.getTotalFaceValue()*f.getRent()*100;
			
			player.getAccount().transfer(rent, f.getOwner().getAccount());
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
			int fleetsOwned = player.getProperty().nFleetsOwned();
			int rentArray[] = f.getRent();
			int rent = rentArray[fleetsOwned];
			
			player.getAccount().transfer(rent, f.getOwner().getAccount());
		}
	}
	
	
	
	//færdig
	public void landOnTax(Player player, Tax f){
		String choice[] = {"4000","10% af balance"};
		int rent = 0;
		if(f.getPercentange() == 0){
			rent = f.getTax();
			player.getAccount().withdraw(rent);

		}
		else if(f.getPercentange() == 10){
			String input = GUI.getUserSelection("Vælg imellem:", choice);
			if(input == choice[0]) {
				player.getAccount().withdraw(f.getTax());
			}
			else if(input == choice[1]) {
				GUI.showMessage("PAY");
				rent = player.getAccount().getBalance()*10/100;
				player.getAccount().withdraw(rent);
			}
		}
		ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+rent);
		
	}
	//færdig
	public void landOnParkingLot(Player player){
		player.getAccount().deposit(ParkingLot.getTaxMoney());
		ParkingLot.setTaxMoney(0);
	}
	//færdig
	public void landOnJail(Player player, Jail f){
		GUI.showMessage("Du er på besøg i fængslet.");

	}
	//færdig
	public void landOnGoToJail(Player player, GoToJail f){

		LandOnFieldBoundary.moveToJail(player.getName(), player.getPlayerPos());
		player.setPlayerPos(10);
		player.setJailed(true);

	}
	/**
	 * Nothing is supposed to happen on this field.
	 * @param player
	 * @param f
	 */
	public void landOnStart(Player player, Start f){
		
	}
	
	
	public void landOnChance(Player player, Chance f){
		card = cardDeck.draw();
		if(card instanceof Bail) {
			cE.cardEffectBail(player, (Card)card);
		}
		else if(card instanceof GoToJailCard) {
			cE.cardEffectGoToJail(player, (GoToJailCard)card);
		}
		else if(card instanceof MovePlayer) {
			cE.cardEffectMovePlayer(player, (MovePlayer)card);
		}
		else if(card instanceof TransferMoney) {
			cE.cardEffectTransferMoney(player, (TransferMoney)card);
		}
		
	}
	
	
}
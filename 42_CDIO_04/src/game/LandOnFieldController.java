package game;

import board.Board;
import boundary.CardEffectBoundary;
import boundary.LandOnFieldBoundary;
import card.Bail;
import card.Card;
import card.CardDeck;
import card.CardEffect;
import card.Cardgenerator;
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
	CardDeck cardDeck = CardDeck.CardDeck();
	CardEffect cE = new CardEffect();
	Card card;
	Board b = Board.Board();
	PropertyController pawnMenu = new PropertyController();


	private boolean doubleRent = false;

	/**
	 * Call this function every time a player lands on a field.
	 * It'll call the fields corresponding function.
	 * @param player
	 */
	public void landOnField(Player player){
		field.Field f = b.getField(player.getPlayerPos());
		LandOnFieldBoundary.youLandOn(f.getTitle());

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

	/**
	 * Decides what happens when a player lands on a territory field.
	 * @param player
	 * @param f
	 */
	public void landOnTerritory(Player player, Territory f){
		if(f.getOwner() == null)
		{
			while(f.getOwner()==null)
			{
				if(player.getAccount().getBalance()>(f.getPrice()))
				{
					if(LandOnFieldBoundary.buyChoice(f)){
						player.getAccount().withdraw(f.getPrice());
						((Territory)f).setOwner(player);
						LandOnFieldBoundary.setPlayerColorOnField(player.getName(), player.getPlayerPos());
						player.getProperty().addField(f);

					}
					else
					{
						break;
					}
				}
				else if(LandOnFieldBoundary.cantAffordToBuy())
				{
					pawnMenu.sellAssets(player);
				}
				else
				{
					break;
				}
			}

		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else if(f.isPawned()){
			LandOnFieldBoundary.displayMessage(4);
		}
		else {

			int houses = f.getHouse();
			int rent = f.getRent(houses);
			if(houses == 0 && player.getProperty().completeSeries(f.getColor())) {
				rent = rent*2;
			}

			player.getAccount().transfer(rent, f.getOwner().getAccount());
			LandOnFieldBoundary.payOwner(rent, f.getOwner().getName());
		}
	}

	/**
	 * Decides what happens when a player lands on a brewery field.
	 * @param player
	 * @param f
	 */
	public void landOnBrewery(Player player, Brewery f){
		if(f.getOwner() == null){
			while(f.getOwner()==null)
			{
				if(player.getAccount().getBalance()>(f.getPrice()))
				{
					if(LandOnFieldBoundary.buyChoice(f))
					{
						player.getAccount().withdraw(f.getPrice());
						f.setOwner(player);
						player.getProperty().addField(f);
						GUI.setOwner(player.getPlayerPos()+1, player.getName());

					}
					else
					{
						break;
					}
				}
				else if(LandOnFieldBoundary.cantAffordToBuy())
				{
					pawnMenu.sellAssets(player);
				}
				else
				{
					break;
				}
			}

		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else if(f.isPawned()){
			LandOnFieldBoundary.displayMessage(4);
		}
		else {
			int rent = player.getTotalFaceValue()*f.getRent()*100;

			player.getAccount().transfer(rent, f.getOwner().getAccount());
			LandOnFieldBoundary.payOtherPlayer(f.getOwner().getName(), rent);
		}
	}

	/**
	 * Decides what happens when a player lands on a fleet field.	
	 * @param player
	 * @param f
	 */
	public void landOnFleet(Player player, Fleet f){
		if(f.getOwner() == null){
			while(f.getOwner()==null)
				if(player.getAccount().getBalance()>(f.getPrice()))
				{
					if(LandOnFieldBoundary.buyChoice(f))
					{
						player.getAccount().withdraw(f.getPrice());
						f.setOwner(player);
						player.getProperty().addField(f);
						GUI.setOwner(player.getPlayerPos()+1, player.getName());

					}
					else
					{
						break;
					}

				}
				else if(LandOnFieldBoundary.cantAffordToBuy())
				{
					pawnMenu.sellAssets(player);
				}
				else
				{
					break;
				}
		}
		else if(f.getOwner() == player){
			//nothing happens
		}
		else if(f.isPawned()){
			LandOnFieldBoundary.displayMessage(4);
		}
		else {
			int fleetsOwned =f.getOwner().getProperty().nFleetsOwned();
			int fleetsNotPawned = 0;
			for(int i = 0; i<fleetsOwned;i++)
			{
				if(!f.getOwner().getProperty().getFleet(i).isPawned())
				{
					fleetsNotPawned++;
				}
			}
			int rent = 500*(int)Math.pow(2, fleetsNotPawned-1);
			//Here due to a chancecard
			if(doubleRent) {
				rent = rent*2;
				doubleRent = false;
			}

			player.getAccount().transfer(rent, f.getOwner().getAccount());
			LandOnFieldBoundary.payOtherPlayer(f.getOwner().getName(), rent);
		}
	}

	/**
	 * Decides what happens when player lands on a tax field.
	 * @param player
	 * @param f
	 */
	public void landOnTax(Player player, Tax f){
		int rent = 0;
		if(f.getPercentange() == 0){
			rent = f.getTax();
			LandOnFieldBoundary.payTax(rent);
			player.getAccount().withdraw(rent);


		}
		else if(f.getPercentange() == 10){
			boolean input = LandOnFieldBoundary.chooseTax();
			if(input) {
				rent = f.getTax();
				player.getAccount().withdraw(rent);

			}
			else if(!input) {
				rent = ((player.getAccount().getBalance()+player.getProperty().totalValueOfAssets())*10)/100;
				player.getAccount().withdraw(rent);
				LandOnFieldBoundary.payTax(rent);

			}
		}
		ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+rent);

	}

	/**
	 * Decides what hapens when a player lands on a parkinglot field.
	 * @param player
	 */
	public void landOnParkingLot(Player player){
		LandOnFieldBoundary.parkingLotMoney(ParkingLot.getTaxMoney());
		player.getAccount().deposit(ParkingLot.getTaxMoney());
		ParkingLot.setTaxMoney(0);
	}

	/**
	 * Decides what happens when player lands on a jail field.
	 * @param player
	 * @param f
	 */
	public void landOnJail(Player player, Jail f){
		LandOnFieldBoundary.displayMessage(0);
	}

	/**
	 * Decides what happens when a player lands on a gotojail field.
	 * @param player
	 * @param f
	 */
	public void landOnGoToJail(Player player, GoToJail f){
		player.setEqualFaceValue(0);
		LandOnFieldBoundary.displayMessage(2);
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
		//		LandOnFieldBoundary.displayMessage(1);
	}

	/**
	 * Draws a chance card and executes it's purpose.
	 * @param player
	 * @param f
	 */
	public void landOnChance(Player player, Chance f){
		LandOnFieldBoundary.displayMessage(3);
		card = cardDeck.draw();
		LandOnFieldBoundary.displayCard(card.getDescription());
		if(card instanceof Bail) {
			//cE.cardEffectBail(player, (Card)card);
		}
		else if(card instanceof GoToJailCard) {
			CardEffectBoundary.youDraw();
			cE.cardEffectGoToJail(player, (GoToJailCard)card);
		}
		else if(card instanceof MovePlayer) {
			CardEffectBoundary.youDraw();
			int posBefore = player.getPlayerPos();
			cE.cardEffectMovePlayer(player, (MovePlayer)card);
			this.doubleRent = cE.isDoubleRent();
			if(posBefore != player.getPlayerPos()) {
				landOnField(player);
			}

		}
		else if(card instanceof TransferMoney) {
			CardEffectBoundary.youDraw();
			cE.cardEffectTransferMoney(player, (TransferMoney)card);
		}


	}


}
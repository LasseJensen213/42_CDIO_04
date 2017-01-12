package card;

import board.Board;
import boundary.CardEffectBoundary;
import desktop_resources.GUI;
import field.Fleet;
import field.ParkingLot;
import player.Player;

public class CardEffect {
	private boolean doubleRent;
	private Board board;
	
	
	public CardEffect()
	{
		doubleRent = false;
		board = Board.Board();
	}
	
	public void cardEffectBail(Player player, Card card){
		player.getProperty().addCard(card);
	}
	
	

	public void cardEffectGoToJail(Player player, GoToJailCard card){
		int before = player.getPlayerPos();
		if(card.equals(Cardgenerator.getCardDeckGenerator(4)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(5))){
			player.setPlayerPos(10);
			player.setJailed(true);
			int distance = (40-before+player.getPlayerPos())%40;
			CardEffectBoundary.moveFigure(player.getName(), before, distance);
		}
		
	}


	/**
	 * Move player card
	 * Move the player to the destination the card says.
	 * 
	 * @param Player
	 * @param MovePlayer
	 */
	public void cardEffectMovePlayer(Player player, MovePlayer card){
		int before = player.getPlayerPos();
		if( card.equals(Cardgenerator.getCardDeckGenerator(33)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(34))){
			player.setPlayerPos(0);
		}

		else if( card.equals(Cardgenerator.getCardDeckGenerator(35))){
			player.setPlayerPos(39);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(36))){
			player.setPlayerPos(32);
		}

		else if( card.equals(Cardgenerator.getCardDeckGenerator(37)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(38))){
			player.setPlayerPos((player.getPlayerPos()+37)%40);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(39))){
			player.setPlayerPos(19);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(40))){
			player.setPlayerPos(24);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(41))){
			player.setPlayerPos(15);
		}
		//Gå til nærmeste fleet
		else if(card.equals(Cardgenerator.getCardDeckGenerator(0)) || card.equals(Cardgenerator.getCardDeckGenerator(1))){
			int pos = player.getPlayerPos();
			for(int i = 0; i<40;i++)
			{
				pos = (pos+1)%40;
				if(board.getField(pos) instanceof Fleet)
				{
					int distance = pos-player.getPlayerPos();
					player.setPlayerPos(pos);
					break;
				}
			}
			doubleRent = true;
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(43))){
			player.setPlayerPos(37);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(44))){
			player.setPlayerPos((player.getPlayerPos()+3)%40);
		}
		if(before > player.getPlayerPos()) {
			player.getAccount().deposit(4000);
		}
		
		CardEffectBoundary.showMessage(2);
		int distance = (40-before+player.getPlayerPos())%40;
		CardEffectBoundary.moveFigure(player.getName(), before, distance);
	}


	/**
	 * Transfer money cards
	 * Withdraw or deposit money from players account. 
	 * 
	 * @param Player
	 * @param TransferMoney
	 */
	public void cardEffectTransferMoney(Player player, TransferMoney card){
		if(card.equals(Cardgenerator.getCardDeckGenerator(11)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(14)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(15)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(16)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(18)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(19)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(20))){
			player.getAccount().deposit(1000);
		}
		
		else if(card.equals(Cardgenerator.getCardDeckGenerator(12)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(13))){
			player.getAccount().deposit(500);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(17))){
			player.getAccount().deposit(200);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(21))){
			player.getAccount().deposit(3000);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(22)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(30))){
			player.getAccount().withdraw(1000);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+1000);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(23))||
				card.equals(Cardgenerator.getCardDeckGenerator(27)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(29))){
			player.getAccount().withdraw(200);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+200);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(24))){
			player.getAccount().withdraw(300);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+300);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(25)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(26))){
			player.getAccount().withdraw(3000);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+3000);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(28))){
			player.getAccount().withdraw(2000);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+2000);
		}
		//Dyr ejendomsskat
		else if(card.equals(Cardgenerator.getCardDeckGenerator(31))) {
			int houses = 0;
			int hotels = 0;
			for(int i = 0; i<player.getProperty().nTerritoriesOwned(); i++) {
				if(player.getProperty().getTerritory(i).getHouse() == 5) {
					hotels++;
				}
				else if(player.getProperty().getTerritory(i).getHouse()<5)
					houses +=player.getProperty().getTerritory(i).getHouse();
			}
			int rent = 800*houses+2300*hotels;
			player.getAccount().withdraw(rent);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+rent);
				
		}
		//Billig ejendomsskat
		else if(card.equals(Cardgenerator.getCardDeckGenerator(32))) {
			int houses = 0;
			int hotels = 0;
			for(int i = 0; i<player.getProperty().nTerritoriesOwned(); i++) {
				if(player.getProperty().getTerritory(i).getHouse() == 5) {
					hotels++;
				}
				else if(player.getProperty().getTerritory(i).getHouse()<5)
					houses +=player.getProperty().getTerritory(i).getHouse();
			}
			int rent = 500*houses+2000*hotels;
			player.getAccount().withdraw(rent);
			ParkingLot.setTaxMoney(ParkingLot.getTaxMoney()+rent);
		}
		//Matador legat
		else if(card.equals(Cardgenerator.getCardDeckGenerator(6))) {
			int totalValue = player.getProperty().totalValueOfAssets()+ player.getAccount().getBalance();
			if(totalValue <= 15000) {
				CardEffectBoundary.showMessage(0);
				player.getAccount().deposit(40000);
			}
			else
				CardEffectBoundary.showMessage(1);
		}
	}

	
	public boolean isDoubleRent() {
		return doubleRent;
	}
	
}

package card;

import boundary.CardEffectBoundary;
import player.Player;

public class CardEffect {
	private boolean doubleRent;
	
	
	
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
			player.setPlayerPos(player.getPlayerPos()+37);
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
			if(player.getPlayerPos()<5){
				player.setPlayerPos(5);
			}
			if(5<=player.getPlayerPos() && player.getPlayerPos()<15){
				player.setPlayerPos(15);
			}
			else if( 15 <= player.getPlayerPos() && player.getPlayerPos()<25){
				player.setPlayerPos(25);
			}
			else if(25 <= player.getPlayerPos() && player.getPlayerPos()<35){
				player.setPlayerPos(35);
			}
			else if(35<=player.getPlayerPos()){
				player.setPlayerPos(5);
			}
			doubleRent = true;
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(43))){
			player.setPlayerPos(37);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(44))){
			player.setPlayerPos(player.getPlayerPos()+3);
		}
		if(before > player.getPlayerPos()) {
			player.getAccount().deposit(4000);
		}
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
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(23))||
				card.equals(Cardgenerator.getCardDeckGenerator(27)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(29))){
			player.getAccount().withdraw(200);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(24))){
			player.getAccount().withdraw(300);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(25)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(26))){
			player.getAccount().withdraw(3000);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(28))){
			player.getAccount().withdraw(2000);
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

package card;

import player.Player;

public class CardEffect {

	public void cardEffectBail(Player player, Card card){

	}

	public void cardEffectGoToJail(Player player, GoToJailCard card){
		if(card.equals(Cardgenerator.getCardDeckGenerator(4)) ||
				card.equals(Cardgenerator.getCardDeckGenerator(5))){
			player.setPlayerPos(10);
			player.setJailed(true);
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
			player.setPlayerPos(player.getPlayerPos()-3);
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

		else if(card.equals(Cardgenerator.getCardDeckGenerator(42))){
			if(player.getPlayerPos()<5){
				player.setPlayerPos(5);
			}
			if(5<=player.getPlayerPos() && player.getPlayerPos()<15){
				player.setPlayerPos(15);
			}
			if( 15 <= player.getPlayerPos() && player.getPlayerPos()<25){
				player.setPlayerPos(25);
			}
			if(25 <= player.getPlayerPos() && player.getPlayerPos()<35){
				player.setPlayerPos(35);
			}
			if(35<=player.getPlayerPos()){
				player.setPlayerPos(5);
			}
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(43))){
			player.setPlayerPos(37);
		}

		else if(card.equals(Cardgenerator.getCardDeckGenerator(44))){
			player.setPlayerPos(player.getPlayerPos()+3);
		}
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
	}

}

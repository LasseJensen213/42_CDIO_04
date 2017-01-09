package card;

import stringbanks.Stringbank_Card;

// initialize cards (45 pieces)
public class Cardgenerator {

	
	public static Card cardDeckGenerator[] = {
			new MovePlayer(Stringbank_Card.getSpecialcard(0)),
			new MovePlayer(Stringbank_Card.getSpecialcard(0)),
			new Bail(Stringbank_Card.getSpecialcard(1)),
			new Bail(Stringbank_Card.getSpecialcard(1)),
			new GoToJail(Stringbank_Card.getSpecialcard(2)),
			new GoToJail(Stringbank_Card.getSpecialcard(2)),
			new TransferMoney(Stringbank_Card.getSpecialcard(3)),
			new TransferMoney(Stringbank_Card.getPlayerPaysPlayerCard(0)),
			new TransferMoney(Stringbank_Card.getPlayerPaysPlayerCard(1)),
			new TransferMoney(Stringbank_Card.getPlayerPaysPlayerCard(2)),
			new TransferMoney(Stringbank_Card.getPlayerPaysPlayerCard(2)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(0)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(1)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(1)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(2)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(3)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(3)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(4)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(5)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(6)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(7)),
			new TransferMoney(Stringbank_Card.getReceiveMoneyCard(8)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(0)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(1)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(2)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(3)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(3)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(4)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(5)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(6)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(7)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(8)),
			new TransferMoney(Stringbank_Card.getPayMoneyCard(9)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(0)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(0)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(1)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(2)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(3)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(3)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(4)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(5)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(6)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(7)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(8)),
			new MovePlayer(Stringbank_Card.getMoveFigureCard(9))
			};
	
	public static void generateCards()
	{
		CardDeck deck = CardDeck.getCD();
		deck.setActiveDeck(cardDeckGenerator);
		deck.shuffle();
	}

	public static Card getCardDeckGenerator(int i) {
		return cardDeckGenerator[i];
	}


	

}
package card;

import java.util.Random;

import board.Board;
import desktop_fields.Field;

public class CardDeck {
		
	//The Active deck is the one you draw cards from,
	//When are card is drawn is will be put on the top of the used deck
	//when there are no more cards in the active deck, it will be swapped with the used deck-
	//and then shuffled
	
	//The cards are intended to be generated in another class and then saved here in the active deck
	private Card[] originalDeck;
	private Card[] activeDeck;
	private Card[] usedDeck;
	
	private static CardDeck INSTANCE;
	
	
	public CardDeck(Card[] cards) {
		originalDeck = new Card[45];
		usedDeck = new Card[0];
		activeDeck = cards;
	}
	
	public CardDeck()
	{
		usedDeck = new Card[0];
	}
	
	public static CardDeck CardDeck() {
		if(INSTANCE == null) 
			INSTANCE = new CardDeck();
		return INSTANCE;
	}
	
	/**
	 * Draws the card at the top of the active deck, <br>
	 * if there are no more cards in the active deck <br>
	 * then it will be swapped with the used deck and shuffled<br> 
	 * @return
	 * Card
	 */
	public Card draw()
	{
		
		if(activeDeck.length==0)
		{
			activeDeck = usedDeck;
			usedDeck = new Card[0];
			shuffle();
			
		}
		//Checks again if the active decks length is still 0, 
		//which would mean that no cards have been generated yet
		if(activeDeck.length==0)
		{
			return new Card("");
		}
		Card cardDrawn = activeDeck[0];
		
		addToUsedDeck(cardDrawn);
		removeTopCard();
		if(cardDrawn instanceof Bail && ((Bail)cardDrawn).isInUse())
			cardDrawn = draw();
			
		return cardDrawn;
	}
	
	/**
	 * Shuffles the active deck by swapping two cards in the deck at random 500.000 times
	 */
	public void shuffle()
	{
		Random rand = new Random();
		int index1;
		int index2;
		for(int i = 0; i<500000;i++)
		{
			index1 = rand.nextInt(activeDeck.length);
			index2 = rand.nextInt(activeDeck.length);
			Card tempCard = activeDeck[index1];
			activeDeck[index1] = activeDeck[index2];
			activeDeck[index2]=tempCard;
		}
		
	}
	/**
	 * Adds a card to the top of the used card deck
	 * @param usedCard
	 */
	public void addToUsedDeck(Card card)
	{
		Card[] newUsedDeck = new Card[usedDeck.length+1];
		newUsedDeck[0] = card;
		for(int i = 1; i<newUsedDeck.length;i++)
		{
			newUsedDeck[i]=usedDeck[i-1];
		}
		usedDeck = newUsedDeck;
	}
	
	
	public Card[] getUsedDeck()
	{
		return usedDeck;
	}
	
	public void setUsedDeck(Card[] usedDeck)
	{
		this.usedDeck = usedDeck; 
	}
	public Card[] getActiveDeck()
	{
		return activeDeck;
	}
	
	public void setActiveDeck(Card[] newDeck)
	{
		activeDeck = newDeck;
	}
	
	public void setOriginalDeck(Card[] originalDeck) {
		this.originalDeck = originalDeck;
	}
	
	public Card[] getOriginalDeck() {
		return originalDeck;
	}
	/**
	 * removes the card that's on the top of the active deck
	 * 
	 */
	public void removeTopCard()
	{
		if(activeDeck.length==0)
		{		
		}
		else
		{
			Card[] newActiveDeck = new Card[activeDeck.length-1];
			for(int i = 0;i<newActiveDeck.length;i++)
			{
				newActiveDeck[i]=activeDeck[i+1];
			}
			activeDeck = newActiveDeck;
		}
	}
	
	public static CardDeck getCD()
	{
		if(INSTANCE==null)
			INSTANCE = new CardDeck();
		return INSTANCE;
	}
	
	
}

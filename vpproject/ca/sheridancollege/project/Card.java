package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 * 
 * @author dancye
 */
public abstract class Card {

	public String[] SUITS = {"Heart", "Diamonds", "Spades", "Clubs"};

	/**
	 * 
	 * @param value
	 * @param suit
	 */
	public Card(Value value, Suit suit) {
		// TODO - implement Card.Card
		throw new UnsupportedOperationException();
	}


	public enum Suit {
		HEARTS,
		CLUBS,
		SPADES,
		DIAMONDS
	}


	public enum Value {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVE,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
	}

}
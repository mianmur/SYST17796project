package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 * 
 * @author dancye
 * @modifier xHLenx
 */
public class Card {
    private Suit suit;
    private Value value;
    /**
    * 
    * @param value
    * @param suit
    */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Suit getSuit(){ return this.suit; }
    public Value getValue(){ return this.value; }
    
    @Override
    public String toString(){
        return " " + value + " of " + suit + " ";
    }
}
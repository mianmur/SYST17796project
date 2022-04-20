package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/*
 * @author xHLenx
 *
 */

// class that represents a deck
public class Deck {
    private int size;
    // store all the cards into mainDeck
    public ArrayList<Card> mainDeck;
    
    
    public Deck(int size){
        this.mainDeck = new ArrayList<>();
        this.size = size;
        generateCards();
        shuffle();
    }
    
    private void shuffle(){ Collections.shuffle(mainDeck); }
    
    private void generateCards(){
        // 4 is the number of suits
        for (int i = 0; i < size/4; i++) {
            // 13 is the number of values
            for (int j = 0; j < size/13; j++) {
                mainDeck.add(new Card(Suit.values()[j], Value.values()[i]) );
            }
        }
    }
    
    // return the last card in mainDeck
    public Card drawCard(){
        Card temp = mainDeck.get(mainDeck.size() - 1);
        mainDeck.remove( mainDeck.size() - 1 );
        size--;
        return temp;
    }
    
    public int getSize(){ return size; }
}

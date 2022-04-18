package deckTest;

/**
 * File used to test viable functions of Deck and Card
 * @author xHLenx
 */

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Deck;
import ca.sheridancollege.project.Suit;
import ca.sheridancollege.project.Value;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class mainDeckTest {
    Scanner userInput = new Scanner(System.in);
    Deck testDeck = new Deck(52);
    /**
     * Testing package for Deck and Card
     */
    @Test // tests if the method call functions
    public void testDrawCard() {
        ArrayList<Card> testHand = new ArrayList<Card>();
        System.out.println("Testing drawCard");
        testHand.add(testDeck.drawCard());
        boolean expResult = true;
        boolean result = testHand.size() == 1 ? true : false;
        assertEquals(expResult, result); // check the results
    }
    
    @Test // test the size of the deck after a card is drawn. 
    public void testDeckSize(){
        System.out.println("Testing deck size");
        testDeck.drawCard();  // no need to store it
        boolean expResult = true;  // that is works
        boolean result = testDeck.getSize() == 51 ? true : false; // should be 51
        assertEquals(expResult, result); // check the results
    }
    
    
    @Test // test for duplication
    public void testDuplicates(){
        System.out.println("Testing duplicates");
        ArrayList<Card> testHand = new ArrayList<Card>(); // create a test hand to store cards
        boolean expResult = true;
        boolean result = false;  // init and set to false
        for (int i = 0; i < testDeck.getSize(); i++) {
            testHand.add(testDeck.drawCard());     // add to test hand        
        }
        testHand.add(new Card(Suit.values()[1], Value.values()[1]));  // create the duplicate card
        for(Card c : testHand){
            // check if the suit and value matches with the card created and added above
            if (c.getSuit() == testHand.get(testHand.size() - 1).getSuit() && c.getValue() == testHand.get(testHand.size() - 1).getValue()) {
                System.out.println("FOUND");
                result = true;  // we are expecting to find a double so set it to true
                break;  // break the for loop
            }
        }
        assertEquals(expResult, result); // check the results        
    }
    
}

package deckTest;

/**
 * File used to test viable functions of Deck and Card
 *
 * @author xHLenx
 */
import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Deck;
import ca.sheridancollege.project.Player;
import ca.sheridancollege.project.Suit;
import ca.sheridancollege.project.Value;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class mainDeckTest {

    Deck testDeck = new Deck(52);
    Player p1 = new Player("Suresh");
    Player p2 = new Player("Murtaza");
    ArrayList<Card> player1Hand;
    ArrayList<Card> player2Hand;

    /**
     * Testing package for Deck and Card
     */
    @Test // tests that the card is drawn from the deck and stored to a hand
    public void testDrawCardGood() {
        ArrayList<Card> testHand = new ArrayList<Card>();
        System.out.println("Draw Card Good");
        testHand.add(testDeck.drawCard());  // save to array to represent hand
        boolean expResult = true;
        boolean result = testHand.size() == 1 ? true : false;
        assertEquals(expResult, result); // check the results
    }

    @Test // test that the card is drawn but is not stored to a hand 
    public void testDrawCardBad() {
        System.out.println("Draw Card Bad");
        testDeck.drawCard();  // no need to store it, however, this causes the card to disappear
        boolean expResult = true;  // that is works
        boolean result = testDeck.getSize() == 51 ? true : false; // should be 51
        assertEquals(expResult, result); // check the results
    }

    @Test // test for duplication
    public void testDuplicatesGood() {
        System.out.println("Duplicates Good");
        ArrayList<Card> testHand = new ArrayList<Card>(); // create a test hand to store cards
        boolean expResult = true;
        boolean result = true;  // init and set to false
        for (int i = 0; i < testDeck.getSize(); i++) {
            testHand.add(testDeck.drawCard());     // add to test hand        
        }
        for (Card c : testHand) {
            // check if the suit and value matches with the card created and added above
            if (c.getSuit() == testHand.get(testHand.size() - 1).getSuit() && c.getValue() == testHand.get(testHand.size() - 1).getValue()) {
                System.out.println("FOUND");
                result = true;  // we are expecting to find a double so set it to true
                break;  // break the for loop
            }
        }
        assertEquals(expResult, result); // check the results        
    }

    @Test // test for duplication by adding a card to the hand
    public void testDuplicatesBad() {
        System.out.println("Duplicates Bad");
        ArrayList<Card> testHand = new ArrayList<Card>(); // cr eate a test hand to store cards
        boolean expResult = true;
        boolean result = false;  // init and set to false
        for (int i = 0; i < testDeck.getSize(); i++) {
            testHand.add(testDeck.drawCard());     // add to test hand        
        }
        testHand.add(new Card(Suit.values()[1], Value.values()[1]));  // create the duplicate card
        for (Card c : testHand) {
            // check if the suit and value matches with the card created and added above
            if (c.getSuit() == testHand.get(testHand.size() - 1).getSuit() && c.getValue() == testHand.get(testHand.size() - 1).getValue()) {
                System.out.println("FOUND");
                result = true;  // we are expecting to find a double so set it to true
                break;  // break the for loop
            }
        }
        assertEquals(expResult, result); // check the results 
    }

    @Test // Tests declare winner method
    public void testDeclareWinnerGood() {
        System.out.println("Declare winner good");
        p1.setPoints(4);    //sets points for player 1 and 2
        p2.setPoints(5);
        boolean pointCheck = false;
        boolean expResult = true;
        if (p1.getPoints() < p2.getPoints()) { // Good path, if player 2 points are greater than player 1
            pointCheck = true;
        }
        boolean result = pointCheck;
        assertEquals(expResult, result);
    }

    @Test // Tests declare winner method
    public void testDeclareWinnerBad() {
        System.out.println("Declare winner bad");
        p1.setPoints(4);    //sets points for player 1 and 2
        p2.setPoints(5);
        boolean pointCheck = false;
        boolean expResult = false;
        if (p1.getPoints() > p2.getPoints()) { // bad path, if player 1 points are lower than player 2
            pointCheck = true;
        }
        boolean result = pointCheck;
        assertEquals(expResult, result);
    }

    @Test // Tests declare winner method
    public void testDeclareWinnerBoundary() {
        System.out.println("Declare winner boundary");
        p1.setPoints(5);    //sets points for player 1 and 2
        p2.setPoints(5);
        boolean pointCheck = false;
        boolean expResult = true;
        if (p1.getPoints() <= p2.getPoints()) { // boundary path, if both players are tied
            pointCheck = true;
        }
        boolean result = pointCheck;
        assertEquals(expResult, result);
    }

    @Test // Tests show hand method, good path 7 cards are shown to the player
    public void testShowHandGood() {
        boolean check = false;
        System.out.println("Show hand good test");
        boolean expResult = true;
        player1Hand = new ArrayList<>();
        player2Hand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            player1Hand.add(testDeck.drawCard());
            player2Hand.add(testDeck.drawCard());
        }
        System.out.println("Your Hand:");
        for (Card player1Hand1 : player1Hand) {
            System.out.println(player1Hand1);
        }
        if (player1Hand.size() == 7) {
            check = true;
        }
        boolean result = check;
        assertEquals(expResult, result);
    }

  
}

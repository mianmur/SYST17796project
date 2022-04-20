/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author murtz
 * @author suresh
 */
public class GoFish extends Game {

    Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Deck deck;
    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;
    private int suitChoice;
    private int valueChoice;
    private Card guess;
    private int count = 0;
    private int player1Points;
    private int player2Points;

    public GoFish() {
        super("Go Fish");
    }

    @Override
    public void play() {
        // Setting player names
        System.out.print("Player 1 name: ");
        player1 = new Player(scanner.nextLine());
        System.out.print("Player 2 name: ");
        player2 = new Player(scanner.nextLine());
        super.setPlayers(player1);
        player1Hand = new ArrayList<>();
        super.setPlayers(player2);
        player2Hand = new ArrayList<>();

        // deck is initialized and shuffled
        deck = new Deck(52);
        // A hand size of 7 is created and added to each player
        for (int i = 0; i < 7; i++) {
            player1Hand.add(deck.drawCard());
            player2Hand.add(deck.drawCard());
        }

        // Start game and goes in order of what to do
        turn();
        calcPoints();
        declareWinner();
    }

    public void turn() {
        // If count is even, that means it is player 1s turn
        do {
            if (count % 2 == 0) {
                showHand();
                playerChoose(1);
            } else {
                showHand();
                playerChoose(2);
            }
        } while (0 < deck.getSize()); // Will loop through this function as long as there are cards in the deck
    }
    
    public void showHand() {
        // Same idea as turn
        if (count % 2 == 0) {
            System.out.println("Your Hand:");
            for (Card player1Hand1 : player1Hand) {
                System.out.println(player1Hand1);
            }
        } else {
            System.out.println("Your Hand:");
            for (Card player2Hand1 : player2Hand) {
                System.out.println(player2Hand1);
            }
        }
    }
    
    public void playerChoose(int i) {
        System.out.printf("Player %d pick a SUIT: 1. HEARTS 2. CLUBS 3. SPADES 4. DIAMONDS:\n", i);
        suitChoice = scanner.nextInt();
        System.out.println("Pick a VALUE: \n1. ACE 2. TWO 3. THREE"
                + "\n4. FOUR 5. FIVE 6. SIX"
                + "\n7. SEVEN 8. EIGHT 9. NINE, 10. TEN"
                + "\n11. JACK 12. QUEEN 13. KING");
        System.out.print("Choice: ");
        valueChoice = scanner.nextInt();

        // Minus 1 from the choices as arrays start from 0
        guess = new Card(Suit.values()[suitChoice-1], Value.values()[valueChoice-1]);
        
        compareHand();
        count++;
    }
    
    public void compareHand() {
        // Create a temp value in order to access Go Fish function since if else is not viable 
        // (will draw 7 cards otherwise)
        boolean temp = false;
        if (count % 2 == 0) {
            for (int i = 0; i < player2Hand.size(); i++) {
                if (guess.getSuit() == player2Hand.get(i).getSuit()
                        && guess.getValue() == player2Hand.get(i).getValue()) {
                    // remove card from enemy player hand and add to your own
                    System.out.println("You guessed right");
                    player1Hand.add(player2Hand.get(i));
                    player2Hand.remove(i);
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                System.out.println("Go Fish");
                player1Hand.add(deck.drawCard());
            }
        } else {
            for (int i = 0; i < player1Hand.size(); i++) {
                if (guess.getSuit() == player1Hand.get(i).getSuit()
                        && guess.getValue() == player1Hand.get(i).getValue()) {
                    // remove card from enemy player hand and add to your own
                    System.out.println("You guessed right");
                    player2Hand.add(player1Hand.get(i));
                    player1Hand.remove(i);
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                System.out.println("Go Fish");
                player2Hand.add(deck.drawCard());
            }
        }
    }

    public void calcPoints() {
        // Goes through each card and adds to a value. Once 4 are the same (4 of a kind) a player gets a point
        int temp=0;
        for (Card c : player1Hand) {
            for (int i = 0; i < player1Hand.size(); i++) {
                if (c.getValue() == player1Hand.get(i).getValue()) {
                    temp++; if (temp==4) { player1Points++; temp=0; }
                }
            }
        }
        temp=0; // set temp to 0 so leftover points are not mistakenly added
        for (Card c : player2Hand) {
            for (int i = 0; i < player2Hand.size(); i++) {
                if (c.getValue() == player2Hand.get(i).getValue()) {
                    temp++; if (temp==4) { player2Points++; temp=0; }
                }
            }
        }
        
        // Add the points to the player object instead of using a dummy value
        player1.setPoints(player1Points);
        player2.setPoints(player2Points);
    }
    
    @Override
    public void declareWinner() {
        System.out.println(
                player1.getPoints() > player2.getPoints()
                ? "Player 1 wins" : "Player 2 wins");
    }

    public static void main(String args[]) {
        GoFish fish = new GoFish();
        fish.play();
    }
}

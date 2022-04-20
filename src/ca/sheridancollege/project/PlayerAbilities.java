/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author murtz
 */
public interface PlayerAbilities {
    void addScore();
    void endTurn();
    void askFor(Card card);
    String checkHand();
    int checkScore();
    void promptPlayer();
}


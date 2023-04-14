/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 9am
 * Date: 4/7/2023
 * Time: 9:32 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: Game
 *
 * Description:
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

import java.util.Scanner;

public class Game {

    /**
     * User has begun the game
     */
    public void start() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scnr.nextLine().strip();
        // Generate player
        Player player1 = new User(name, 200);
        Dealer dealer = new Dealer();

    }

    public void end() {
        //TODO
    }

    /**
     * The hand gets an additional card
     */
    public void hit() {
        //Todo
    }

    /**
     * If the player's hand has both cards of equal rank, the player is offered
     * a split. The player accepts by creating an additional Bet. The original
     * hand is removed; The two original cards are split and the dealer deals
     * two extra cards to create two new Hands. There will not be any further splitting.
     */
    public void split() {
        //Todo
    }

    /**
     * The player chooses to not receive another card and closes the hand
     */
    public void stand() {
        //Todo
    }

}

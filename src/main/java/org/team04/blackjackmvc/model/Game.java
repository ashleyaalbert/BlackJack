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
     * User to play game
     */
    private User player;
    /**
     * Dealer for game
     */
    private Dealer dealer;
    /**
     * Deck to be used
     */
    private Deck deck;
    /**
     * Number of 52 deck cards in shoe
     */
    private final int nBox = 4;
    /**
     * Initial funds for user to start with
     */
    private final double initFunds = 200;
    private GameState state;

    public void playBlackJack() {
        state = GameState.START_GAME;
        if (state == GameState.START_GAME) {
            start();
        }
        while (state != GameState.END_GAME) {
            if (state == GameState.IN_GAME) {
                if ()
            }
        }


    }

    /**
     * User has begun the game
     */
    public void start() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scnr.nextLine().strip();
        // Generate player
        player = new User(name, initFunds);
        dealer = new Dealer();
        deck = new Deck(nBox);
        state = GameState.IN_GAME;
    }

    public void playHand() {
        if (player.getMoney()>0) {

        }
    }

    public void end() {
        //TODO
    }


}

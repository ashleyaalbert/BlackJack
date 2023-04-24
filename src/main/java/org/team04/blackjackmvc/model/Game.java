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
    private final double initFunds = 500;
    /**
     * Current state of the game
     */
    private GameState state;

    /**
     * Generate scanner for user prompts
     */
    private Scanner scnr;


    public void playBlackJack() {
        state = GameState.START_GAME;
        if (state == GameState.START_GAME) {
            start();
        }
        while (state != GameState.END_GAME && player.getMoney() >0) {
            if (state == GameState.IN_GAME) {
                placeBet();
            }
            else if (state==GameState.PLAY_HAND) {
                dealHand();
            }

        }
        if (state == GameState.END_GAME || player.getMoney() ==0) {
            end();
        }

    }

    /**
     * User has begun the game
     */
    private void start() {
        scnr = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scnr.nextLine().strip();
        // Generate player, dealer, and deck
        player = new User(name, initFunds);
        dealer = new Dealer();
        deck = new Deck(nBox);
        state = GameState.IN_GAME;
    }

    /**
     * User can either place bet or end game. If bet exceeds available funds
     * then InsufficientFundsException is thrown.
     */
    private void placeBet() {
        if (player.getMoney()>0) {
            System.out.println("Bet amount ($" + player.getMoney() + " remaining) or 0 to end game: ");
            Double bet = scnr.nextDouble();
            if (bet==0) {
                state = GameState.END_GAME;
            }
            else {
                try {
                    player.placeBet(bet);
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Deal cards to user and dealer and reshuffle and reset deck if out of cards. Dealer's second card
     * is not yet visible
     */
    private void dealHand() {
        player.dealCard(deck.drawCard());
        dealer.dealCardVisible(deck.drawCard());
        player.dealCard(deck.drawCard());
        dealer.dealCardInvisible(deck.drawCard());
    }

    /**
     * End game and report earnings or losses to user
     */
    private void end() {
        if (player.getMoney() ==0) {
            System.out.println("Out of money! Game over.");
        }
        else {
            Double earnings = player.getMoney() - initFunds;
            if (earnings>=0) {
                System.out.printf("Final balance: $.2f, You won: $.2f", player.getMoney(), earnings);
            }
            else {
                earnings = earnings *-1;
                System.out.printf("Final balance: $.2f, You lost: $.2f", player.getMoney(), earnings);
            }
        }
    }

    private void playerStand() {

    }

    /**
     * Player hits and gets new card
     */
    private void playerHit() {
        player.dealCard(deck.drawCard());
    }








}

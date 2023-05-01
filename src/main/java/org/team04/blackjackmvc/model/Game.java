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
 * Description: Class that creates a basic game object. A game entails
 * the game of blackjack. The game has a player and dealer, each with cards.
 * The game controls the flow of actions.
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

import java.util.Scanner;

//import static org.team04.blackjackmvc.BlackJackLoginController.name;

/**
 * A game class for the card game blackjack that controls the gameflow and objects involved in the game
 */
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
     * The win state of the user in the current hand
     */
    public WinState win;

    /**
     * Create a new game object with a new player, dealer, deck, and
     * set the current user win state to null
     *
     * @param name of the user
     */
    public Game(String name) {
        player = new User(name, initFunds);
        dealer = new Dealer();
        deck = new Deck(nBox);
        win = WinState.NULL;
        System.out.println("New game");
    }

    /**
     * Game is reset. User and dealer hands are reset to no cards.
     */
    public void reset() {
        win = WinState.NULL;
        player.clearHand();
        dealer.clearHand();
    }


    /**
     * User can either place bet or end game. If bet exceeds available funds
     * then InsufficientFundsException is thrown.
     */
    public void placeBet(Double bet) {
        if (player.getMoney()>0) {
            System.out.println(bet);
            try {
                player.placeBet(bet);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Deal cards to user and dealer and reshuffle and reset deck if out of cards. Dealer's second card
     * is not yet visible
     */
    public void dealHand() {
        player.dealCard(deck.drawCard());
        dealer.dealCardVisible(deck.drawCard());
        player.dealCard(deck.drawCard());
        dealer.dealCardInvisible(deck.drawCard());
    }


    /**
     * Player stands and dealer plays. Dealer hits until hand total is greater than 16
     */
    public void playerStand() {
        dealer.makeCardsVisible();
        while (dealer.getBest() <=16) {
            dealer.dealCardVisible(deck.drawCard());
        }
    }

    /**
     * Player hits and gets new card
     */
    public void playerHit() {
        player.dealCard(deck.drawCard());
    }

    /**
     * Evaluate if player wins, loses, pushes, or has blackjack
     */
    public void evaluateHands() {
        System.out.println(getDealerHand());
       int playerTotal = player.getBest();
       int dealerTotal = dealer.getBest();

       // Check if player busts
       if (playerTotal > 21) {
           this.win = WinState.BUST;
       }

       // Check for user blackjack. Push if dealer also blackjack. Blackjack if not
       else if (playerTotal == -1) {
           if (dealerTotal == -1) {
               this.win = WinState.PUSH;
           }
           else {
               this.win = WinState.BLACKJACK;
           }
       }

       // Check if dealer busts
       else if (dealerTotal > 21) {
           this.win = WinState.WIN;
       }

       // Check who has higher score
       else if (playerTotal > dealerTotal) {
           this.win = WinState.WIN;
       }

       else if (playerTotal < dealerTotal) {
           this.win = WinState.LOSS;
       }

       // Player and dealer have same score...push
       else {
           this.win = WinState.PUSH;
       }
   }

   public WinState getWin() {
        return this.win;
   }

    /**
     * Handle the movement of user money depending on whether they win, lose, bust, or blackjack
     */
   public void handleWinner() {
        player.handleMoney(this.win);
   }

   public Hand getDealerHand() {
        return dealer.getHand();
   }

    public Hand getPlayerHand() {
        return player.getHand();
    }

    public int getPlayerTotal() {
        return player.getBest();
    }

    public int getDealerTotal() {
        return dealer.getBest();
    }

    public double getPlayerMoney() {
        return player.getMoney();
    }

}


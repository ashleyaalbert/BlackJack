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

import org.team04.blackjackmvc.BlackJackPlayController;

import java.util.Scanner;

//import static org.team04.blackjackmvc.BlackJackLoginController.name;
import static org.team04.blackjackmvc.BlackJackPlayController.playerBet;


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

    /**
     * Stores the bet value from the user
     */
    public static double bet;

    /**
     * The win state of the user in the current hand
     */
    public WinState win;

    public Game(String name) {
        player = new User(name, initFunds);
        dealer = new Dealer();
        deck = new Deck(nBox);
        state = GameState.IN_GAME;
        win = WinState.NULL;
        System.out.println("New game");
    }


    /**
     * User can either place bet or end game. If bet exceeds available funds
     * then InsufficientFundsException is thrown.
     */
    public void placeBet(Double bet) {
        if (player.getMoney()>0) {
            System.out.println(bet);
            if (bet == 0) {
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
    public void dealHand() {
        this.win = WinState.NULL;
        player.dealCard(deck.drawCard());
        dealer.dealCardVisible(deck.drawCard());
        player.dealCard(deck.drawCard());
        dealer.dealCardInvisible(deck.drawCard());
        System.out.println(player.getHand());
        System.out.println(dealer.getHand());
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

    /**
     * Player stands and dealer plays. Dealer hits until hand total is greater than 16
     */
    public void playerStand() {
        dealer.makeCardsVisible();
        while (dealer.getBest() <=16) {
            dealer.dealCardVisible(deck.drawCard());
        }
        state = GameState.EVALUATE_HANDS;
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
       int playerTotal = player.getBest();
       int dealerTotal = dealer.getBest();

       // Check if player busts
       if (playerTotal > 21) {
           this.win = WinState.LOSS;
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

   public void handleWinner() {

   }

   public Hand getDealerHand() {
        return dealer.getHand();
   }

    public Hand getPlayerHand() {
        return player.getHand();
    }

}


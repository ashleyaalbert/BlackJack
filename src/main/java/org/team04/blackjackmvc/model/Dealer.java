/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Section: 9am
 * Date: 4/8/2023
 * Time: 11:36 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: Dealer
 *
 * Description: A dealer object for the blackjack game. Dealer
 * has a hand of cards that they use to play against the user
 *
 * ****************************************
 */

package org.team04.blackjackmvc.model;

/**
 * A dealer object for the game of blackjack that has a hand to play the user
 */
public class Dealer{
    /**
     * The dealer hand to be used
     */
    private Hand dealerHand;

    /**
     * Dealer is created with new empty hand
     */
    public Dealer() {
        this.dealerHand = new Hand();
    }

    /**
     * Make card visible and add it to the dealer hand
     * @param card
     */
    public void dealCardVisible(Card card) {
        card.setVisibility(true);
        this.dealerHand.add(card);
    }

    /**
     * Add card that is not yet visible to dealer hand
     * @param card
     */
    public void dealCardInvisible(Card card) {
        this.dealerHand.add(card);
    }

    /**
     * Make all dealer cards visible
     */
    public void makeCardsVisible() {
        this.dealerHand.makeVisible();
    }

    /**
     * @return the best possible score of the user hand (-1 is a blackjack)
     */
    public int getBest() {
        return dealerHand.best();
    }

    /**
     * Clear dealer hand
     */
    public void clearHand() {
        this.dealerHand.clear();
    }

    public Hand getHand() {
        return this.dealerHand;
    }


}


/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Section: 9am
 * Date: 4/8/2023
 * Time: 11:35 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: Hand
 *
 * Description: A class representing the hand of cards
 * and the current best total held by the player
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.team04.blackjackmvc.model.Card.Rank.ACE;

/**
 * A hand of cards held by the player with the current best value represented by the cards
 */
public class Hand {

    /**
     * The cards currently in the hand
     */
    private LinkedList<Card> cardList;


    /**
     * Number of aces in the hand
     */
    private int aces;

    /**
     * Number of cards in the current hand
     */
    private int size;

    /**
     * Construct a new empty hand
     */
    public Hand() {
        this.cardList = new LinkedList<Card>();
        this.aces = 0;
        this.size = 0;
    }

    /**
     * Add {@param card} to the hand
     */
    public void add(Card card) {
        this.cardList.add(card);
        this.size +=1;
        if (card.rank().equals(ACE)) {
            this.aces +=1;
        }
    }

    /**
     * Clear the hand
     */
    public void clear() {
        this.size = 0;
        this.aces=0;
        this.cardList.clear();
    }

    /**
     * @return totals, a list of the possible total counts of the hand
     */
    public List<Integer> getTotals() {
        List<Integer> totals = new ArrayList<Integer>();
        totals.add(0);
        for (Card c : this.cardList) {
            int size1 = totals.size();
            for(int i=0; i<size1; i++) {
                int val = totals.get(i);
                totals.set(i, val+c.value());
                if(c.value() ==1) {
                    totals.add(val+11);
                }
            }
        }
        return totals;
    }

    /**
     * @return the best possible score in the hand, which is the highest value less than 21.
     * A return of -1 is a blackjack
     */
    public int best() {
        List<Integer> totals = new ArrayList<Integer>();
        totals = this.getTotals();
        int bestScore = 0;
        for (int score: totals) {
            if (score > bestScore && score <= 21) {
                bestScore = score;
            }
        }
        if (bestScore == 0) {
            for (int score: totals) {
                if (score>bestScore) {
                    bestScore = score;
                }
            }
        }
        if (bestScore==21 && this.size==2 && this.aces==1) {
            return -1;
        }
        else {
            return bestScore;
        }
    }

    /**
     * Make all cards visible
     */
    public void makeVisible() {
        for(Card c : this.cardList)
        {
            if (c.getVisibility() == false) {
                c.setVisibility(true);
            }
        }
    }

    /**
     * Get the size of the hand.
     *
     * @return How many cards are in the hand.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return a String of all the cards in the hand
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        for(Card c : this.cardList)
        {
            if(i != this.cardList.size() - 1)
                if (c.getVisibility()) {
                    sb.append(c+", ");
                }
                else {
                    sb.append("__, ");
                }
            else
            if (c.getVisibility()) {
                sb.append(c);
            }
            else {
                sb.append("__");
            }
            i++;
        }
        return sb.append(']').toString();
    }

    /**
     * Code from https://github.com/nalabrie/Blackjack/blob/master/src/Blackjack/Hand.java
     * Get a card from the hand by its index.
     *
     * @param index The index of the card to be returned, starting at 0.
     * @return The card object at the given index.
     * @throws HandIndexOutOfBoundsException When the index is below 0 or greater than hand size - 1.
     */
    public Card getCard(int index) {
        // check the index is in the bounds of the hand
        if (index < 0 || index >= this.size) {
            throw new HandIndexOutOfBoundsException();
        }

        return this.cardList.get(index);
    }

    public LinkedList<Card> getCardList() {
        return this.cardList;
    }

    public int getAces() {
        return this.aces;
    }

}


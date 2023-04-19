/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
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
        if (card.rank().equals("ACE")) {
            this.aces +=1;
        }
    }

    /**
     * Clear the hand
     */
    public void clear() {
        this.cardList.clear();
    }

    /**
     * @return totals, a list of the possible total counts of the hand
     */
    public List<Integer> getTotals() {
        List<Integer> totals = new ArrayList<Integer>();
        totals.add(0);
        for (Card c : this.cardList) {
            int size = totals.size();
            for(int i=0; i<size; i++) {
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
     * A return of 22 is a blackjack
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
            return 22;
        }
        else {
            return bestScore;
        }
    }

    public List<Card> getCardList() {
        return this.cardList;
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





}
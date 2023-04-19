/* **********************************************
 * CSCI 205 - Software Engineering and Design
 * Sprint 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 01 - 9am
 * Date: 4/4/23
 * Time: 7:34 PM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: Deck
 *
 * Description: A class representing a deck of a specified
 * number of playing cards decks to be used in a game of
 * blackjack
 *
 * **********************************************
 */

package org.team04.blackjackmvc.model;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    /**
     * Cards in the deck
     */
    private LinkedList<Card> cards = new LinkedList<Card>();
    /**
     * Cards taken from the deck
     */
    private LinkedList<Card> takenCards = new LinkedList<Card>();

    public LinkedList<Card> getCards() {
        return cards;
    }
    public LinkedList<Card> getTakenCards() {
        return takenCards;
    }


    /**
     * Create a new deck of the given number of decks of 52 cards
     *
     * @param nBox - the number of 52 card decks in the deck
     */
    public Deck(int nBox) {
        for (int i=0; i<nBox; i++) {
            for (Card.Suit suit: Card.Suit.values()) {
                for (Card.Rank rank: Card.Rank.values()) {
                    cards.add(new Card(suit,rank));
                }
            }
        }
        Collections.shuffle(cards);
    }

    /**
     * Add all cards taken back into the deck
     */
    public void reset() {
        cards.addAll(takenCards);
        takenCards.clear();
    }

    /**
     * Shuffle cards in deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the first card drawn from the deck
     * @throws EmptyDeckException if there are no cards left in the deck
     */
    public Card drawCard() throws EmptyDeckException {
        if (cards.isEmpty()) {
            throw new EmptyDeckException("The deck is empty!");
        }
        else {
            Card drawn = cards.pollFirst();
            takenCards.add(drawn);

            return drawn;
        }

    }

    /**
     * @return a String of all the cards remaining in the deck
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        for(Card c : this.cards)
        {
            if(i != this.cards.size() - 1)
                sb.append(c+", ");
            else
                sb.append(c);
            i++;
        }
        return sb.append(']').toString();
    }

    /**
     * @return true if the shoe has cards remaining
     */
    public boolean hasCards() {
        return this.cards.size()>0;
    }

}

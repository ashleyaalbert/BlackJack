/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: King
 * Section: 9am
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Date: 4/7/2023
 *
 * Final Project: Black jack
 *
 * Description: Tests for Deck class
 *
 * *****************************************/

package org.team04.blackjackmvc.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeckTest {

    /**
     * Number of decks to use
     */
    private int nDecks = 4;

    /**
     * A common deck object to use for all tests
     */
    private Deck deck;

    /**
     * Set up a deck of 4 decks to use before each test
     */
    @BeforeEach
    void setUp() {
        this.deck = new Deck(nDecks);
    }

    /**
     * Test that the deck of cards handles resetting to a full deck
     */
    @Test
    @DisplayName("reset() - reset deck of cards")
    void reset() throws EmptyDeckException {
        //Verify that the size of the deck is as expected
        assertEquals(this.deck.getCards().size(),208);

        //Draw 10 cards from the deck
        for (int i=0; i<10; i++) {
            this.deck.drawCard();
        }

        //Check that the deck has had 10 cards removed
        assertEquals(this.deck.getCards().size(),198);

        //Reset the deck
        this.deck.reset();

        //Check that the size of the deck and taken cards has been reset
        assertEquals(this.deck.getCards().size(),208);
        assertEquals(this.deck.getTakenCards().size(),0);

    }

    @Test
    void shuffle() {
        LinkedList<Card> deck2 = new LinkedList<Card>();
        for (int i=0; i<4; i++) {
            for (Card.Suit suit: Card.Suit.values()) {
                for (Card.Rank rank: Card.Rank.values()) {
                    deck2.add(new Card(suit,rank));
                }
            }
        }

        //Check that the deck does not equal an unshuffled deck
        assertNotEquals(this.deck.getCards(), deck2);

        // Create list that is a copy of the current deck before shuffling
        LinkedList<Card> deck3 = new LinkedList<Card>();
        for (Card card: this.deck.getCards()) {
            deck3.add(card);
        }

        this.deck.shuffle();

        // Check that the deck is not the same after shuffling
        assertNotEquals(this.deck.getCards(), deck3);

    }

}
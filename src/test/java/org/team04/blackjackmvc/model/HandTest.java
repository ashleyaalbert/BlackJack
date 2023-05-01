package org.team04.blackjackmvc.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.team04.blackjackmvc.model.Card.Rank.*;
import static org.team04.blackjackmvc.model.Card.Suit.HEARTS;

class HandTest {

    /**
     * A common deck object to use for all tests
     */
    private Deck deck;

    /**
     * A common hand object to use for all tests
     */
    private Hand hand;

    /**
     * Number of decks to use
     */
    private int nDecks = 4;
    @BeforeEach
    void setUp() {
        this.deck = new Deck(nDecks);
        this.hand = new Hand();
    }

    @AfterEach
    void tearDown() {

    }

    /**
     * Test that a card is added to the hand properly
     */
    @Test
    @DisplayName("add(Card card) - add card to the hand")
    void add() {
        //Verify that the size of the hand and number of aces is as expected
        assertEquals(this.hand.getSize(),0);
        assertEquals(this.hand.getAces(),0);

        // Add two cards and check that size changes and the right cards are added
        int ace = 0;
        LinkedList<Card> cardList = new LinkedList<>();
        Card card1 = deck.drawCard();
        if (card1.rank().equals(ACE)) {
            ace +=1;
        }
        cardList.add(card1);
        this.hand.add(card1);
        // Check first card added properly
        assertEquals(this.hand.getSize(),1);
        assertEquals(this.hand.getAces(),ace);
        assertEquals(this.hand.getCardList(),cardList);

        Card card2 = deck.drawCard();
        if (card2.rank().equals(ACE)) {
            ace +=1;
        }
        cardList.add(card2);
        this.hand.add(card2);
        // Check second card added properly
        assertEquals(this.hand.getSize(),2);
        assertEquals(this.hand.getAces(),ace);
        assertEquals(this.hand.getCardList(),cardList);

        // Add an ace and check that it is properly added
        Card card3 = new Card(HEARTS, ACE);
        this.hand.add(card3);
        ace +=1;
        cardList.add(card3);
        assertEquals(this.hand.getSize(),3);
        assertEquals(this.hand.getAces(),ace);
        assertEquals(this.hand.getCardList(),cardList);

    }

    @Test
    void clear() {
        //Verify that the size of the hand and number of aces is as expected
        assertEquals(this.hand.getSize(),0);
        assertEquals(this.hand.getAces(),0);

        // Add 2 cards and verify size changes
        Card card1 = deck.drawCard();
        this.hand.add(card1);
        Card card2 = deck.drawCard();
        this.hand.add(card2);
        assertEquals(this.hand.getSize(),2);

        // Clear cards and verify size changes to zero
        this.hand.clear();
        assertEquals(this.hand.getSize(),0);
    }

    @Test
    void getTotals() {
        List<Integer> totals = new ArrayList<Integer>();

        // Create new hand with ace and 4, verify correct totals
        Card card1 = new Card(HEARTS, ACE);
        Card card2 = new Card(HEARTS, FOUR);

        this.hand.add(card1);
        this.hand.add(card2);

        totals.add(5);
        totals.add(15);
        assertEquals(this.hand.getTotals(),totals);

        // Verify adding another card
        Card card3 = new Card(HEARTS, SIX);
        this.hand.add(card3);
        totals.clear();
        totals.add(11);
        totals.add(21);
        assertEquals(this.hand.getTotals(),totals);
    }

    @Test
    void best() {
        // Create new hand with ace and 4, verify correct best score given
        Card card1 = new Card(HEARTS, ACE);
        Card card2 = new Card(HEARTS, FOUR);

        this.hand.add(card1);
        this.hand.add(card2);

        assertEquals(this.hand.best(),15);

        // Verify adding another card
        Card card3 = new Card(HEARTS, SIX);
        this.hand.add(card3);
        assertEquals(this.hand.best(),21);

        // Clear hand and verify that a blackjack returns -1
        Card card4 = new Card(HEARTS, ACE);
        Card card5 = new Card(HEARTS, JACK);
        this.hand.clear();
        this.hand.add(card4);
        this.hand.add(card5);
        assertEquals(this.hand.best(),-1);
    }

}
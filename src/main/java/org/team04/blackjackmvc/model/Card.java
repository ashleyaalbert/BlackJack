/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: King
 * Section: 9am
 *
 * Name: Taylor LaMantia
 * Date: 4/7/2023
 *
 * Final Project: Black jack
 *
 * Description: A class that represents a playing card
 * in a deck of cards with a suit, rank, and value property
 *
 * *****************************************/
package org.team04.blackjackmvc.model;

public class Card {

    /**
     * The four suits of playing cards
     */
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    };

    /**
     * The 13 card rank options
     */
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(1);

        final int value;

        private Rank(int value) {
            this.value = value;
        }
    }

    /**Suit of card*/
    private final Suit suit;

    /**Rank of card*/
    private final Rank rank;

    /**
     * Visibility of the card to the user
     */
    private Boolean visibility;

    /**
     * Create a new card
     * @param suit
     * @param rank
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.visibility = false;
    }

    /**
     * Getters and setters
     */
    public Suit suit() {
        return suit;
    }

    public Rank rank() {
        return rank;
    }

    public int value() {
        return rank.value;
    }
    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * An overriden string method to print the card's suit and rank
     *
     * @return a string of the card's suit and rank
     */
    @Override
    public String toString() {
        return "{" + rank +
                " " + suit +
                '}';
    }

}

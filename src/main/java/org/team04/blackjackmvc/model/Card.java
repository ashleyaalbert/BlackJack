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

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;


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
     * X Position of the Card
     */
    private int xPosition;

    /**
     * Y Position of the Card
     */
    private int yPosition;

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
     * This method is derived and altered from https://github.com/uzaymacar/blackjack-with-gui/blob/master/src/Card.java.
     * It is responsible for printing out our card image.
     *
     * @param graphics to draw the image
     * @param isUserTurn to see whose turn it is
     * @param cardIsUp to see if the card should be drawn yp or down
     * @param cardNumber to help calculate where it is drawn
     * @throws IOException
     */
    public void cardPrinter(Graphics2D graphics, boolean isUserTurn, boolean cardIsUp, int cardNumber) throws IOException {
        // reading the front card image and setting a width and height
        BufferedImage cardsSprite = ImageIO.read(new File("images/cardSpriteSheet.png"));
        int imgWidth = 950;
        int imgHeight = 392;

        // creating an array of the card images
        BufferedImage[][] cardArray = new BufferedImage[4][13];

        // reading the back card image
        BufferedImage backOfACard = ImageIO.read(new File("images/backsideOfACard.jpg"));

        // for loop to set up the array to get the subimage from the larger sprite
        for(int s = 0; s < 4; s++) {
            for(int v = 0; v < 13; v++) {
                cardArray[s][v] = cardsSprite.getSubimage(v*imgWidth/13,s*imgHeight/4, imgWidth/13, imgHeight/4);
            }
        }

        // checking if it is the user's or dealer's turn for the yPosition
        if(isUserTurn){
            yPosition = 400; // if it is the user's turn
        } else {
            yPosition = 75; // if it is the dealer's turn
        }

        // calculating the xPosition
        xPosition = 500 + 75 * cardNumber;

        // checking if the card should be drawn face up or down
        if(cardIsUp){
            graphics.drawImage(cardArray[suit.ordinal()][rank.ordinal()], xPosition, yPosition, null);
        } else {
            graphics.drawImage(backOfACard, xPosition, yPosition, null);
        }
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

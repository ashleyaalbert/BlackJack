package org.team04.blackjackmvc.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    /**
     * A common deck object to use for all tests
     */
    private Deck deck;

    /**
     * A common user object to use for all tests
     */
    private User user;

    /**
     * Common starting balance to use
     */
    private double initM = 500;

    /**
     * Common name to use
     */
    private String name = "Taylor";

    @BeforeEach
    void setUp() {
        this.deck = new Deck(4);
        this.user = new User(name, initM);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void placeBet() throws InsufficientFundsException {
        //Verify that the current bet and money is as expected
        assertEquals(user.getCurrentBet(),0);
        assertEquals(user.getMoney(),500);

        // Place a bet and verify current bet is set and money changes
        user.placeBet(50);
        assertEquals(user.getCurrentBet(),50);
        assertEquals(user.getMoney(),450);

        // Try to place bet beyond balance and verify exception thrown
        assertThrows(InsufficientFundsException.class, () -> user.placeBet(451));

    }

}
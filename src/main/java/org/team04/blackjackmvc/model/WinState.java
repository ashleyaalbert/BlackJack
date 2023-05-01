package org.team04.blackjackmvc.model;

/**
 * The current state of the user in the hand (whether the user has won or lost or is still playing)
 */
public enum WinState {
    WIN, // User wins hand, gets back current bet times 2
    LOSS, // User loses hand, bank keeps current bet
    PUSH, // Player gets back bet
    BLACKJACK, // Deal hand to user and dealer
    BUST, //User over 21
    NULL; // Hand is still in play, winner not evaluated yet
}

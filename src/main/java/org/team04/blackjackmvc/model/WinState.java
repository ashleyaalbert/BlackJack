package org.team04.blackjackmvc.model;

public enum WinState {
    WIN, // User wins hand, gets back current bet times 2
    LOSS, // User loses hand, bank keeps current bet
    PUSH, // Player gets back bet
    BLACKJACK, // Deal hand to user and dealer
    BUST, //User over 21
    NULL; // Hand is still in play, winner not evaluated yet
}

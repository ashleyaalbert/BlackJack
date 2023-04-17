/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 9am
 * Date: 4/14/2023
 * Time: 9:21 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc.model
 * Class: PlayerState
 *
 * Description:
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

/**
 * The current state of the player in the game
 */
public enum GameState {
    START_GAME, // Player starts game
    IN_GAME, // Player can place bets or end game
    PLAY_HAND, // Deal hand to user and dealer and allow user to decide moves
    EVALUATE_HANDS, // Player pushes or is at maximum hand, evaluate winner
    END_GAME, // Player ends game or runs out of money
}

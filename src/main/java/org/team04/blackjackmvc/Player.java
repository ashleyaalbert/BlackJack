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
 * Class: Player
 *
 * Description: Player interface that includes a method
 * for the next move to be played by the player, which will
 * differ in rules depending on the type of player
 *
 * ****************************************
 */
package org.team04.blackjackmvc;

public interface Player {
    // Player plays the next move
    void playNextMove();
}

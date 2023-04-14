/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 9am
 * Date: 4/8/2023
 * Time: 11:36 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: Dealer
 *
 * Description:
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

public class Dealer implements Player{
    /**
     * The dealer hand to be used
     */
    Hand dealerHand;

    /**
     * Dealer is created with new empty hand
     */
    public Dealer() {
        dealerHand = new Hand();
    }
    @Override
    public void playNextMove() {
        //TODO
    }
}

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 9am
 * Date: 4/8/2023
 * Time: 11:39 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: User
 *
 * Description:
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

import java.util.Map;
import java.util.TreeMap;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class User implements Player{
    /**
     * Name of the player
     */
    private String name;
    /**
     * Maps the bet placed by the user to the hand of the bet
     */
    private Map<Hand, Integer> handBets = new TreeMap<>();
    /**
     * A property that represents the player's money
     */
    private double money;

    public User(String name, double initMoney) {
        this.name = name;
        this.money= initMoney;
    }

    @Override
    public void playNextMove() {

    }
}

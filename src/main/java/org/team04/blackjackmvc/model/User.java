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
import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class User{
    /**
     * Name of the player
     */
    private String name;

    /**
     * The current bet by the user
     */
    private double currentBet;
    /**
     * A property that represents the player's money
     */
    private double money;

    /**
     * The current hand being played
     */
    private Hand currentHand;

    /**
     * Scanner for user input
     */
    private Scanner scnr;

    /**
     * Create user and initialize user with @param initMoney and @param name and new empty hand
     */
    public User(String name, double initMoney) {
        this.name = name;
        this.money= initMoney;
        this.currentHand = new Hand();
        System.out.println(name);
    }

    public double getMoney() {
        return money;
    }

    /**
     * Place bet of {@param amount} on current hand
     * @throws InsufficientFundsException
     */
    public void placeBet(double amount) throws InsufficientFundsException{
        if (this.money < amount) {
            throw new InsufficientFundsException((String.format(
                    "INSUFFICIENT FUNDS! Required: $%.2f, Available: $%.2f",
                    amount, this.money)));
        }
        this.currentBet = amount;
        this.money -= amount;
        System.out.printf("Bet: $.2f, Remaining funds: $.2f", amount, this.money);

    }

    /**
     * Make card visible and add it to the current hand
     * @param card
     */
    public void dealCard(Card card) {
        card.setVisibility(true);
        this.currentHand.add(card);
    }

    /**
     * @return the best possible score of the hand (-1 is a blackjack)
     */
    public int getBest() {
        return this.currentHand.best();
    }

    /**
     * reset the current hand
     */
    public void clearHand() {
        this.currentHand.clear();
    }

    public double getCurrentBet() {
        return currentBet;
    }

    public Hand getHand() {
        return this.currentHand;
    }


}
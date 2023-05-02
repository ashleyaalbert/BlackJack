/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Section: 9am
 * Date: 4/8/2023
 * Time: 11:39 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: User
 *
 * Description: A user object to be controlled for a playing a game of blackjack
 *
 * ****************************************
 */

package org.team04.blackjackmvc.model;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

/**
 * A user class for a blackjack game that controls the player hand, bets, and money balance
 */
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
     * Create user and initialize user with @param initMoney and @param name and new empty hand
     */
    public User(String name, double initMoney) {
        this.name = name;
        this.money= initMoney;
        this.currentHand = new Hand();
        this.currentBet = 0;
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

    public void handleMoney(WinState win) {
        // If loses or busts bet stays out of money
        if (win.equals(WinState.BUST) || win.equals(WinState.LOSS)) {
            this.money = this.money;
        }

        // If win, earn back twice money
        else if (win.equals(WinState.WIN)) {
            this.money += this.currentBet*2;
        }

        else if (win.equals(WinState.BLACKJACK)) {
            this.money += this.currentBet*1.5 + this.currentBet;
        }

        else if (win.equals(WinState.PUSH)) {
            this.money += this.currentBet;
        }
    }

    /**
     * @return the best possible score of the current user hand (-1 is a blackjack)
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

    public Hand getHand() {
        return this.currentHand;
    }

    public double getMoney() {
        return money;
    }

    public double getCurrentBet() {
        return currentBet;
    }
}
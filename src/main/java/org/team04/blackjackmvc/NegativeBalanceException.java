/* **********************************************
 * CSCI 205 - Software Engineering and Design
 * Sprint 2023
 * Instructor: Prof. Brian King
 *
 * Name: Eva Frankovic
 * Section: 01 - 9am
 * Date: 4/24/23
 * Time: 8:30 PM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc
 * Class: NegativeBalanceException
 *
 * Description:
 *
 * **********************************************
 */

package org.team04.blackjackmvc;

public class NegativeBalanceException extends Exception{
    /**
     * Checked exception representing the issue of the the balance being in negatives
     */

        public NegativeBalanceException(String message) {
            super(message);
        }
    }

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Section: 9am
 * Date: 4/12/2023
 * Time: 9:22 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc.model
 * Class: EmptyDeckException
 *
 * Description: An exception that is thrown if the deck is empty
 *
 * ****************************************
 */

package org.team04.blackjackmvc.model;

/**
 * Checked exception representing the issue of the deck being empty
 */
public class EmptyDeckException extends Exception {
    public EmptyDeckException(String message) {
        super(message);
    }
}
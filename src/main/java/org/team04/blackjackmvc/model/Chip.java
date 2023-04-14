/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: Prof. Brian King
 *
 * Name: Taylor LaMantia
 * Section: 9am
 * Date: 4/12/2023
 * Time: 10:00 AM
 *
 * Project: csci205_final_project
 * Package: org.team04.blackjackmvc.model
 * Class: Chips
 *
 * Description:
 *
 * ****************************************
 */
package org.team04.blackjackmvc.model;

public enum Chip {
    ONE(1), TWO(2), FIVE(5), TEN(10),
    TWENTYFIVE(25), FIFTY(50), ONEHUNDRED(100);
    final double value;
    Chip(int value) {
            this.value = value;
        }
}
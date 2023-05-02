/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2023
 * Instructor: King
 * Section: 9am
 *
 * Name: Taylor LaMantia, Eva Frankovic, Ashley Albert
 * Date: 4/7/2023
 *
 * Final Project: Black jack
 *
 * Description: A class for the game over controller
 *
 * *****************************************/

package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BlackjackGameOverContoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * Button that takes the user to the home screen
     */
    @FXML
    private Button homeButton;

    /**
     * Label that shows the user their end balance at the end of the game
     */
    @FXML
    private Label lblEndBalance;

    @FXML
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackJackGameOver.fxml'.";
        assert lblEndBalance != null : "fx:id=\"lblEndBalance\" was not injected: check your FXML file 'blackJackGameOver.fxml'.";
        lblEndBalance.setVisible(false);
        setBalance();
    }


    /**
     * {@link ActionEvent} handler for when we're ready to change to the next
     * scene.
     *
     * @param event is the {@link ActionEvent} passed
     */
    @FXML
    void onBtnNextSceneAction(ActionEvent event) {
        // Get the Stage object of this button
        Stage stage = (Stage) homeButton.getScene().getWindow();

        if (event.getSource() == homeButton)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.WELCOME);

    }


    /**
     * Method that sets the end balance for the user
     */
    private void setBalance(){
        double endBalance = BlackJackPlayController.currentBalance;
        lblEndBalance.setText(String.valueOf(endBalance));
        lblEndBalance.setVisible(true);
    }
}


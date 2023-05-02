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
 * Description: A class for the login controller
 *
 * *****************************************/

package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BlackJackLoginController {

    public static String name;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * Button that takes the user to the play screen
     */
    @FXML
    private Button btnGo;

    /**
     * Shows the user their initial balance
     */
    @FXML
    private Label lblInitialBalance;

    /**
     * Text field to get the user's name
     */
    @FXML
    private TextField txtFieldName;

    /**
     * Initial Balance
     */
    private int balance = 500;



    @FXML
    void initialize() {
        assert btnGo != null : "fx:id=\"btnGo\" was not injected: check your FXML file 'blackJackLogin.fxml'.";
        assert lblInitialBalance != null : "fx:id=\"lblRemainingBalance\" was not injected: check your FXML file 'blackJackLogin.fxml'.";
        assert txtFieldName != null : "fx:id=\"txtFieldName\" was not injected: check your FXML file 'blackJackLogin.fxml'.";
        lblInitialBalance.setVisible(false);

        initEventHandlers();
    }

    /**
     * Method that gets user input
     */
    private void initEventHandlers() {
        txtFieldName.setOnKeyPressed( event -> {
            if(event.getCode() == KeyCode.ENTER ) {
                lblInitialBalance.setText(Integer.toString(balance));
                lblInitialBalance.setVisible(true);
                name = String.valueOf(txtFieldName.getText());
            }
        } );
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
        Stage stage = (Stage) btnGo.getScene().getWindow();

        if (event.getSource() == btnGo)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.PLAY);
    }
}

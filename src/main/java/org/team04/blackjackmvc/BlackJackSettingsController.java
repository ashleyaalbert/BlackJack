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
 * Description: A class for the settings controller
 *
 * *****************************************/

package org.team04.blackjackmvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static org.team04.blackjackmvc.blackjackMain.musicPlayer;
import static org.team04.blackjackmvc.blackjackMain.musicStopper;

public class BlackJackSettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * Button that takes the user back to the play screen
     */
    @FXML
    private Button btnBack;
    /**
     * Button that turns off the music
     */
    @FXML
    private Button btnOff;

    /**
     * Button that turns on the music
     */
    @FXML
    private Button btnOn;

    /**
     * Button that represents as a volume button
     */
    @FXML
    private Button btnVolume;

    /**
     * {@link ActionEvent} handler for when we're ready to change to the next
     * scene.
     *
     * @param event is the {@link ActionEvent} passed
     */
    @FXML
    void onBtnNextSceneAction(ActionEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        // Get the Stage object of this button
        Stage stage = (Stage) btnBack.getScene().getWindow();

        if (event.getSource() == btnBack)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.PLAY);

        if(event.getSource() == btnOff)
            musicStopper();

        if(event.getSource() == btnOn)
            musicPlayer("jazz.wav");
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnOn != null : "fx:id=\"btnOn\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackSettings.fxml'.";

    }

}

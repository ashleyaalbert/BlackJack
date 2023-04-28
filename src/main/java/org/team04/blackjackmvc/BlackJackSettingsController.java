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

    @FXML
    private Button btnBack;
    @FXML
    private Button btnOff;

    @FXML
    private Button btnOn;

    @FXML
    private Button btnVolume;

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

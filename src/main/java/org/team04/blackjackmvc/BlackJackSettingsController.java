package org.team04.blackjackmvc;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.print.attribute.standard.Media;

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
    void onBtnNextSceneAction(ActionEvent event) {
        // Get the Stage object of this button
        Stage stage = (Stage) btnBack.getScene().getWindow();

        if (event.getSource() == btnBack)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.PLAY);
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnOn != null : "fx:id=\"btnOn\" was not injected: check your FXML file 'blackjackSettings.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackSettings.fxml'.";

    }

}

package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BlackjackWelcomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label blackjackTitle;

    @FXML
    private ImageView bottomLeftSparkle;

    @FXML
    private ImageView bottomRightSparkle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnSettings;

    @FXML
    private ImageView cardsImageView;

    @FXML
    private AnchorPane tableBackground;

    @FXML
    private ImageView topLeftSparkle;

    @FXML
    private ImageView topRightSparkle;

    @FXML
    void initialize() {
        assert blackjackTitle != null : "fx:id=\"blackjackTitle\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert bottomLeftSparkle != null : "fx:id=\"bottomLeftSparkle\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert bottomRightSparkle != null : "fx:id=\"bottomRightSparkle\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert btnSettings != null : "fx:id=\"btnSettings\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert cardsImageView != null : "fx:id=\"cardsImageView\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert tableBackground != null : "fx:id=\"tableBackground\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert topLeftSparkle != null : "fx:id=\"topLeftSparkle\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
        assert topRightSparkle != null : "fx:id=\"topRightSparkle\" was not injected: check your FXML file 'blackjackWelcome.fxml'.";
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
        Stage stage = (Stage) btnPlay.getScene().getWindow();

        if (event.getSource() == btnPlay)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.PLAY);
        else if (event.getSource() == btnSettings)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.SETTINGS);
    }

}

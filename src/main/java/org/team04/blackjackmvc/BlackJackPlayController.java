package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BlackJackPlayController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label amountOfMoneyInPot;

    @FXML
    private ImageView blackChip;

    @FXML
    private Label blackjackText;

    @FXML
    private ImageView blueChip;

    @FXML
    private Button btnDeal;

    @FXML
    private ImageView btnHome;

    @FXML
    private Button btnVolume;

    @FXML
    private Label chipTotal;

    @FXML
    private ImageView greenChip;

    @FXML
    private Button hitButton;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView redChip;

    @FXML
    private Button standButton;

    @FXML
    void initialize() {
        assert amountOfMoneyInPot != null : "fx:id=\"amountOfMoneyInPot\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blackChip != null : "fx:id=\"blackChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blackjackText != null : "fx:id=\"blackjackText\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blueChip != null : "fx:id=\"blueChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnDeal != null : "fx:id=\"btnDeal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert chipTotal != null : "fx:id=\"chipTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert greenChip != null : "fx:id=\"greenChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert redChip != null : "fx:id=\"redChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
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
        Stage stage = (Stage) btnHome.getScene().getWindow();

        if (event.getSource() == btnHome) {
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.WELCOME);
        } else if (event.getSource() == btnVolume) {
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.SETTINGS);
        }
    }

    @FXML
    void onChip(ActionEvent event){

    }

    @FXML
    void updatePot(){

    }

    @FXML
    void updateBalance(){

    }

}

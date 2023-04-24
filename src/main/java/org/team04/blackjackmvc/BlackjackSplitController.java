package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BlackjackSplitController {

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
    private Button btnBlackChip;

    @FXML
    private Button btnBlueChip;

    @FXML
    private Button btnSplit;

    @FXML
    private Button btnGreenChip;

    @FXML
    private ImageView btnHome;

    @FXML
    private Button btnRedCHip;

    @FXML
    private Button btnVolume;

    @FXML
    private ImageView greenChip;

    @FXML
    private Button hitButton;

    @FXML
    private Button homeButton;

    @FXML
    private Label lblChipTotal;

    @FXML
    private Label lblPot;

    @FXML
    private ImageView redChip;

    @FXML
    private Button standButton;


    @FXML
    void initialize() {
        assert amountOfMoneyInPot != null : "fx:id=\"amountOfMoneyInPot\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert blackChip != null : "fx:id=\"blackChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert blackjackText != null : "fx:id=\"blackjackText\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert blueChip != null : "fx:id=\"blueChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnBlackChip != null : "fx:id=\"btnBlackChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnBlueChip != null : "fx:id=\"btnBlueChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnSplit != null : "fx:id=\"btnSplit\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnGreenChip != null : "fx:id=\"btnGreenChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnRedCHip != null : "fx:id=\"btnRedCHip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert greenChip != null : "fx:id=\"greenChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert lblChipTotal != null : "fx:id=\"lblChipTotal\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert lblPot != null : "fx:id=\"lblPot\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert redChip != null : "fx:id=\"redChip\" was not injected: check your FXML file 'blackjackSplit.fxml'.";
        assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'blackjackSplit.fxml'.";

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

        if (event.getSource() == homeButton) {
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.WELCOME);
        } else if (event.getSource() == btnVolume) {
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.SETTINGS);
        }
    }

    @FXML
    void onChip(ActionEvent event){
        if (event.getSource() == btnBlackChip) {
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 1;
            lblPot.setText(Integer.toString(newPot));

            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 1;
            lblChipTotal.setText(Integer.toString(newBalance));
        } else if (event.getSource() == btnRedCHip){
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 5;
            lblPot.setText(Integer.toString(newPot));

            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 5;
            lblChipTotal.setText(Integer.toString(newBalance));
        } else if (event.getSource() == btnGreenChip){
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 25;
            lblPot.setText(Integer.toString(newPot));

            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 25;
            lblChipTotal.setText(Integer.toString(newBalance));
        } else if (event.getSource() == btnBlueChip){
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 100;
            lblPot.setText(Integer.toString(newPot));

            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 100;
            lblChipTotal.setText(Integer.toString(newBalance));
        }
    }



    }

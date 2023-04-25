package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.team04.blackjackmvc.model.Hand;

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
    private Button btnBlackChip;

    @FXML
    private Button btnBlueChip;

    @FXML
    private Button btnDeal;

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

    // Creating variables for player and dealer hands
    private Hand playerHand;

    private Hand dealerHand;



    @FXML
    void initialize() {
        assert amountOfMoneyInPot != null : "fx:id=\"amountOfMoneyInPot\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blackChip != null : "fx:id=\"blackChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blackjackText != null : "fx:id=\"blackjackText\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert blueChip != null : "fx:id=\"blueChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnBlackChip != null : "fx:id=\"btnBlackChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnBlueChip != null : "fx:id=\"btnBlueChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnDeal != null : "fx:id=\"btnDeal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnGreenChip != null : "fx:id=\"btnGreenChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnRedCHip != null : "fx:id=\"btnRedCHip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert greenChip != null : "fx:id=\"greenChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblChipTotal != null : "fx:id=\"lblChipTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblPot != null : "fx:id=\"lblPot\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert redChip != null : "fx:id=\"redChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";

        // Creating hands for both player and dealer
        dealerHand = new Hand();
        playerHand = new Hand();

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

    /**
     * This method controls how the chips can be selected
     * and alters the pot value and the remaining balance of the
     * player
     * @param event event is the {@link ActionEvent} passed
     */
    @FXML
    void onChip(ActionEvent event) throws NegativeBalanceException {
        if (event.getSource() == btnBlackChip) {
            // Adds to the pot
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 1;

            // Get the current balance
            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 1;

            // Check if the new pot value exceeds the balance
            if (newBalance < 0) {
                throw new NegativeBalanceException("Not enough funds for this bet!");
            }

            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(newPot));
            lblChipTotal.setText(Integer.toString(newBalance));
        } else if (event.getSource() == btnRedCHip){
            // Adds to the pot
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 5;

            // Get the current balance
            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 5;

            // Check if the new pot value exceeds the balance
            if (newBalance < 0) {
                throw new NegativeBalanceException("Not enough funds for this bet!");
            }

            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(newPot));
            lblChipTotal.setText(Integer.toString(newBalance));
        } else if (event.getSource() == btnGreenChip){
            // Adds to the pot
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 25;

            // Get the current balance
            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 25;

            // Check if the new pot value exceeds the balance
            if (newBalance < 0) {
                throw new NegativeBalanceException("Not enough funds for this bet!");
            }

            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(newPot));
            lblChipTotal.setText(Integer.toString(newBalance));

        } else if (event.getSource() == btnBlueChip){
            // Adds to the pot
            int currentPot = Integer.parseInt(lblPot.getText());
            int newPot = currentPot + 100;

            // Get the current balance
            int currentBalance = Integer.parseInt(lblChipTotal.getText());
            int newBalance = currentBalance - 100;

            // Check if the new pot value exceeds the balance
            if (newBalance < 0) {
                throw new NegativeBalanceException("Not enough funds for this bet!");
            }

            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(newPot));
            lblChipTotal.setText(Integer.toString(newBalance));
        }

    }
    @FXML
    void onDeal(){
        // after the deal button is pressed, it is disabled
        btnDeal.setVisible(false);

        // and hit and stand button are visible.
        standButton.setVisible(true);
        hitButton.setVisible(true);

    }
}


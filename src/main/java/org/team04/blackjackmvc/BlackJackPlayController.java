package org.team04.blackjackmvc;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.team04.blackjackmvc.model.*;

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

    @FXML
    private Label lblWinner;

    /**
     * Creating variables for player and dealer
     */
    private Dealer dealer;

    private User player;
    private Hand playerHand;

    private Hand dealerHand;
    private Game game;

    /**
     * Add a boolean variable to track whether the game has started
     */
    private boolean gameStarted = false;

    private int newBalance;
    private int currentBalance;
    private int newPot;
    private int resetPot;
    private int bank;



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
        assert lblWinner != null : "fx:id=\"lblWinner\" was not injected: check your FXML file 'blackjackPlay.fxml'.";

        // Creates a new game
        game = new Game();
        // Creates a new dealer and player
        dealer = new Dealer();
        player = new User("Eva", 500);
        // Creates new hands for dealer and player
        dealerHand = new Hand();
        playerHand = new Hand();

        //Creates a bank for the dealer
        bank = 0;
        resetPot = 0;

        lblWinner.setVisible(false);

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
     * This method controls how the black chips can be selected
     * and alters the pot value and the remaining balance of the
     * player
     *
     * @param event event is the {@link ActionEvent} passed
     */
    @FXML
    void onChipBlack(ActionEvent event) throws NegativeBalanceException {
        if (!gameStarted) {
            if (event.getSource() == btnBlackChip) {
                // Adds to the pot
                int currentPot = Integer.parseInt(lblPot.getText());
                newPot = currentPot + 1;

                // Get the current balance
                currentBalance = Integer.parseInt(lblChipTotal.getText());
                int newBalance = currentBalance - 1;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Integer.toString(newPot));
                lblChipTotal.setText(Integer.toString(newBalance));
            }
        }
    }

    /**
     * This method controls how the red chips can be selected
     * and alters the pot value and the remaining balance of the
     * player
     *
     * @param event event is the {@link ActionEvent} passed
     */
    @FXML
    void onChipRed(ActionEvent event) throws NegativeBalanceException {
        if (!gameStarted) {
            if (event.getSource() == btnRedCHip) {
                // Adds to the pot
                int currentPot = Integer.parseInt(lblPot.getText());
                newPot = currentPot + 5;

                // Get the current balance
                currentBalance = Integer.parseInt(lblChipTotal.getText());
                int newBalance = currentBalance - 5;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Integer.toString(newPot));
                lblChipTotal.setText(Integer.toString(newBalance));
            }
        }
    }

    /**
     * This method controls how the green chips can be selected
     * and alters the pot value and the remaining balance of the
     * player
     *
     * @param event event is the {@link ActionEvent} passed
     */
    @FXML
    void onChipGreen(ActionEvent event) throws NegativeBalanceException {
        if (!gameStarted) {
            if (event.getSource() == btnGreenChip) {
                // Adds to the pot
                int currentPot = Integer.parseInt(lblPot.getText());
                newPot = currentPot + 25;

                // Get the current balance
                currentBalance = Integer.parseInt(lblChipTotal.getText());
                int newBalance = currentBalance - 25;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Integer.toString(newPot));
                lblChipTotal.setText(Integer.toString(newBalance));
            }
        }
    }

    /**
     * This method controls how the blue chips can be selected
     * and alters the pot value and the remaining balance of the
     * player
     *
     * @param event event is the {@link ActionEvent} passed
     */
    @FXML
    void onChipBlue(ActionEvent event) throws NegativeBalanceException {
        if (!gameStarted) {
            if (event.getSource() == btnBlueChip) {
                // Adds to the pot
                int currentPot = Integer.parseInt(lblPot.getText());
                newPot = currentPot + 100;

                // Get the current balance
                currentBalance = Integer.parseInt(lblChipTotal.getText());
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
    }

    /**
     * In this method when the deal button is pressed it locks
     * the players bet in and deals the cards.
     */
    @FXML
    void onDeal() {
        gameStarted = true;


        // after the deal button is pressed, it is disabled
        btnDeal.setVisible(false);

        // Deals cards to player and dealer
        game.dealHand();

        // and hit and stand button are visible.
        standButton.setVisible(true);
        hitButton.setVisible(true);

    }

    /**
     * When the hit button is pressed, the dealer will deal the player
     * a new card.
     */
    @FXML
    void onHit() {
        playerHand.add(new Card(Card.Suit.HEARTS, Card.Rank.JACK));

    }

    /**
     * When the stand button is pressed, the dealer will stop dealing to
     * the user and deal itself to try and get 21. Then the sum of the players
     * and dealers hands will then be calculated and returned. As well as dealing with
     * beats.
     */
    @FXML
    void onStand() {
        // Trying to calculate sum of cards as well as deal the dealer
        // until satisfied.
        int playerHandSum = playerHand.sum();
        boolean playerHasBlackjack = playerHand.getSize() == 2 && playerHandSum == 21;

        if (playerHandSum <= 21 && !playerHasBlackjack) {
            // dealer hits repeatedly, stands on hard a 17
            while (dealerHand.sum() < 17) {
                dealerHand.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));

//                // if dealer has a soft 17, hit again
//                if (dealerHand.sum() == 17 && dealerHand.hasAce()) {
//                    dealerHand.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
            }
        }

        String getWinner = getWinner();
        // player has black jack
        if(getWinner.equals("player blackjack")){
            // give bets to player
            newBalance += newPot;
            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(resetPot));
            lblChipTotal.setText(Integer.toString(newBalance));

            lblWinner.setText("Blackjack!!!");
            lblWinner.setVisible(true);

        }

        // player wins
        if(getWinner.equals("player wins")){
            // give bets to player
            newBalance += newPot;
            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(resetPot));
            lblChipTotal.setText(Integer.toString(newBalance));

            lblWinner.setText("You win!");
            lblWinner.setVisible(true);

        }

        // dealer has black jack or wins
        if(getWinner.equals("dealer blackjack") || getWinner.equals("dealer wins")){
            // give bets to dealer
            // give bets to player
            bank += newPot;
            // Updates the pot label and balance label
            lblPot.setText(Integer.toString(resetPot));
            lblChipTotal.setText(Integer.toString(currentBalance));


            lblWinner.setText("Dealer Wins.");
            lblWinner.setVisible(true);

        }

        // push
        if(getWinner.equals("push")){
            // bets go back to each player
            newBalance += newPot;
            lblPot.setText(Integer.toString(resetPot));
            lblChipTotal.setText(Integer.toString(newBalance));

            lblWinner.setText("Push");
            lblWinner.setVisible(true);
        }
    }

    /**
     * Compares the values of the sums of player and dealer
     * to find the winner
     *
     * @return String value of player or dealer
     */
    private String getWinner() {
        int dealerSum = dealerHand.sum();
        int playerSum = playerHand.sum();
        boolean dealerHasBlackjack = false;
        boolean playerHasBlackjack = true;

        // Checks if dealer or player has blackjack
        if (dealerHand.getSize() == 2 && dealerSum == 21) {
            dealerHasBlackjack = true;
        } else if (playerHand.getSize() == 2 && playerSum == 21) {
            playerHasBlackjack = true;
        }

        // Finds winner is user or dealer has black jack
        if (dealerHasBlackjack && !playerHasBlackjack) {         // if dealer has blackjack and the player does not
            return "dealer blackjack";
        } else if (!dealerHasBlackjack && playerHasBlackjack) {   // if player has blackjack and the dealer does not
            return "player blackjack";
        }

        // Compares sums finds winner or determines a push (tie)
        if (playerSum > 21) {
            return "dealer wins";
        } else if (dealerSum > 21) {
            return "player wins";
        } else if (playerSum > dealerSum) {
            return "player wins";
        } else if (dealerSum > playerSum) {
            return "dealer wins";
        } else if (dealerSum == playerSum) {
            return "push";
        } else {
            // Should never get here
            return "null";
        }

    }

}


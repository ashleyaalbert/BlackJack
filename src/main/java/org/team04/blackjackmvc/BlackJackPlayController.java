package org.team04.blackjackmvc;

//import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.team04.blackjackmvc.model.*;

public class BlackJackPlayController {

    // GUI elements of the program

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * Button for the black chip that represents the value 1
     */
    @FXML
    private Button btnBlackChip;

    /**
     * Button for the blue chip that represents the value 100
     */
    @FXML
    private Button btnBlueChip;

    /**
     * Button when pressed deals the cards for the player
     */
    @FXML
    private Button btnDeal;

    /**
     * Button for the green chip that represents the value 25
     */
    @FXML
    private Button btnGreenChip;

    /**
     * Button for the red chip that represents the value 5
     */
    @FXML
    private Button btnRedCHip;

    /**
     * Button to control the volume in settings
     */
    @FXML
    private Button btnVolume;

    /**
     * Button when pressed will deal the user another card
     */
    @FXML
    private Button hitButton;

    /**
     * Button when pressed will take the person back to the home screen
     */
    @FXML
    private Button homeButton;

    /**
     * Label that represents the chip total for the player
     */
    @FXML
    private Label lblChipTotal;

    /**
     * Label that represents the total chips in the pot
     */
    @FXML
    private Label lblPot;

    /**
     * Button that deals the dealer to stop dealing cards and is ready for the showdown
     */
    @FXML
    private Button standButton;

    /**
     * Label that communicates with the user who is the winner
     */
    @FXML
    private Label lblWinner;

    @FXML
    private FlowPane dealerFlowPane;

    @FXML
    private FlowPane playerFlowPane;

    /**
     * Initializing a game
     */
    private Game game;

    /**
     * Creating a hand for the player
     */
    private Hand playerHand;

    /**
     * Creating a hand for the dealer
     */
    private Hand dealerHand;


    /**
     * Add a boolean variable to track whether the game has started
     */
    private boolean gameStarted = false;

    /**
     * An updated user balance that is updated
     * throughout the game
     */
    private int newBalance;

    /**
     * The currentBalance of the user at that
     * current time
     */
    private int currentBalance;
    /**
     * Updated pot after bets are made
     */
    private int newPot;
    /**
     * Resets the pot to 0, when the game is reset
     */
    private int resetPot;
    /**
     * Stores the bets of the user that have
     * been lost
     */
    private int bank;

    /**
     * An array of ImageView objects that stores 12 images of the dealer's cards
     */
    private ImageView[] dealerImageView;

    /**
     * An array of ImageView objects that stores 12 images of the player's cards
     */
    private ImageView[] playerImageView;


    @FXML
    void initialize() {
        assert btnBlackChip != null : "fx:id=\"btnBlackChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnBlueChip != null : "fx:id=\"btnBlueChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnDeal != null : "fx:id=\"btnDeal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnGreenChip != null : "fx:id=\"btnGreenChip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnRedCHip != null : "fx:id=\"btnRedCHip\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblChipTotal != null : "fx:id=\"lblChipTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblPot != null : "fx:id=\"lblPot\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblWinner != null : "fx:id=\"lblWinner\" was not injected: check your FXML file 'blackjackPlay.fxml'.";


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
        game.playerHit();
    }

    /**
     * When the stand button is pressed, the dealer will stop dealing to
     * the user and deal itself to try and get 21. Then the sum of the players
     * and dealers hands will then be calculated and returned. As well as dealing with
     * beats.
     */
    @FXML
    void onStand() {
        game.playerStand();
    }
//
//        //String getWinner = getWinner();
//        // player has black jack
//        if(getWinner.equals("player blackjack")){
//            // give bets to player
//            newBalance += newPot;
//            // Updates the pot label and balance label
//            lblPot.setText(Integer.toString(resetPot));
//            lblChipTotal.setText(Integer.toString(currentBalance));
//
//            lblWinner.setText("Blackjack!!!");
//            lblWinner.setVisible(true);
//        }
//
//        // player wins
//        if(getWinner.equals("player wins")){
//            // give bets to player
//            newBalance += newPot;
//            // Updates the pot label and balance label
//            lblPot.setText(Integer.toString(resetPot));
//            lblChipTotal.setText(Integer.toString(newBalance));
//
//            lblWinner.setText("You win!");
//            lblWinner.setVisible(true);
//
//        }
//
//        // dealer has black jack or wins
//        if(getWinner.equals("dealer blackjack") || getWinner.equals("dealer wins")){
//            // give bets to player
//            bank += newPot;
//            // Updates the pot label and balance label
//            lblPot.setText(Integer.toString(resetPot));
//            lblChipTotal.setText(Integer.toString(currentBalance));
//
//
//            lblWinner.setText("Dealer Wins.");
//            lblWinner.setVisible(true);
//
//        }
//
//        // push
//        if(getWinner.equals("push")){
//            // bets go back to each player
//            newBalance += newPot;
//            lblPot.setText(Integer.toString(resetPot));
//            lblChipTotal.setText(Integer.toString(newBalance));
//
//            lblWinner.setText("Push");
//            lblWinner.setVisible(true);
//        }
//    }

//    /**
//     * Compares the values of the sums of player and dealer
//     * to find the winner
//     *
//     * @return String value of player or dealer
//     */
//    private String getWinner() {
//        int dealerSum = dealerHand.sum();
//        int playerSum = playerHand.sum();
//
//        boolean dealerHasBlackjack = false;
//        boolean playerHasBlackjack = false;
//
//        // Checks if dealer or player has blackjack
//        if (dealerHand.getSize() == 2 && dealerSum == 21) {
//            dealerHasBlackjack = true;
//        } else if (playerHand.getSize() == 2 && playerSum == 21) {
//            playerHasBlackjack = true;
//        }
//
//        // Finds winner is user or dealer has black jack
//        if (dealerHasBlackjack && !playerHasBlackjack) {         // if dealer has blackjack and the player does not
//            return "dealer blackjack";
//        } else if (!dealerHasBlackjack && playerHasBlackjack) {   // if player has blackjack and the dealer does not
//            return "player blackjack";
//        }
//
//        // Compares sums finds winner or determines a push (tie)
//        if (playerSum > 21) {
//            return "dealer wins";
//        } else if (dealerSum > 21) {
//            return "player wins";
//        } else if (playerSum > dealerSum) {
//            return "player wins";
//        } else if (dealerSum > playerSum) {
//            return "dealer wins";
//        } else if (dealerSum == playerSum) {
//            return "push";
//        } else {
//            // Should never get here
//            return "null";
//        }
//
//    }

    /**
     * Code from https://github.com/nalabrie/Blackjack/blob/master/src/Blackjack/Controller.java
     * Creates/updates the card images representing the dealer's hand inside the 'dealerFlowPane' container.
     *
     * @param showFirstCard Shows the first card when true, replaces it with a card back when false.
     */
    private void updateDealerFlowPane(boolean showFirstCard) {
        // if 'showFirstCard' is true: first card shown is a card back rather than the actual first card
        if (showFirstCard) {
            Image back = new Image("file:resources/org.team04.blackjackmvc/images/cards/back.png");
            dealerImageView[0] = new ImageView();
            dealerImageView[0].setImage(back);
            dealerImageView[0].setPreserveRatio(true);
            dealerImageView[0].setSmooth(true);
            dealerImageView[0].setCache(true);
            dealerImageView[0].setFitHeight(160);
            dealerFlowPane.getChildren().add(dealerImageView[0]);
        }

        // replace flipped over card with real card by clearing variables to force the next loop to run entirely
        else if (dealerImageView[0] != null) {
            dealerFlowPane.getChildren().clear();
            dealerImageView = new ImageView[12];
        }

        // add all cards in the dealer's hand to the FlowPane as images
        for (int i = 0; i < dealerHand.getSize(); i++) {
            // only add card when it hasn't been created yet (more efficient than overwriting the same image every time)
            if (dealerImageView[i] == null) {
                Image card = new Image("file:resources/org.team04.blackjackmvc/images/cards/" + dealerHand.getCard(i).value() + dealerHand.getCard(i).suit() + ".png");
                dealerImageView[i] = new ImageView();
                dealerImageView[i].setImage(card);
                dealerImageView[i].setPreserveRatio(true);
                dealerImageView[i].setSmooth(true);
                dealerImageView[i].setCache(true);
                dealerImageView[i].setFitHeight(160);
                dealerFlowPane.getChildren().add(dealerImageView[i]);
                if (i != 0) {
                    FlowPane.setMargin(dealerImageView[i], new Insets(0, 0, 0, -75));
                }
            }
        }
    }

    /**
     * Code from https://github.com/nalabrie/Blackjack/blob/master/src/Blackjack/Controller.java
     * Creates/updates the card images representing the player's hand inside the 'playerFlowPane' container.
     */
    private void updatePlayerFlowPane() {
        // add all cards in the player's hand to the FlowPane as images
        for (int i = 0; i < playerHand.getSize(); i++) {
            // only add card when it hasn't been created yet (more efficient than overwriting the same image every time)
            if (playerImageView[i] == null) {
                Image card = new Image("file:resources/org.team04.blackjackmvc/images/cards/" + playerHand.getCard(i).value() + playerHand.getCard(i).suit() + ".png");
                playerImageView[i] = new ImageView();
                playerImageView[i].setImage(card);
                playerImageView[i].setPreserveRatio(true);
                playerImageView[i].setSmooth(true);
                playerImageView[i].setCache(true);
                playerImageView[i].setFitHeight(160);
                playerFlowPane.getChildren().add(playerImageView[i]);
                if (i != 0) {
                    FlowPane.setMargin(playerImageView[i], new Insets(0, 0, 0, -75));
                }
            }
        }
    }

}


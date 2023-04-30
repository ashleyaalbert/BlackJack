package org.team04.blackjackmvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.team04.blackjackmvc.model.Card;
import org.team04.blackjackmvc.model.Game;
import org.team04.blackjackmvc.model.Hand;
import org.team04.blackjackmvc.model.User;
import org.team04.blackjackmvc.model.WinState;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static org.team04.blackjackmvc.BlackJackLoginController.name;


public class BlackJackPlayController {
    public static double playerBet;

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

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnPlayAgain;

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

    @FXML
    private Label lblDealerTotal;

    @FXML
    private Label lblPlayerTotal;

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

    /**
     * FlowPane that projects the cards for dealer
     */
    @FXML
    private FlowPane dealerFlowPane = new FlowPane();

    /**
     * FlowPane that projects the cards for player
     */
    @FXML
    private FlowPane playerFlowPane = new FlowPane();

    @FXML
    private Label lblIntro;

    @FXML
    private Rectangle rectShade;

    /**
     * Initializing a game
     */
    public Game game;

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
    private double newBalance;

    /**
     * Current winstate of the player
     */
    private WinState winState;

    /**
     * The balance of the user after betting
     */
    public static double newBalanceAfterBet;

    /**
     * The currentBalance of the user at that
     * current time
     */
    private double currentBalance;
    /**
     * Updated pot after bets are made
     */
    public static double newPot;
    /**
     * Resets the pot to 0, when the game is reset
     */
    private final double resetPot = 0;

    /**
     * Stores the bets of the user that have
     * been lost
     */
    private int bank;

    /**
     * An array of ImageView objects that stores 12 images of the dealer's cards
     */
    private ImageView[] dealerImageView = new ImageView[12];

    /**
     * An array of ImageView objects that stores 12 images of the player's cards
     */
    private ImageView[] playerImageView = new ImageView[12];



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
        assert playerFlowPane != null : "fx:id=\"lblWinner\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert dealerFlowPane != null : "fx:id=\"lblWinner\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblDealerTotal != null : "fx:id=\"lblDealerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblPlayerTotal != null : "fx:id=\"lblPlayerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert lblIntro != null : "fx:id=\"lblPlayerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnQuit != null : "fx:id=\"lblPlayerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert btnPlayAgain != null : "fx:id=\"lblPlayerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";
        assert rectShade != null : "fx:id=\"lblPlayerTotal\" was not injected: check your FXML file 'blackjackPlay.fxml'.";

        game = new Game(name);


        //Creates a bank for the dealer
        bank = 0;
        lblIntro.setVisible(true);
        lblWinner.setVisible(false);
        lblDealerTotal.setVisible(false);
        lblPlayerTotal.setVisible(false);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        btnQuit.setVisible(false);
        btnPlayAgain.setVisible(false);
        rectShade.setVisible(false);


        if (this.game == null) {
            throw new IllegalArgumentException("CRASH!");
        }

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
        } else if (event.getSource() == btnQuit){
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.QUIT);
        } else if (event.getSource() == btnPlayAgain) {
           onReset();
           btnPlayAgain.setVisible(false);
           btnQuit.setVisible(false);
           rectShade.setVisible(false);
           lblWinner.setVisible(false);
           lblIntro.setVisible(true);
           lblDealerTotal.setVisible(false);
           lblPlayerTotal.setVisible(false);
           dealerFlowPane.setVisible(false);
           playerFlowPane.setVisible(false);

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
                double currentPot = Double.parseDouble(lblPot.getText());
                newPot = currentPot + 1;

                // Get the current balance
                currentBalance = Double.parseDouble(lblChipTotal.getText());
                newBalance = currentBalance - 1;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Double.toString(newPot));
                lblChipTotal.setText(Double.toString(newBalance));
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
                double currentPot = Double.parseDouble(lblPot.getText());
                newPot = currentPot + 5;

                // Get the current balance
                currentBalance = Double.parseDouble(lblChipTotal.getText());
                newBalance = currentBalance - 5;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Double.toString(newPot));
                lblChipTotal.setText(Double.toString((double) newBalance));
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
                double currentPot = Double.parseDouble(lblPot.getText());
                newPot = currentPot + 25;

                // Get the current balance
                currentBalance = Double.parseDouble(lblChipTotal.getText());
                newBalance = currentBalance - 25;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Double.toString(newPot));
                lblChipTotal.setText(Double.toString((double) newBalance));
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
                double currentPot = Double.parseDouble(lblPot.getText());
                newPot = currentPot + 100;

                // Get the current balance
                currentBalance = Double.parseDouble(lblChipTotal.getText());
                newBalance = currentBalance - 100;

                // Check if the new pot value exceeds the balance
                if (newBalance < 0) {
                    throw new NegativeBalanceException("Not enough funds for this bet!");
                }

                // Updates the pot label and balance label
                lblPot.setText(Double.toString(newPot));
                lblChipTotal.setText(Double.toString((double) newBalance));
            }
        }
    }

    /**
     * In this method when the deal button is pressed it locks
     * the players bet in and deals the cards.
     */
    @FXML
    void onDeal() {
        updateDealerFlowPane();
        updatePlayerFlowPane();
        lblWinner.setVisible(false);
        lblDealerTotal.setVisible(false);
        lblPlayerTotal.setVisible(false);
        lblIntro.setVisible(false);
        double bet = Double.parseDouble(lblPot.getText());
        if (bet>0) {
            gameStarted = true;
            game.placeBet(bet);

            // after the deal button is pressed, it is disabled
            btnDeal.setVisible(false);

            // Deals cards to player and dealer
            game.dealHand();
            updateTotal();
            lblDealerTotal.setVisible(false);
            lblPlayerTotal.setVisible(true);

            updateDealerFlowPane();
            updatePlayerFlowPane();

            // and hit and stand button are visible.
            standButton.setVisible(true);
            hitButton.setVisible(true);
        }

    }

    /**
     * When the hit button is pressed, the dealer will deal the player
     * a new card.
     **/
    @FXML
    void onHit() {
        game.playerHit();
        updatePlayerFlowPane();
        updateTotal();
        if (playerHand.best()>21) {
            hitButton.setVisible(false);
            standButton.setVisible(false);
            onStand();
        }
    }

    /**
     * When the stand button is pressed, the dealer will stop dealing to
     * the user and deal itself to try and get 21. Then the sum of the players
     * and dealers hands will then be calculated and returned. As well as dealing with
     * beats.
     */
    @FXML
    void onStand() {
        // Player stops getting cards from dealer
        game.playerStand();

        // Game class calculates hand totals
        game.evaluateHands();

        // and hit and stand button are no longer visible.
        standButton.setVisible(false);
        hitButton.setVisible(false);
        updateTotal();
        winState = game.getWin();
        updateDealerFlowPane();
        lblDealerTotal.setVisible(true);
        game.handleWinner();
        currentBalance = game.getPlayerMoney();
        System.out.println(currentBalance);
        // give bets to dealer
        bank += newPot;
        // Updates the pot label and balance label
        lblPot.setText(Double.toString(resetPot));
        lblChipTotal.setText(Double.toString(currentBalance));


        /**
         * Calculate bets after scores have been calculated
         */
        // Player Busts
        if (winState == WinState.BUST){
            lblWinner.setText("BUST!");
        }
        // Player Loss
        else if (winState == WinState.LOSS){
            lblWinner.setText("Dealer Wins.");
            // Player Win
        } else if (winState == WinState.WIN){
            lblWinner.setText("You win!");
            // Player Blackjack
        } else if (winState == WinState.BLACKJACK) {
            lblWinner.setText("Blackjack!!!");

            // Tie
        } else if (winState == WinState.PUSH) {
            lblWinner.setText("Push");
        }
        int dealerTotal = game.getDealerTotal();
        lblWinner.setVisible(true);
        lblDealerTotal.setVisible(true);
        lblDealerTotal.setText(Integer.toString(dealerTotal));
        updatePlayerFlowPane();
        updateDealerFlowPane();
        rectShade.setVisible(true);
        btnQuit.setVisible(true);
        btnPlayAgain.setVisible(true);
        onReset();
    }

    @FXML
    void onReset() {
        game.reset();
        gameStarted = false;

        hitButton.setVisible(false);
        standButton.setVisible(false);
        btnDeal.setVisible(true);


    }

    @FXML
    void updateTotal(){
        int playerTotal = game.getPlayerTotal();
        lblPlayerTotal.setText(Integer.toString(playerTotal));

    }




    /**
     * Code from https://github.com/nalabrie/Blackjack/blob/master/src/Blackjack/Controller.java
     * Creates/updates the card images representing the dealer's hand inside the 'dealerFlowPane' container.
     *
     */
    private void updateDealerFlowPane() {
        dealerHand = game.getDealerHand();
        dealerFlowPane.setVisible(true);
        dealerFlowPane.getChildren().clear();

        if (dealerHand.getSize()>0) {
            // add all cards in the dealer's hand to the FlowPane as images
            for (int i = 0; i < dealerHand.getSize(); i++) {
                // only add card when it hasn't been created yet (more efficient than overwriting the same image every time)
                Card card = dealerHand.getCard(i);
                InputStream frontDealerCard;
                if (card.getVisibility()) {
                    frontDealerCard = getClass().getResourceAsStream("images/cards/" + card.rank().name() + card.suit() + ".png");
                } else {
                    frontDealerCard = getClass().getResourceAsStream("images/cards/back.png");
                }
                assert frontDealerCard != null;
                Image cardImage = new Image(frontDealerCard);
                dealerImageView[i] = new ImageView();
                dealerImageView[i].setImage(cardImage);
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
        playerHand = game.getPlayerHand();
        playerFlowPane.setVisible(true);
        playerFlowPane.getChildren().clear();

        // add all cards in the player's hand to the FlowPane as images
        if (playerHand.getSize()>0) {
            for (int i = 0; i < playerHand.getSize(); i++) {
                // only add card when it hasn't been created yet (more efficient than overwriting the same image every time)
                //  THANK YOU PROFESSOR KING!!!
                InputStream frontPlayerCard = getClass().getResourceAsStream("images/cards/" + playerHand.getCard(i).rank().name() + playerHand.getCard(i).suit() + ".png");
                assert frontPlayerCard != null;
                Image card = new Image(frontPlayerCard);
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
package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.team04.blackjackmvc.model.Game;

public class BlackJackLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGo;

    @FXML
    private Label lblRemainingBalance;

    @FXML
    private TextField txtFieldName;

    /**
     * Initializing a game
     */
    private Game game;

    private int balance = 500;

    @FXML
    void initialize() {
        assert btnGo != null : "fx:id=\"btnGo\" was not injected: check your FXML file 'blackJackLogin.fxml'.";
        assert lblRemainingBalance != null : "fx:id=\"lblRemainingBalance\" was not injected: check your FXML file 'blackJackLogin.fxml'.";
        assert txtFieldName != null : "fx:id=\"txtFieldName\" was not injected: check your FXML file 'blackJackLogin.fxml'.";

    }

    @FXML
    void onName(){
        lblRemainingBalance.setText(Integer.toString(balance));
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
        Stage stage = (Stage) btnGo.getScene().getWindow();

        if (event.getSource() == btnGo) {
            // Creates a new game and deck
            game = new Game();
            game.start();
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.PLAY);
        }
    }
}

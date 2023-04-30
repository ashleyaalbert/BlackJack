package org.team04.blackjackmvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BlackjackGameOverContoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeButton;

    @FXML
    private Label lblEndBalance;

    @FXML
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'blackJackGameOver.fxml'.";
        assert lblEndBalance != null : "fx:id=\"lblEndBalance\" was not injected: check your FXML file 'blackJackGameOver.fxml'.";
        lblEndBalance.setVisible(false);
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

        if (event.getSource() == homeButton)
            blackjackMain.loadSceneOnStage(stage, FXMLScenes.WELCOME);

    }

    @FXML
    void setBalance(){
        //lblEndBalance.setText();
        lblEndBalance.setVisible(true);

    }
}


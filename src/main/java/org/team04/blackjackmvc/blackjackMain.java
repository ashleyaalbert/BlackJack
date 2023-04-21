/**
 * Used example code from Prof. King's JavaFXExamples for help.
 */
package org.team04.blackjackmvc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Enumeration that captures each scene.
 */
    enum FXMLScenes {
        WELCOME("blackjackWelcome.fxml"),
        PLAY("blackjackPlay.fxml"),
        SETTINGS("blackjackSettings.fxml"),
        BET ("blackjackPlaceBets.fxml"),
        WINNER("blackjackWinner.fxml"),
        PUSH ("blackjackTie.fxml"),
        BLACKJACK("blackjackBlackjack.fxml"),
        LOGIN ("blackJackLogin.fxml"),
        SPLIT("blackjackSplit.fxml");


        private final String fileName;

        FXMLScenes(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }


    public class blackjackMain extends Application {
        @Override
        public void start(Stage stage) {
            loadSceneOnStage(stage, FXMLScenes.WELCOME); // Loads the first scene
            stage.setTitle("Blackjack!");
            stage.show(); // Shows the scene
        }

        public static void main(String[] args) {
            launch();
        }

        /**
         * This is a general static helper method that loads FXML files specified by
         * the{@link FXMLScenes} enumeration and places it on the {@link Stage}
         *
         * @param stage     the {@link Stage} to place the Scene on
         * @param fxmlScene the {@link FXMLScenes} enum that specifies the {@code .fxml} file to load
         */
        public static void loadSceneOnStage(Stage stage, FXMLScenes fxmlScene) {
            FXMLLoader fxmlLoader = new FXMLLoader(blackjackMain.class.getResource(fxmlScene.getFileName()));
            try {
                // Get the root node of the scene graph
                Parent root = fxmlLoader.load();

                // Create the scene for the scene graph
                Scene scene = new Scene(root);

                // Place it on the stage
                stage.setScene(scene);
            }
            catch (IOException e) {
                System.out.println(fxmlScene.getFileName());
                throw new RuntimeException("Could not load " + fxmlScene.getFileName());
            }
        }
    }

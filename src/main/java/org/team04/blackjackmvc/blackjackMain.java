package org.team04.blackjackmvc;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.IOException;

enum FXMLScenes {
    WELCOME("blackjackWelcome.fxml"),
    PLAY("blackjackPlay.fxml"),
    SETTINGS("blackjackSettings.fxml"),
    LOGIN("blackJackLogin.fxml");

    private final String fileName;

    FXMLScenes(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

public class blackjackMain extends Application {
//    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) {
        loadSceneOnStage(stage, FXMLScenes.WELCOME); // Loads the first scene
        stage.setTitle("Blackjack!");
        stage.show(); // Shows the scene

//        // Initialising path of the media file, replace this with your file path
//        String path = "org/team04/blackjackmvc/a-jazz-piano-110481.mp3";
//        Media sound = new Media(getClass().getClassLoader().getResource(path).toString());
//        mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
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
        } catch (IOException e) {
            System.out.println(fxmlScene.getFileName());
            throw new RuntimeException("Could not load " + fxmlScene.getFileName());
        }
    }
}

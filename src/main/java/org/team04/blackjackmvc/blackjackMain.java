package org.team04.blackjackmvc;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.*;

/**
 * Enums for the FXMLScenes
 */
enum FXMLScenes {
    WELCOME("blackjackWelcome.fxml"),
    PLAY("blackjackPlay.fxml"),
    SETTINGS("blackjackSettings.fxml"),
    QUIT ("blackJackGameOver.fxml"),
    LOGIN("blackJackLogin.fxml");

    private final String fileName;

    FXMLScenes(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

/**
 * A main function for black jack
 */
public class blackjackMain extends Application {

    /** A clip used for the sound */
    private static Clip clip;

    /** A boolean to tell if the music is playing or not */
    private static boolean isPlaying = false;

    @Override
    public void start(Stage stage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        loadSceneOnStage(stage, FXMLScenes.WELCOME); // Loads the first scene
        stage.setTitle("Blackjack!");
        stage.show(); // Shows the scene
        // calling the method that plays the music
        musicPlayer("jazz.wav");
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

    /**
     * A method to play the music throughout the game
     *
     * @param fileName as a String of the file name
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public static void musicPlayer(String fileName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // Checking if the music is playing
        if(isPlaying){
            // Stop and close it if so
            clip.stop();
            clip.close();
        }

        // Make the boolean true
        isPlaying = true;

        // Create the path
        String musicPath = "src/main/resources/" + fileName;

        // Getting the file as an audio input stream
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicPath).getAbsoluteFile());

        // Getting the audio clip, opening it, looping it continuously, then setting it as default
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

    public static void musicStopper() {
        // Checking if the music is playing
        if(isPlaying){
            // Stop and close it if so
            clip.stop();
            clip.close();
        }
        isPlaying = false;
    }
}

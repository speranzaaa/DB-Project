package org.karatetrophy.launcher;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
    public static final String SEPARATOR = "/";
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private final Stage startStage = new Stage();

    public void start(final Stage stage) throws IOException {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/Home.fxml"));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        startStage.setScene(scene);
        startStage.setTitle("Karate Trophy Manager");
        startStage.setResizable(true);
        startStage.show();
        startStage.setResizable(false);
    }

    public static void main(final String[] args) {
        launch();
    }
}

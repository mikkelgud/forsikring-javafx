package com.mikkelgud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getClassLoader().getResource("main.fxml");

        if (resource == null) {
            System.err.println("Could not find main.fxml resource!");
            System.exit(0);
        }

        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.ksharovarsky.lab3.ui;/**
 * Created by kostya on 5/13/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class news extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String fxml = "/main.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxml));
        primaryStage.setTitle("LOL");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

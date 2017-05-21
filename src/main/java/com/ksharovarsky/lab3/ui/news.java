package com.ksharovarsky.lab3.ui;/**
 * Created by kostya on 5/13/2017.
 */

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class news extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        final Injector injector = Guice.createInjector(new AppInjector());
        String fxml = "/main.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> type) {
                return injector.getInstance(type);
            }
        });
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxml));
        primaryStage.setTitle("LOL");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}

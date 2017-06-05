package com.ksharovarsky.lab3.ui;/**
 * Created by kostya on 5/13/2017.
 */

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ksharovarsky.lab3.feed.LocalRssFeed;
import com.ksharovarsky.lab3.feed.MultipleRssFeedFetch;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;

public class news extends Application {

    @Inject
    LocalRssFeed feed;
    @FXML
    private Button updateRssButton;

    @FXML
    private NewsTabController newsTabController;

    @Inject
    private MultipleRssFeedFetch fetch;

    public static void main(String[] args) {
        launch(args);
    }

    private void OnFeedMessageChange(Observable obs, Object shouldForceWebFetch) {
        if(shouldForceWebFetch instanceof Boolean && (Boolean) shouldForceWebFetch) {
            try {
                fetch.fetch();
            } catch (Exception e) {
                e.printStackTrace();
            }
            feed.update();
            feed.notifyObservers();
        }
    }

    @FXML
    public void initialize() {
        feed.addObserver(this::OnFeedMessageChange);
        feed.update();
        feed.notifyObservers();
        updateRssButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    fetch.fetch();
                    feed.update();
                    feed.updateIndex();
                    feed.notifyObservers();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(0);
        });
        final Injector injector = Guice.createInjector(new AppInjector());
        String fxml = "/main.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(type -> injector.getInstance(type));
        Parent root = loader.load(getClass().getResourceAsStream(fxml));
        primaryStage.setTitle("RSS feed viewer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

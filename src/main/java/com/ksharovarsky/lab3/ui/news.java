package com.ksharovarsky.lab3.ui;/**
 * Created by kostya on 5/13/2017.
 */

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ksharovarsky.lab3.data.IFeedMessageStore;
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
import javafx.util.Callback;

import java.io.IOException;
import java.util.Calendar;

public class news extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private Button updateRssButton;

    @FXML private NewsTabController newsTabController;

    @Inject
    EventManager eventManager;

    @Inject
    IFeedMessageStore store;

    @FXML
    public void initialize() {
        updateRssButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    fetch.fetch();
                    Calendar oldCalendar = Calendar.getInstance();
                    final int daysToDeprecate = 3;
                    oldCalendar.add(Calendar.DAY_OF_MONTH, -daysToDeprecate);
                    store.removeOlderThan(oldCalendar.getTime());
                    eventManager.getFeedItemsChanged().notifyObservers();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Inject
    private MultipleRssFeedFetch fetch;

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

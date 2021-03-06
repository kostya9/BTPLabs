package com.ksharovarsky.lab3.ui;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.feed.FeedMessage;
import com.ksharovarsky.lab3.feed.LocalRssFeed;
import com.ksharovarsky.lab3.feed.text.StemmedWordList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by kostya on 5/24/2017.
 */
public class NewsTabController implements Initializable {

    @FXML
    public Button resetBtn;

    @FXML
    public Button searchBtn;

    @FXML
    public TextField searchTextField;

    @FXML
    private Label feedText;

    @FXML
    private Label dateText;

    @FXML
    private GridPane newsPane;

    @FXML
    private Button articleButton;

    @FXML
    private Label titleText;

    @FXML
    private Label descriptionText;

    @FXML
    private ListView<FeedMessage> feedMessagesList;

    private ObservableList<FeedMessage> messageObservableList = FXCollections.observableList(new ArrayList<>());

    @Inject
    private LocalRssFeed feed;

    private void OnSelectionChanged() {
        FeedMessage selected = feedMessagesList.getSelectionModel().getSelectedItem();
        if(selected == null)
            return;
        descriptionText.setText(selected.getDescription());
        titleText.setText(selected.getTitle());
        feedText.setText(selected.getRssChannel().getName());

        DateFormat formatter = new SimpleDateFormat("yyyy MM dd, hh:mm");
        dateText.setText(formatter.format(selected.getPubDate()));
    }


    private void OnFeedMessagesChange() {
        messageObservableList = FXCollections.observableList(new ArrayList<>());
        messageObservableList.addAll(feed.getMessages());
        feedMessagesList.setItems(messageObservableList);
        if(!messageObservableList.stream().findAny().isPresent())
            newsPane.visibleProperty().setValue(false);
        else {
            newsPane.visibleProperty().setValue(true);
            feedMessagesList.getSelectionModel().select(0);
        }



    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(searchTextField.getText().split(StemmedWordList.STRING_SPLIT_REGEX).length > 1)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Can search by one word only",
                            ButtonType.OK);
                    alert.setHeaderText("Only one word");
                    alert.show();
                    return;
                }

                feed.search(searchTextField.getText());
                feed.notifyObservers();
            }
        });

        resetBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                feed.reset();
                feed.notifyObservers();
                searchTextField.setText("");
            }
        });
        articleButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(Desktop.isDesktopSupported())
                {
                    try {
                        Desktop.getDesktop().browse(new URI(feedMessagesList.getSelectionModel().getSelectedItem().getLink()));
                    }
                    catch (URISyntaxException | IOException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Sorry, the URL from the feed was incorrect.",
                                ButtonType.OK);
                        alert.setHeaderText(null);
                        alert.setTitle("Invalid URL");
                    }
                }
            }
        });

        feedMessagesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FeedMessage>() {
            @Override
            public void changed(ObservableValue<? extends FeedMessage> observable, FeedMessage oldValue, FeedMessage newValue) {
                OnSelectionChanged();
            }
        });

        OnFeedMessagesChange();
        feed.addObserver((Observable o, Object arg) -> OnFeedMessagesChange());

        feedMessagesList.setCellFactory(new Callback<ListView<FeedMessage>, ListCell<FeedMessage>>() {
            @Override
            public ListCell<FeedMessage> call(ListView<FeedMessage> param) {
                return new ListCell<FeedMessage>() {
                    @Override
                    protected void updateItem(FeedMessage message, boolean empty) {
                        super.updateItem(message, empty);
                        if(empty) {
                            setGraphic(null);
                        }
                        else if(message != null) {
                            Label  text = new Label(message.getTitle());
                            text.setWrapText(true);
                            text.setPrefWidth(feedMessagesList.getWidth() - 30);
                            setGraphic(text);
                        }
                    }
                };
            }
        });
    }
}

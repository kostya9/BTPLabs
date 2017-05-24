package com.ksharovarsky.lab3.ui;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IRssChannelStore;
import com.ksharovarsky.lab3.feed.RssChannel;
import com.ksharovarsky.lab3.feed.WebRssFeed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by kostya on 5/21/2017.
 */
public class RssChannelsTabController implements Initializable {
    @FXML private TextField nameField;
    @FXML private TextField urlField;
    @FXML private Button addButton;

    @FXML private TableView<RssChannel> tableChannels;
    @FXML TableColumn<RssChannel, String> nameTableColumn;
    @FXML TableColumn<RssChannel, String> urlTableColumn;
    @FXML TableColumn<RssChannel, String> removeTableColumn;

    private ObservableList<RssChannel> channelsObservableList = FXCollections.observableList(new ArrayList<>());

    @Inject private IRssChannelStore store;

    @Inject
    EventManager eventManager;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<RssChannel, String>("name"));
        urlTableColumn.setCellValueFactory(new PropertyValueFactory<RssChannel, String>("url"));

        channelsObservableList.addAll(store.getAllRssChannels());
        tableChannels.setItems(channelsObservableList);

        removeTableColumn.setCellFactory(new Callback<TableColumn<RssChannel, String>, TableCell<RssChannel, String>>() {
            @Override
            public TableCell<RssChannel, String> call(TableColumn<RssChannel, String> param) {
                final TableCell<RssChannel, String> cell = new TableCell<RssChannel, String>()
                {
                    final Button btn = new Button( "Remove" );

                    @Override
                    public void updateItem( String item, boolean empty )
                    {
                        super.updateItem( item, empty );
                        if ( empty )
                        {
                            setGraphic( null );
                            setText( null );
                        }
                        else
                        {
                            btn.setOnAction( ( ActionEvent event ) ->
                            {
                                RssChannel channel = getTableView().getItems().get( getIndex() );
                                try{
                                    Alert alert = new Alert(Alert.AlertType.WARNING,
                                            "Are you sure that you want to delete this channel? All corresponding news will be deleted too.",
                                            ButtonType.OK, ButtonType.CANCEL);
                                    alert.setHeaderText(null);
                                    alert.setTitle("Delete channel");
                                    Optional<ButtonType> type= alert.showAndWait();
                                    if(type.get() != ButtonType.OK)
                                        return;
                                    store.removeRssChannel(channel.getId());
                                }
                                catch (Exception e) {
                                    System.err.println(String.format("Could not delete channel with id %s", channel.getId()));
                                    return;
                                }

                                eventManager.getFeedItemsChanged().notifyObservers();
                                channelsObservableList.remove(channel);
                            } );
                            setGraphic( btn );
                            setText( null );
                        }
                    }
                };
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                RssChannel channel;
                try {
                    if(channelsObservableList.stream().anyMatch(obj -> obj.getUrl().toLowerCase().trim().equals(urlField.getText().toLowerCase().trim())))
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This url is already used!", ButtonType.OK);
                        alert.setHeaderText(null);
                        alert.setTitle("Invalid URL");
                        alert.showAndWait();
                        return;
                    }
                    WebRssFeed feed = new WebRssFeed(urlField.getText());
                    if(!feed.IsValid()){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This url does not contain valid RSS!", ButtonType.OK);
                        alert.setHeaderText(null);
                        alert.setTitle("Invalid URL");
                        alert.showAndWait();
                        return;
                    }
                    channel = new RssChannel(nameField.getText().trim(), urlField.getText().trim());
                    store.addRssChannel(channel);
                }
                catch (Exception e) {
                    System.err.println("Could not add new rss channel");
                    return;
                }
                channelsObservableList.add(channel);
            }
        });
    }
}

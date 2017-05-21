package com.ksharovarsky.lab3.ui;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IRssChannelStore;
import com.ksharovarsky.lab3.model.RssChannel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * Created by kostya on 5/21/2017.
 */
public class RssChannelsTabController {
    @FXML private TextField nameField;
    @FXML private TextField urlField;
    @FXML private Button addButton;

    @FXML private TableView<RssChannel> tableChannels;
    @FXML TableColumn<RssChannel, String> nameTableColumn;
    @FXML TableColumn<RssChannel, String> urlTableColumn;
    @FXML TableColumn<RssChannel, String> removeTableColumn;

    private ObservableList<RssChannel> channelsObservableList = FXCollections.observableList(new ArrayList<>());

    @Inject private IRssChannelStore store;

    @FXML
    public void initialize() {
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
                                    store.removeRssChannel(channel.getId());
                                }
                                catch (Exception e) {
                                    System.err.println(String.format("Could not delete person with id %s", channel.getId()));
                                    return;
                                }

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

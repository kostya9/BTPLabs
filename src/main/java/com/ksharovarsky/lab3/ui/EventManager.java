package com.ksharovarsky.lab3.ui;

import java.util.Observable;

/**
 * Created by kostya on 5/24/2017.
 */
public class EventManager {
    private Observable feedsItemsChanged;

    public EventManager() {
        feedsItemsChanged = new Observable() {
            @Override
            public void notifyObservers() {
                this.setChanged();
                super.notifyObservers();
            }
        };
    }

    public Observable getFeedItemsChanged() {
        return feedsItemsChanged;
    }
}

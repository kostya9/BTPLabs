package com.ksharovarsky.lab3.feed;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IFeedMessageStore;

import java.util.*;

/**
 * Created by kostya on 5/24/2017.
 */
public class LocalRssFeed extends Observable {
    private IFeedMessageStore store;
    private List<FeedMessage> messages = new ArrayList<>();

    public Date getOldDate() {
        Calendar oldCalendar = Calendar.getInstance();
        final int daysToDeprecate = 3;
        oldCalendar.add(Calendar.DAY_OF_MONTH, -daysToDeprecate);
        return oldCalendar.getTime();
    }

    @Inject
    public LocalRssFeed(IFeedMessageStore store) {
        this.store = store;
    }

    @Override
    public void notifyObservers(Object shouldForceWebFetch) {
        if(shouldForceWebFetch != null && !(shouldForceWebFetch instanceof Boolean))
            throw new IllegalArgumentException("Argument cannot be not bolean. It represents shouldForceWebFetch");
        if(shouldForceWebFetch != null && (Boolean) shouldForceWebFetch) {
            setChanged();
        }
        super.notifyObservers(shouldForceWebFetch);
    }

    public void update() {
        store.removeOlderThan(getOldDate());
        messages = store.getAllFeedMessages();
        setChanged();
    }

    public List<FeedMessage> getMessages() {
        return messages;
    }
}

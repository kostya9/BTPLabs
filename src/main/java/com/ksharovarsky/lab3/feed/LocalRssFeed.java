package com.ksharovarsky.lab3.feed;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IFeedMessageStore;
import com.ksharovarsky.lab3.feed.text.Index;
import com.ksharovarsky.lab3.feed.text.StemmedWordList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kostya on 5/24/2017.
 */
public class LocalRssFeed extends Observable {
    private IFeedMessageStore store;
    private List<FeedMessage> messages = new ArrayList<>();
    private Index index;

    public Date getOldDate() {
        Calendar oldCalendar = Calendar.getInstance();
        final int daysToDeprecate = 10;
        oldCalendar.add(Calendar.DAY_OF_MONTH, -daysToDeprecate);
        return oldCalendar.getTime();
    }

    @Inject
    public LocalRssFeed(IFeedMessageStore store, Index index) {
        this.store = store;
        this.index = index;
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

    public void updateIndex() {
        List<FeedMessage> messages = store.getAllFeedMessages();
        for(FeedMessage message : messages) {
            index.update(message, new StemmedWordList(message));
        }
    }

    public void update() {
        store.removeOlderThan(getOldDate());
        reset();
    }

    public void reset() {
        messages = store.getAllFeedMessages();
        setChanged();
    }

    public void search(String text) {
        List<String> ids = index.getTopTenFeedMessageIds(text);
        messages = ids.stream().map(i -> store.getFeedMessage(i)).collect(Collectors.toList());
        setChanged();
    }

    public List<FeedMessage> getMessages() {
        return messages;
    }
}

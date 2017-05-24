package com.ksharovarsky.lab3.feed;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IFeedMessageStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kostya on 5/24/2017.
 */
public class LocalRssFeed {
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

    public void update() {
        store.removeOlderThan(getOldDate());
        messages = store.getAllFeedMessages();
    }

    public List<FeedMessage> getMessages() {
        return messages;
    }
}

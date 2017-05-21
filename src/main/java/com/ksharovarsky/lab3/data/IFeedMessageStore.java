package com.ksharovarsky.lab3.data;

import com.ksharovarsky.lab3.parse.FeedMessage;

/**
 * Created by kostya on 5/20/2017.
 */
public interface IFeedMessageStore {

    void addFeedMessage(FeedMessage message);
    void removeFeedMessage(String id);
    FeedMessage getFeedMessage(String id);
}

package com.ksharovarsky.lab3.data;

import com.ksharovarsky.lab3.feed.FeedMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by kostya on 5/29/2017.
 */
public interface IMessageIndexStore {
    void updateIndex(FeedMessage message, Map<String, Long> frequencies);
    List<String> getIndexForWord(String word);
}

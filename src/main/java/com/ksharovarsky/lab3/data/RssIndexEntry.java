package com.ksharovarsky.lab3.data;

import com.ksharovarsky.lab3.feed.FeedMessage;

/**
 * Created by kostya on 6/5/2017.
 */
public class RssIndexEntry {
    private int id;
    private String word;
    private int frequency;
    private FeedMessage feedMessage;

    public RssIndexEntry() {

    }
    public RssIndexEntry(String word, int frequency, FeedMessage message) {
        this.word = word;
        this.frequency = frequency;
        this.feedMessage = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public FeedMessage getFeedMessage() {
        return feedMessage;
    }

    public void setFeedMessage(FeedMessage feedMessage) {
        this.feedMessage = feedMessage;
    }
}

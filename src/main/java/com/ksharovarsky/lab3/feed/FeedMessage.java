package com.ksharovarsky.lab3.feed;

import java.util.Date;

/**
 * Created by kostya on 5/14/2017.
 */
public class FeedMessage {
    private String id;
    private String title;
    private String description;
    private Date pubDate;
    private String link;
    private RssChannel rssChannel;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeedMessage() {

    }

    public FeedMessage(String id, String title, String description, Date pubDate, String link, RssChannel rssChannel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.rssChannel = rssChannel;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public RssChannel getRssChannel() {
        return rssChannel;
    }

    public void setRssChannel(RssChannel rssChannel) {
        this.rssChannel = rssChannel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

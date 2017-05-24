package com.ksharovarsky.lab3.feed;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IFeedMessageStore;
import com.ksharovarsky.lab3.data.IRssChannelStore;
import com.ksharovarsky.lab3.model.RSS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by kostya on 5/22/2017.
 */
public class MultipleRssFeedFetch {
    private IFeedMessageStore messageStore;
    private IRssChannelStore channelStore;

    @Inject
    public MultipleRssFeedFetch(IFeedMessageStore messageStore, IRssChannelStore channelStore) {
        this.messageStore = messageStore;
        this.channelStore = channelStore;
    }

    public void fetch() throws Exception{
        List<RssChannel> channels = channelStore.getAllRssChannels();
        for (RssChannel channel: channels) {
            WebRssFeed feed = new WebRssFeed(channel.getUrl());
            RSS rss = feed.Acquire();
            rss.channel.items.stream()
                    .filter(item -> !messageStore.exists(item.guId))
                    .forEach(item -> {
                        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
                        Date pubDate = null;
                        try {
                            pubDate = format.parse(item.pubDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return;
                        }
                        FeedMessage message = new FeedMessage(item.guId, item.title, item.description, pubDate, item.link, channel);
                        messageStore.addFeedMessage(message);
            });
        }
    }
}

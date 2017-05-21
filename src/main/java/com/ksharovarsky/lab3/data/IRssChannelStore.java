package com.ksharovarsky.lab3.data;

import com.ksharovarsky.lab3.model.RssChannel;

import java.util.List;

/**
 * Created by kostya on 5/21/2017.
 */
public interface IRssChannelStore {
    List<RssChannel> getAllRssChannels();
    int addRssChannel(RssChannel channel);
    void removeRssChannel(int id);
}

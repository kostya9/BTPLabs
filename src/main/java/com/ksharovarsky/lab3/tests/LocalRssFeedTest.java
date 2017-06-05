package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.data.IFeedMessageStore;
import com.ksharovarsky.lab3.feed.FeedMessage;
import com.ksharovarsky.lab3.feed.LocalRssFeed;
import com.ksharovarsky.lab3.feed.text.Index;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by kostya on 6/5/2017.
 */
public class LocalRssFeedTest {

    public static List<FeedMessage> messages =new ArrayList<FeedMessage>() {{
        add(new FeedMessage("id", "title", "description", null, "link", null));
        add(new FeedMessage("id", "зомби", "кривой", null, "link", null));
    }};

    @Test
    public void testUpdate() {
        IFeedMessageStore store = mock(IFeedMessageStore.class);
        Index index = mock(Index.class);
        when(store.getAllFeedMessages()).thenReturn(messages);
        LocalRssFeed feed = new LocalRssFeed(store, index);
        feed.update();
        assertEquals(feed.getMessages(), messages);
    }

    @Test
    public void testUpdateIndex() {
        IFeedMessageStore store = mock(IFeedMessageStore.class);
        Index index = mock(Index.class);
        when(store.getAllFeedMessages()).thenReturn(messages);
        LocalRssFeed feed = new LocalRssFeed(store, index);
        feed.updateIndex();

        verify(index, times(1)).update(messages.get(0), new ArrayList<String>(){{add("titl"); add("descript");}});
        verify(index, times(1)).update(messages.get(1), new ArrayList<String>(){{add("зомб"); add("крив");}});
    }

    @Test
    public void testSearch() {
        IFeedMessageStore store = mock(IFeedMessageStore.class);
        Index index = mock(Index.class);
        when(index.getTopTenFeedMessageIds("крив")).thenReturn(new ArrayList<String>(){{add("id");}});
        when(store.getFeedMessage("id")).thenReturn(messages.get(0));
        LocalRssFeed feed = new LocalRssFeed(store, index);
        feed.search("крив");

        assertEquals(new ArrayList<FeedMessage>(){{add(messages.get(0));}}, feed.getMessages());
    }

}

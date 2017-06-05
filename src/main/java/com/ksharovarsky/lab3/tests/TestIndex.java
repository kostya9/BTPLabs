package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.data.IMessageIndexStore;
import com.ksharovarsky.lab3.feed.FeedMessage;
import com.ksharovarsky.lab3.feed.text.Index;
import com.ksharovarsky.lab3.feed.text.StopWordFilter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by kostya on 6/5/2017.
 */
public class TestIndex {
    @Test
    public void testUpdate() {
        IMessageIndexStore store = mock(IMessageIndexStore.class);

        FeedMessage message = new FeedMessage("", "", "", null, "", null);
        StopWordFilter filter = new StopWordFilter(new ArrayList<String>(){{add("один");add("два"); add("три");}});
        Index index = new Index(filter, store);

        index.update(message, new ArrayList<String>(){{add("один"); add("два");add("крив"); add("крив"); add("четыре");}});
        verify(store).updateIndex(message, new HashMap<String, Long>(){{put("крив", (long) 2); put("четыре", (long)1);}});
    }

    @Test
    public void testGetTopTenFeedMessageIds() {
        IMessageIndexStore store = mock(IMessageIndexStore.class);
        List<String> ids = new ArrayList<String>(){{add("id1");add("id2");}};
        when(store.getIndexForWord("крив")).thenReturn(ids);
        when(store.getIndexForWord("dodg")).thenReturn(ids);
        FeedMessage message = new FeedMessage("", "", "", null, "", null);
        StopWordFilter filter = new StopWordFilter(new ArrayList<String>(){{add("один");add("два"); add("три");}});
        Index index = new Index(filter, store);

        assertEquals(ids, index.getTopTenFeedMessageIds("кривой"));
        assertEquals(ids, index.getTopTenFeedMessageIds("dodging"));
    }


}

package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.feed.FeedMessage;
import com.ksharovarsky.lab3.feed.WordFrequency;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by kostya on 5/14/2017.
 */
public class FeedMessageTest {
    private FeedMessage message;

    @Before
    public void initFeedMessage() {
        message = new FeedMessage("id", "title some", "some words for some, description title!", new Date());
    }

    @Test
    public void wordFrequencyPopulation() {
        Map<String, WordFrequency> frequencies = message.calculateWordFrequencies();
        assertEquals(1, frequencies.get("words").getFrequency());
        assertEquals(2, frequencies.get("title").getFrequency());
        assertNull(frequencies.get(" "));
        assertEquals(3, frequencies.get("some").getFrequency());
    }

    @Test
    public void wordFrequencyOrder() {
        Map<String, WordFrequency> frequencies = message.calculateWordFrequencies();
        WordFrequency first = frequencies.values().stream().findFirst().get();
        WordFrequency second = frequencies.values().stream().filter(w -> !Objects.equals(w.getWord(), first.getWord())).findFirst().get();

        assertEquals("some", first.getWord());
        assertEquals("title", second.getWord());
    }
}

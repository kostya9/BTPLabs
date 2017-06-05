package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.feed.FeedMessage;
import com.ksharovarsky.lab3.feed.text.StemmedWordList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kostya on 6/5/2017.
 */
public class StemmerTest {

    @Test
    public void StemTest() {
        String word = "beaches";
        String word1 = "benched";
        StemmedWordList list = new StemmedWordList(new FeedMessage("1", word, word1, null, null, null));

        assertEquals("beach", list.get(0));
        assertEquals("bench", list.get(1));
    }

    @Test
    public void RussianStemTest() {
        String word = "Мечты";
        String word1 = "Грабили грабитель грабители";
        StemmedWordList list = new StemmedWordList(new FeedMessage("1", word, word1, null, null, null));

        assertEquals("мечт", list.get(0));
        assertEquals("граб", list.get(1));
        assertEquals("грабител", list.get(2));
        assertEquals("грабител", list.get(3));
    }
}

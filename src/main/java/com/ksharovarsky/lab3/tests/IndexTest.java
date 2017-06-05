package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.feed.text.StopWordFilter;
import com.ksharovarsky.lab3.feed.text.TextPreprocess;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by kostya on 5/29/2017.
 */
public class IndexTest {

    @Test
    public void testFilterWords() {
        StopWordFilter filter = new StopWordFilter(Arrays.asList("word", "test", "fork"));

        List<String> inputList = Arrays.asList("work", "word", "ford", "fork", "lock", "test", "test1", "tes");

        List<String> expectedList = Arrays.asList("work", "ford", "lock", "test1", "tes");

        assertEquals(expectedList, filter.apply(expectedList.stream()).collect(Collectors.toList()));
    }

    @Test
    public void testRemoveXmlTags() {
        String text = "<sdfsdffd>test1</sdfsdffd> <a href=\"\">link</a> wow";
        TextPreprocess preprocess = new TextPreprocess();

        String expected = "test1 link wow";
        assertEquals(expected, preprocess.removeXmlTags(text));
    }

    @Test
    public void addParagraphs() {
        String text = "today </p>tomorrow now </p> past</p>nowadays";

        TextPreprocess preprocess = new TextPreprocess();
        String expected ="   today\n   tomorrow now\n   past\n   nowadays";

        assertEquals(expected, preprocess.addParagraphs(text));
    }

    @Test
    public void decodeHtml() {
        String text = "test&nbsp; test1 &amp;";

        TextPreprocess preprocess = new TextPreprocess();
        String expected = "test\u00A0 test1 &";

        assertEquals(expected, preprocess.decodeHtml(text));
    }
}

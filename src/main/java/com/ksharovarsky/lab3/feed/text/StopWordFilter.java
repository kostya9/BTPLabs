package com.ksharovarsky.lab3.feed.text;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by kostya on 5/29/2017.
 */
public class StopWordFilter {
    private Set<String> words;

    public StopWordFilter(List<String> words) {
        this.words = new HashSet<>(words);
    }

    public Stream<String> apply(Stream<String> inputStream) {
        return inputStream.filter(word -> !words.contains(word));
    }

    public boolean contains(String word) {
        return words.contains(word);
    }
}

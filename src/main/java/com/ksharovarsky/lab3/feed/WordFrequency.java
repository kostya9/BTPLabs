package com.ksharovarsky.lab3.feed;

import java.util.Objects;

/**
 * Created by kostya on 5/14/2017.
 */
public class WordFrequency implements Comparable {
    private String word;
    private int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Object o) {
        WordFrequency right = (WordFrequency)o;
        int result = ((Integer)frequency).compareTo(right.frequency);

        if(result != 0)
            return result;

        if(Objects.equals(right.word, word))
            return 0;

        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof WordFrequency))
            return false;

        WordFrequency right = (WordFrequency)o;

        return right.frequency == frequency && Objects.equals(right.word, word);
    }

    @Override
    public int hashCode() {
        return 123 * ((Integer)frequency).hashCode() + word.hashCode();
    }
}

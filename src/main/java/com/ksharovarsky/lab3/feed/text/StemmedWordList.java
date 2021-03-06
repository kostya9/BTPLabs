package com.ksharovarsky.lab3.feed.text;

import com.ksharovarsky.lab3.feed.FeedMessage;
import org.tartarus.snowball.SnowballStemmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by kostya on 5/29/2017.
 */
public class StemmedWordList extends ArrayList<String> {
    public static final String STRING_SPLIT_REGEX = "[ ,!\\.\\?:\"\'-]";

    private SnowballStemmer stemmer;

    public StemmedWordList(FeedMessage message) {
        super();

        String text = message.getTitle() + " " + message.getDescription();
        text = text.toLowerCase();

        StemmerCreator creator = new StemmerCreator();
        stemmer = creator.getStemmer(text);

        String[] words = Stream.of(text.split(STRING_SPLIT_REGEX)).map(String::trim).filter(s -> s != null && !Objects.equals(s, "")).toArray(String[]::new);
        Collections.addAll(this, words);
    }

    @Override
    public boolean add(String s) {
        stemmer.setCurrent(s);
        if(stemmer.stem())
            return super.add(stemmer.getCurrent());
        else
            return super.add(s);
    }
}

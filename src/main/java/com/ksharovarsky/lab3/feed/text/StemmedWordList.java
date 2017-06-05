package com.ksharovarsky.lab3.feed.text;

import com.ksharovarsky.lab3.feed.FeedMessage;
import org.tartarus.snowball.SnowballStemmer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kostya on 5/29/2017.
 */
public class StemmedWordList extends ArrayList<String> {

    private SnowballStemmer stemmer;

    public StemmedWordList(FeedMessage message) {
        super();

        String text = message.getTitle() + " " + message.getDescription();
        text = text.toLowerCase();

        StemmerCreator creator = new StemmerCreator();
        stemmer = creator.getStemmer(text);

        String[] words = text.split("[ ,!\\.\\?]");
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

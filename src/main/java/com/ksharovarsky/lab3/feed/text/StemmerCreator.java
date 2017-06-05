package com.ksharovarsky.lab3.feed.text;

import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;
import org.tartarus.snowball.ext.russianStemmer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kostya on 6/5/2017.
 */
public class StemmerCreator {
    public SnowballStemmer getStemmer(String message) {
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        Matcher matcher = pattern.matcher(message);
        SnowballStemmer stemmer;
        if(matcher.find())
            stemmer = new russianStemmer();
        else
            stemmer = new englishStemmer();

        return stemmer;
    }
}

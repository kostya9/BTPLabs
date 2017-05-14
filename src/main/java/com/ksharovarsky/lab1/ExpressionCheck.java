package com.ksharovarsky.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kostya on 2/25/2017.
 */
public class ExpressionCheck {

    public static final String DefaultRegexPattern = "(\\+[0-9]+[A-K]+)|(\\+[0-9]+[\\^&]+)";

    private Pattern pattern;

    public ExpressionCheck(Pattern pattern) {
        this.pattern = pattern;
    }

    public ExpressionCheck(String regex) {
        this(Pattern.compile(regex));
    }

    public String getRegexPattern() {
        return pattern.pattern();
    }

    public boolean isMatching(String word) {
        Matcher match = pattern.matcher(word);
        return match.matches();
    }

    public Integer[] matchPositions(String text) {
        Matcher match = pattern.matcher(text);
        List<Integer> positions = new ArrayList<Integer>();

        int index = 0;
        while(match.find(index)) {
            index = match.end();
            positions.add(match.start());
        }
        return positions.toArray(new Integer[positions.size()]);
    }
}


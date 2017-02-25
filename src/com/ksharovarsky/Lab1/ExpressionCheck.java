package com.ksharovarsky.Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by kostya on 2/25/2017.
 */
public class ExpressionCheck {

    public static final String DefaultRegexPattern = "(\\+[0-9]+[A-K]+)|(\\+[0-9]+[\\^&]+)";

    private Pattern _pattern;

    public ExpressionCheck(Pattern pattern) {
        _pattern = pattern;
    }

    public ExpressionCheck(String regex) {
        this(Pattern.compile(regex));
    }

    public String getRegexPattern() {
        return _pattern.pattern();
    }

    public boolean isMatching(String word) {
        Matcher match = _pattern.matcher(word);
        return match.matches();
    }

    public Integer[] matchPositions(String text) {
        Matcher match = _pattern.matcher(text);
        List<Integer> positions = new ArrayList<Integer>();

        int index = 0;
        while(match.find(index)) {
            index = match.end();
            positions.add(match.start());
        }
        return positions.toArray(new Integer[positions.size()]);
    }
}


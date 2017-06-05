package com.ksharovarsky.lab3.feed.text;

import com.google.inject.Inject;
import com.ksharovarsky.lab3.data.IMessageIndexStore;
import com.ksharovarsky.lab3.feed.FeedMessage;
import org.tartarus.snowball.SnowballStemmer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kostya on 5/29/2017.
 */
public class Index {
    private StopWordFilter filter;
    private IMessageIndexStore store;

    @Inject
    public Index(StopWordFilter filter, IMessageIndexStore store) {
        this.filter = filter;
        this.store = store;
    }

    public void update(FeedMessage message, List<String> words) {
        Map<String, Long> wordsFrequencies = filter
                .apply(words.stream())
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        store.updateIndex(message, wordsFrequencies);
    }

    public List<String> getTopTenFeedMessageIds(String word) {
        if(filter.contains(word))
            return null;

        List<String> indexes;
        StemmerCreator creator = new StemmerCreator();
        SnowballStemmer stemmer = creator.getStemmer(word);
        stemmer.setCurrent(word);
        if(stemmer.stem()) {
            indexes = store.getIndexForWord(stemmer.getCurrent());
            if(indexes == null || indexes.size() == 0)
                indexes = store.getIndexForWord(word);
        }
        else
            indexes = store.getIndexForWord(word);

        return indexes;
    }
}

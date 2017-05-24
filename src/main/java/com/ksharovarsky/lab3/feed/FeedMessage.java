package com.ksharovarsky.lab3.feed;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by kostya on 5/14/2017.
 */
public class FeedMessage {
    private String id;
    private String title;
    private String description;
    private Date pubDate;
    private String link;
    private RssChannel rssChannel;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeedMessage() {

    }

    public FeedMessage(String id, String title, String description, Date pubDate, String link, RssChannel rssChannel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.rssChannel = rssChannel;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private Map<String, WordFrequency> calculateWordFrequencies(String text) {
        Map<String, Integer> words= new HashMap<String, Integer>();
        String wordRegex = "([^\\d\\W]+)";

        Pattern pattern = Pattern.compile(wordRegex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            String word = matcher.group();
            if(words.containsKey(word))
                words.replace(word, words.get(word) + 1);
            else
                words.put(word, 1);
        }

        return words.entrySet().stream()
                .map(s -> new WordFrequency(s.getKey(), s.getValue()))
                .collect(Collectors.toMap(WordFrequency::getWord, (wordFrequency) -> wordFrequency));
    }

    private Map<String, WordFrequency> mergeMaps(Map<String, WordFrequency> first, Map<String, WordFrequency> second) {
        Map<String, WordFrequency> mergedMap = new TreeMap<String, WordFrequency>();

        for (WordFrequency wordFrequency : first.values()) {
            String word = wordFrequency.getWord();
            WordFrequency value = second.containsKey(word) ?
                    new WordFrequency(word, wordFrequency.getFrequency() + second.get(word).getFrequency()) :
                    wordFrequency;
            mergedMap.put(word, value);
        }

        second.values().stream()
                .filter(v -> !first.containsKey(v.getWord()))
                .forEach(wordFrequency -> {
                    mergedMap.put(wordFrequency.getWord(), wordFrequency);
                });

        return mergedMap;

    }

    /***
     *
     * @return Map that is ordered by the frequency of words. E.g. the first element has the highest number of repeating words in the message.
     */
    public Map<String, WordFrequency> calculateWordFrequencies() {
        Map<String, WordFrequency> titleWords = calculateWordFrequencies(title);
        Map<String, WordFrequency> descriptionWords = calculateWordFrequencies(description);
        Map<String, WordFrequency> mergedMap = mergeMaps(titleWords, descriptionWords);

        return  (Map<String, WordFrequency>)mergedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e -> (Map.Entry<String, WordFrequency>)e)
                .collect(Collectors.toMap(
                        Map.Entry<String, WordFrequency>::getKey,
                        Map.Entry<String, WordFrequency>::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public RssChannel getRssChannel() {
        return rssChannel;
    }

    public void setRssChannel(RssChannel rssChannel) {
        this.rssChannel = rssChannel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

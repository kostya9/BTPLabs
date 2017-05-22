package com.ksharovarsky;

import com.ksharovarsky.lab3.feed.WebRssFeed;

public class Main {
    public static void main(String[] args) {
        WebRssFeed feed = new WebRssFeed("http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
        boolean valid = feed.IsValid();
        System.out.println(valid);

    }
}
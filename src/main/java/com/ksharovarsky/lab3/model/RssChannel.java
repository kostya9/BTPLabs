package com.ksharovarsky.lab3.model;

/**
 * Created by kostya on 5/21/2017.
 */
public class RssChannel {
    private String name;
    private String url;
    private int id;

    private RssChannel() {

    }

    public RssChannel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url.trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;

public class Item {
    public @XmlElement String title;
    public @XmlElement String link;
    public @XmlElement String description;
    public
    @XmlElement
    String pubDate;
    public @XmlElement(name = "guid") String guId;
}

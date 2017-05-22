package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Channel {
    public @XmlElement String title;
    public @XmlElement String link;
    public @XmlElement String description;
    public @XmlElement String language;
    public @XmlElement(name = "item") List<Item> items;
}

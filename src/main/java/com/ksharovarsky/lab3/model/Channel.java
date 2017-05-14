package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Channel {
    @XmlElement String title;
    @XmlElement String link;
    @XmlElement String description;
    @XmlElement String language;
    @XmlElement(name = "item") List<Item> items;
}

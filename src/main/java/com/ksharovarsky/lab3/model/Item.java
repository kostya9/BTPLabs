package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Item {
    public @XmlElement String title;
    public @XmlElement String link;
    public @XmlElement String description;
    public @XmlElement Date pubDate;
    public @XmlElement String guId;
}

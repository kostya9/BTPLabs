package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Item {
    @XmlElement String title;
    @XmlElement String link;
    @XmlElement String description;
    @XmlElement Date pubDate;
    @XmlElement String guId;
}

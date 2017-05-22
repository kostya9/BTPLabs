package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kostya on 5/13/2017.
 */
@XmlRootElement(name="rss")
public class RSS {
    public @XmlElement Channel channel;
}


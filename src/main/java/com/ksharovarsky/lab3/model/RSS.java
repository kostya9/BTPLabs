package com.ksharovarsky.lab3.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by kostya on 5/13/2017.
 */
public class RSS {
    @XmlElement Channel channel;
    @XmlElement String version;
}


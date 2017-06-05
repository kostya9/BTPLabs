package com.ksharovarsky.lab3.feed;

import com.ksharovarsky.lab3.model.RSS;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Created by kostya on 6/6/2017.
 */
public class RssXmlParser {
    public RSS Acquire(InputStream stream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RSS.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (RSS) unmarshaller.unmarshal(stream);
    }
}

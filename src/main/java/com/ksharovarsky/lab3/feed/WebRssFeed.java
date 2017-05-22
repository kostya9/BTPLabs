package com.ksharovarsky.lab3.feed;

import com.ksharovarsky.lab3.model.RSS;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

/**
 * Created by kostya on 5/22/2017.
 */
public class WebRssFeed {
    private String address;

    public WebRssFeed(String address) {
        this.address = address;
    }

    public boolean IsValid() {
        try {
            RSS rss = Acquire();
            if(rss.channel!= null &&
                    rss.channel.items!= null &&
                    rss.channel.items.size() > 0)
                return true;
        }
        catch (Exception e) {
            return false;
        }

        return false;
    }

    public RSS Acquire() throws Exception{
        URL url = new URL(address);
        JAXBContext context = JAXBContext.newInstance(RSS.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        RSS rss = (RSS) unmarshaller.unmarshal(url.openStream());
        return rss;
    }
}

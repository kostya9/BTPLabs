package com.ksharovarsky.lab3.tests;

import com.ksharovarsky.lab3.feed.RssXmlParser;
import com.ksharovarsky.lab3.model.Channel;
import com.ksharovarsky.lab3.model.Item;
import com.ksharovarsky.lab3.model.RSS;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by kostya on 6/6/2017.
 */
public class TestXmlParser {

    @Test
    public void testAquire() throws JAXBException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<rss version=\"2.0\">\n" +
                "\n" +
                "<channel>\n" +
                "  <title>W3Schools Home Page</title>\n" +
                "  <link>https://www.w3schools.com</link>\n" +
                "  <description>Free web building tutorials</description>\n" +
                "  <item>\n" +
                "    <title>RSS Tutorial</title>\n" +
                "    <link>https://www.w3schools.com/xml/xml_rss.asp</link>\n" +
                "    <description>New RSS tutorial on W3Schools</description>\n" +
                "  </item>\n" +
                "  <item>\n" +
                "    <title>XML Tutorial</title>\n" +
                "    <link>https://www.w3schools.com/xml</link>\n" +
                "    <description>New XML tutorial on W3Schools</description>\n" +
                "  </item>\n" +
                "</channel>\n" +
                "\n" +
                "</rss>";
        RssXmlParser parser = new RssXmlParser();
        InputStream stream = new ByteArrayInputStream( xml.getBytes(Charset.defaultCharset()) );
        RSS actual = parser.Acquire(stream);
        RSS expected = new RSS();
        expected.channel = new Channel();
        expected.channel.description = "Free web building tutorials";
        expected.channel.link = "https://www.w3schools.com";
        expected.channel.title = "W3Schools Home Page";
        expected.channel.items = new ArrayList<>();
        expected.channel.items.add(new Item(){
            {title="RSS Tutorial";
            link="https://www.w3schools.com/xml/xml_rss.asp";
            description="New RSS tutorial on W3Schools";}});
        expected.channel.items.add(new Item(){
            {title="XML Tutorial";
                link="https://www.w3schools.com/xml";
                description="New XML tutorial on W3Schools";}});

        assertEquals(expected.channel.description, actual.channel.description);
        assertEquals(expected.channel.link, actual.channel.link);
        assertEquals(expected.channel.title, actual.channel.title);
        assertEquals(expected.channel.items.get(0).description, actual.channel.items.get(0).description);
        assertEquals(expected.channel.items.get(0).title, actual.channel.items.get(0).title);
        assertEquals(expected.channel.items.get(0).link, actual.channel.items.get(0).link);
        assertEquals(expected.channel.items.get(1).description, actual.channel.items.get(1).description);
        assertEquals(expected.channel.items.get(1).link, actual.channel.items.get(1).link);
        assertEquals(expected.channel.items.get(1).title, actual.channel.items.get(1).title);
    }
}

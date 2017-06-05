package com.ksharovarsky.lab3.feed.text;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Collections;

/**
 * Created by kostya on 5/29/2017.
 */
public class TextPreprocess {

    public final int paragraphLength = 3;

    public TextPreprocess() {

    }

    public String decodeHtml(String text) {
        return StringEscapeUtils.unescapeHtml4(text);
    }

    public String addParagraphs(String text) {
        String paragraph = String.join("", Collections.nCopies(paragraphLength, " "));
        return paragraph + text.replaceAll("[ ]*</p>[ ]*", "\n" + paragraph);
    }

    public String removeXmlTags(String text) {
        String xmlRegex = "<[^>]+>";
        return text.replaceAll(xmlRegex, "");
    }
}

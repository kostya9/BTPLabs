package com.ksharovarsky.anagrams;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by kostya on 3/27/2017.
 */
public class Anagrams {

    private Set<String> dictionary;

    public Anagrams(Set<String> dictionary) {
        if(dictionary == null || dictionary.size() == 0)
            throw new IllegalArgumentException("Could not use a null or empty dictionary.");

        this.dictionary = dictionary;
    }

    public SortedSet<String> getAnagrams(String phrase) {
        if(phrase == null)
            throw new IllegalArgumentException("Could not find anagrmas in a null phrase");

        return null;
    }

    public void print(String phrase)
    {
        print(phrase, 0);
    }

    public void print(String phrase, int maxWordsCount)
    {

    }

    public static Anagrams fromFile(String fileName) throws IOException {
        SortedSet<String> set = new TreeSet<String>();
        Files.readAllLines(FileSystems.getDefault().getPath(fileName))
                .stream().forEach(set::add);

        return new Anagrams(set);
    }

}

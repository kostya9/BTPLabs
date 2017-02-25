package com.ksharovarsky.Lab1;


import com.sun.media.sound.InvalidFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by kostya on 2/25/2017.
 */
public abstract class FileMatch<TResult> {
    private Path _filePath;
    protected ExpressionCheck _check;

    public FileMatch(Path filePath, ExpressionCheck check) {
        _filePath = filePath;
        _check = check;
    }

    public TResult[] findMatching() {
        try (BufferedReader reader = Files.newBufferedReader(_filePath)){
            return findMatching(reader);

        }
        catch (IOException e) {
            System.out.println("Could not open the file. Does it exist?");
            return null;
        }
        catch (TextFormatException e) {
            System.out.println("File format is wrong. " + e.getMessage());
            return null;
        }
    }

    public abstract TResult[] findMatching(BufferedReader reader) throws IOException, TextFormatException;
}

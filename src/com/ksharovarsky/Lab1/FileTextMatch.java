package com.ksharovarsky.Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Created by kostya on 2/25/2017.
 */
public class FileTextMatch extends FileMatch<Integer> {

    public static final String DefaultFileName = "text.txt";

    public FileTextMatch(Path filePath, ExpressionCheck check) {
        super(filePath, check);
    }

    @Override
    public Integer[] findMatching(BufferedReader reader) throws IOException {
        StringBuffer text = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null)
        {
            text.append(line).append("\n");
        }
        return _check.matchPositions(text.toString());
    }

    @Override
    public String toString() {
        return "FileTextMatch";
    }
}

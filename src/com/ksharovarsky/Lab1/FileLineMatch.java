package com.ksharovarsky.Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 2/25/2017.
 */
public class FileLineMatch extends FileMatch<String> {

    public static final String DefaultFileName = "lines.txt";

    public FileLineMatch(Path filePath, ExpressionCheck check) {
        super(filePath, check);
    }

    @Override
    public String[] findMatching(BufferedReader reader) throws IOException, TextFormatException {
        List<String> matches = new ArrayList<String>();
        String line;
        while((line = reader.readLine()) != null) {
            if(line.split("\\s+").length != 1)
                throw new TextFormatException("File line has more than 1 word.");

            CheckLine(matches, line.trim());
        }
        return matches.toArray(new String[matches.size()]);
    }

    private void CheckLine(List<String> matches, String line) {
        boolean isMatching = check.isMatching(line);
        if(isMatching)
            matches.add(line);
    }

    @Override
    public String toString() {
        return "FileLineMatch";
    }
}

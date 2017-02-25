package com.ksharovarsky;

import com.ksharovarsky.Lab1.ExpressionCheck;
import com.ksharovarsky.Lab1.FileLineMatch;
import com.ksharovarsky.Lab1.FileMatch;
import com.ksharovarsky.Lab1.FileTextMatch;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<FileMatch> matches = new ArrayList<FileMatch>();
        Path pathLine = FileSystems.getDefault().getPath(FileLineMatch.DefaultFileName);
        Path pathText = FileSystems.getDefault().getPath(FileTextMatch.DefaultFileName);
        matches.add(new FileLineMatch(pathLine, new ExpressionCheck(ExpressionCheck.DefaultRegexPattern)));
        matches.add(new FileTextMatch(pathText, new ExpressionCheck(ExpressionCheck.DefaultRegexPattern)));

        for (FileMatch match : matches) {
            System.out.println(String.format("Current match : %s", match));
            System.out.println("Starting proccessing...");
            Object[] objs = match.findMatching();

            if(objs == null)
            {
                System.out.print("Error occurred. Skipping current matcher.");
                continue;
            }
            
            System.out.println("Proccessing completed successfully.\nOutput:");
            for(Object o : objs) {
                System.out.println(o.toString());
            }
            System.out.println(String.format("Ended match : %s\n", match));
        }
    }
}

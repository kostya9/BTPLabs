package com.ksharovarsky.lab2;

import com.ksharovarsky.lab2.calculation.ExpressionCalculator;

import java.util.Scanner;

/**
 * Created by kostya on 5/13/2017.
 */
public class lab2Main {
    public static void lab2Main(String[] args) throws Exception {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        ExpressionCalculator calculator = new ExpressionCalculator();
        while(true) {
            input = scanner.next();
            if(input.equals("exit"))
                break;
            String output = calculator.calculateOutput(input);
            System.out.println(output);
        }
    }
}

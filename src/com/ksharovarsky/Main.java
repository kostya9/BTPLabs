package com.ksharovarsky;

import com.ksharovarsky.lab2.calculation.ExpressionCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
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
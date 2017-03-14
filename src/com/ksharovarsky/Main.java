package com.ksharovarsky;

import com.ksharovarsky.lab1.ExpressionCheck;
import com.ksharovarsky.lab1.FileLineMatch;
import com.ksharovarsky.lab1.FileMatch;
import com.ksharovarsky.lab1.FileTextMatch;
import com.ksharovarsky.lab1.stateMachine.FiniteStateMachine;
import com.ksharovarsky.lab1.stateMachine.stateImplementation.StatePatternStateMachine;
import com.ksharovarsky.lab1.stateMachine.switchImplementation.SwitchStateMachine;
import com.ksharovarsky.lab1.stateMachine.transitionImplementation.TransitionStateMachine;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {

    static FiniteStateMachine switchMachine = new FiniteStateMachine(new SwitchStateMachine());
    static FiniteStateMachine transitionMachine = new FiniteStateMachine(new TransitionStateMachine());
    static FiniteStateMachine statePatternMachine = new FiniteStateMachine(new StatePatternStateMachine());

    public static void main(String[] args) {
        System.out.println("Correct");
        testInputs(new String[]{"ABCDE_ABCDE", "ABCDEEEE", "ABCDE_1234", "ABCDE1234", "1234"});
        System.out.println("Incorrect");
        testInputs(new String[] {"ABCDE_1234ABC", "ABCDE__1234", "ABCDEabc", "ABCDE_abcde", "ABCDE_", "ABCDE_&&&"});
    }

    private static void testInputs(String[] inputs) {
        for (String input : inputs) {
            testMachines(input);
            System.out.println("");
        }
    }

    private static void testMachines(String test) {
        System.out.println("Switch");
        testMachine(switchMachine, test);

        System.out.println("Transition");
        testMachine(transitionMachine, test);

        System.out.println("State");
        testMachine(statePatternMachine, test);
    }

    private static void testMachine(FiniteStateMachine machine, String test) {
        System.out.println(String.format("Input : %s, Output: %b", test, machine.scanString(test)));
    }

    private void testRegexExpresionCheck() {
        List<FileMatch> matches = new ArrayList<FileMatch>();
        Path pathLine = FileSystems.getDefault().getPath(FileLineMatch.DefaultFileName);
        Path pathText = FileSystems.getDefault().getPath(FileTextMatch.DefaultFileName);
        matches.add(new FileLineMatch(pathLine, new ExpressionCheck(FileLineMatch.DefaultFileName)));
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

package com.ksharovarsky.lab1.tests;

import com.ksharovarsky.lab1.stateMachine.FiniteStateMachine;
import com.ksharovarsky.lab1.stateMachine.StateMachineImplementation;
import com.ksharovarsky.lab1.stateMachine.stateImplementation.StatePatternStateMachine;
import com.ksharovarsky.lab1.stateMachine.switchImplementation.SwitchStateMachine;
import com.ksharovarsky.lab1.stateMachine.transitionImplementation.TransitionStateMachine;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by kostya on 3/14/2017.
 */

@RunWith(Theories.class)
public class FiniteStateMachineTheoriesTest{

    @DataPoints
    public static Object[][] input = {
            {"ABCDE_ABCDE", true} , {"ABCDEEEE", true}, {"ABCDE_1234", true},
            {"ABCDE1234", true}, {"1234", true}, {"_1234", true}, {"_ABCDE", true},
            {"ABCDE_1234ABC", false}, {"ABCDE__1234", false}, {"ABCDEabc", false}, {"ABCDE_abcde", false},
            {"ABCDE_", false}, {"ABCDE_&&&", false}, {"_", false}, {"", false}};

    @DataPoints
    public static StateMachineImplementation[] implementations = new StateMachineImplementation[] {
        new StatePatternStateMachine(),
        new SwitchStateMachine(),
        new TransitionStateMachine()
    };

    @Theory
    public void scanString(StateMachineImplementation implementation, final Object... testData){
        String testString = (String) testData[0];
        boolean expected = (boolean) testData[1];

        FiniteStateMachine machine = new FiniteStateMachine(implementation);
        assertEquals(machine.scanString(testString), expected);
    }
}

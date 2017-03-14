package com.ksharovarsky.lab1.tests;

import com.ksharovarsky.lab1.stateMachine.FiniteStateMachine;
import com.ksharovarsky.lab1.stateMachine.StateMachineImplementation;
import com.ksharovarsky.lab1.stateMachine.stateImplementation.StatePatternStateMachine;
import com.ksharovarsky.lab1.stateMachine.switchImplementation.SwitchStateMachine;
import com.ksharovarsky.lab1.stateMachine.transitionImplementation.TransitionStateMachine;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by kostya on 3/14/2017.
 */
@RunWith(Parameterized.class)
public class FiniteStateMachineParameterizedTest {

    private final String testString;
    private final boolean expected;

    @Parameterized.Parameters(name = "{index} : Result : {1}, Test : {0}")
    public static Collection<Object[]> date() {
        return Arrays.asList(new Object[][] {
                {"ABCDE_ABCDE", true} , {"ABCDEEEE", true}, {"ABCDE_1234", true}, {"ABCDE1234", true}, {"1234", true}, {"_1234", true}, {"_ABCDE", true},
                {"ABCDE_1234ABC", false}, {"ABCDE__1234", false}, {"ABCDEabc", false}, {"ABCDE_abcde", false}, {"ABCDE_", false}, {"ABCDE_&&&", false}, {"_", false}
        });
    }

    public FiniteStateMachineParameterizedTest(String testString, boolean expected) {

        this.testString = testString;
        this.expected = expected;
    }

    @Test
    public void scanString(){
        FiniteStateMachine transitionMachine = new FiniteStateMachine(new TransitionStateMachine());
        FiniteStateMachine switchMachine = new FiniteStateMachine(new SwitchStateMachine());
        FiniteStateMachine stateMachine = new FiniteStateMachine(new StatePatternStateMachine());
        assertEquals(transitionMachine.scanString(testString), expected);
        assertEquals(switchMachine.scanString(testString), expected);
        assertEquals(stateMachine.scanString(testString), expected);
    }

    @Test
    public void reset() {
        FiniteStateMachine transitionMachine = new FiniteStateMachine(new TransitionStateMachine());
        FiniteStateMachine switchMachine = new FiniteStateMachine(new SwitchStateMachine());
        FiniteStateMachine stateMachine = new FiniteStateMachine(new StatePatternStateMachine());

        boolean valueTransition = transitionMachine.scanString(testString);
        boolean valueSwitch = switchMachine.scanString(testString);
        boolean valueState = stateMachine.scanString(testString);

        transitionMachine.reset();
        switchMachine.reset();
        stateMachine.reset();

        boolean afterResetValueTransition = transitionMachine.scanString(testString);
        boolean afterResetValueSwitch = switchMachine.scanString(testString);
        boolean afterResetValueState = stateMachine.scanString(testString);

        assertEquals(valueTransition, afterResetValueTransition);
        assertEquals(valueSwitch, afterResetValueSwitch);
        assertEquals(valueState, afterResetValueState);
    }
}
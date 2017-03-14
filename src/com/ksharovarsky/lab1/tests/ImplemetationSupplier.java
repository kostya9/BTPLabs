package com.ksharovarsky.lab1.tests;

import com.ksharovarsky.lab1.stateMachine.stateImplementation.StatePatternStateMachine;
import com.ksharovarsky.lab1.stateMachine.switchImplementation.SwitchStateMachine;
import com.ksharovarsky.lab1.stateMachine.transitionImplementation.TransitionStateMachine;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.ArrayList;
import java.util.List;

public class ImplemetationSupplier extends ParameterSupplier {
    @Override
    public List getValueSources(ParameterSignature signature) {
        ArrayList result = new ArrayList();
        result.add(PotentialAssignment.forValue("switch", new SwitchStateMachine()));
        result.add(PotentialAssignment.forValue("transition", new TransitionStateMachine()));
        result.add(PotentialAssignment.forValue("statePattern", new StatePatternStateMachine()));
        return result;
    }
}

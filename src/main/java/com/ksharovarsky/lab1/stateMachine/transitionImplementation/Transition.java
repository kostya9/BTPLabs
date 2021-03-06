package com.ksharovarsky.lab1.stateMachine.transitionImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kostya on 3/7/2017.
 */
public class Transition {
    private MachineState state;
    private CharacterType triggerer;
    private MachineState resulState;

    public Transition(MachineState state, CharacterType triggerer, MachineState resulState) {
        this.state = state;
        this.triggerer = triggerer;
        this.resulState = resulState;
    }

    public MachineState getState() {
        return state;
    }

    public CharacterType getTriggerer() {
        return triggerer;
    }

    public MachineState getResulState() {
        return resulState;
    }
}

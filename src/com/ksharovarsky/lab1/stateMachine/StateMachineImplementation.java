package com.ksharovarsky.lab1.stateMachine;

/**
 * Created by kostya on 3/7/2017.
 */
public abstract class StateMachineImplementation {
    public StateMachineImplementation() {
        reset();
    }

    public abstract MachineState nextState(CharacterType type);
    public abstract void reset();
}

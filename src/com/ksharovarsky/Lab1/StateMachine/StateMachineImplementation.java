package com.ksharovarsky.Lab1.StateMachine;

/**
 * Created by kostya on 3/7/2017.
 */
public interface StateMachineImplementation {
    MachineState nextState(CharacterType type);
    void reset();
}

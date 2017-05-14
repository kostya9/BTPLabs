package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;
import com.ksharovarsky.lab1.stateMachine.StateMachineImplementation;

/**
 * Created by kosty on 3/7/2017.
 */
public class StatePatternStateMachine extends StateMachineImplementation{
    private State currentState;

    @Override
    public MachineState nextState(CharacterType type) {
        currentState = currentState.nextState(type);
        return currentState.getMachineState();
    }

    @Override
    public void reset() {
        currentState = State.startingState();
    }
}

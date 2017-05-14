package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public abstract class State {
    private final MachineState state;

    public State(MachineState state) {

        this.state = state;
    }

    public MachineState getMachineState() {
        return state;
    }

    static public State startingState() {
        return new Q0();
    }

    public abstract State nextState(CharacterType type);
}

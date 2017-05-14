package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Q5 extends State {
    public Q5() {
        super(MachineState.Q5);
    }

    @Override
    public State nextState(CharacterType type) {
        return new Error();
    }
}

package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Error extends State {
    public Error() {
        super(MachineState.ERROR);
    }

    @Override
    public State nextState(CharacterType type) {
        return null;
    }
}

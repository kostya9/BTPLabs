package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Q2 extends State {
    public Q2() {
        super(MachineState.Q2);
    }

    @Override
    public State nextState(CharacterType type) {
        if(type == CharacterType.LETTER)
            return new Q3();

        if(type == CharacterType.DIGIT)
            return new Q4();

        return new Error();
    }
}

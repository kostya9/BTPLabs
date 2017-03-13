package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Q4 extends State {
    public Q4() {
        super(MachineState.Q4);
    }

    @Override
    public State nextState(CharacterType type) {
        if(type == CharacterType.DIGIT)
            return new Q4();

        if(type == CharacterType.ENDWORD)
            return new Q5();

        return new Error();
    }
}

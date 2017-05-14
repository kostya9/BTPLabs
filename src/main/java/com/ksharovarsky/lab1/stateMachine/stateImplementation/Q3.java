package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Q3 extends State {
    public Q3() {
        super(MachineState.Q3);
    }

    @Override
    public State nextState(CharacterType type) {
        if(type == CharacterType.LETTER)
            return new Q3();

        if(type == CharacterType.ENDWORD)
            return new Q5();

        return new Error();
    }
}

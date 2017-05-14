package com.ksharovarsky.lab1.stateMachine.stateImplementation;

import com.ksharovarsky.lab1.stateMachine.CharacterType;
import com.ksharovarsky.lab1.stateMachine.MachineState;

/**
 * Created by kosty on 3/7/2017.
 */
public class Q1 extends State {
    public Q1() {
        super(MachineState.Q1);
    }

    @Override
    public State nextState(CharacterType type) {
        if(type == CharacterType.LETTER)
            return new Q1();

        if(type == CharacterType.UNDERSCORE)
            return new Q2();

        if(type == CharacterType.ENDWORD)
            return new Q5();

        if(type == CharacterType.DIGIT)
            return new Q4();

        return new Error();
    }
}

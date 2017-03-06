package com.ksharovarsky.Lab1.StateMachine;

/**
 * Created by kostya on 3/7/2017.
 */
public class SwitchStateMachine implements StateMachineImplementation {
    private MachineState state;

    public SwitchStateMachine() {
        reset();
    }

    @Override
    public MachineState nextState(CharacterType type) {
        MachineState previousState = state;
        state = MachineState.ERROR;

        switch(previousState) {
            case Q0: {
                changeStateQ0(type);
            } break;
            case Q1: {
                changeStateQ1(type);
            } break;
            case Q2: {
                changeStateQ2(type);
            } break;
            case Q3: {
                changeStateQ3(type);
            } break;
            case Q4: {
                changeStateQ4(type);
            } break;
        }

        return state;
    }

    private void changeStateQ0(CharacterType type) {
        if(type == CharacterType.LETTER)
            state = MachineState.Q1;

        if(type == CharacterType.UNDERSCORE)
            state = MachineState.Q2;

        if(type == CharacterType.DIGIT)
            state = MachineState.Q4;
    }

    private void changeStateQ1(CharacterType type) {
        changeStateQ0(type);
    }

    private void changeStateQ2(CharacterType type) {
        if(type == CharacterType.LETTER)
            state = MachineState.Q3;

        if(type == CharacterType.DIGIT)
            state = MachineState.Q4;
    }

    private void changeStateQ3(CharacterType type) {
        if(type == CharacterType.LETTER)
            state = MachineState.Q3;

        if(type == CharacterType.ENDWORD)
            state = MachineState.Q5;
    }

    private void changeStateQ4(CharacterType type) {
        if(type == CharacterType.DIGIT)
            state = MachineState.Q4;

        if(type == CharacterType.ENDWORD)
            state = MachineState.Q5;
    }

    @Override
    public void reset() {
        state = MachineState.Q0;
    }

}

package com.ksharovarsky.Lab1.StateMachine;

/**
 * Created by kostya on 3/6/2017.
 */
public class FiniteStateMachine {
    private StateMachineImplementation implementation;

    protected FiniteStateMachine(StateMachineImplementation implementation) {
        this.implementation = implementation;
    }

    public boolean scanString(String input) {
        MachineState state = getFinalMachineState(input);

        return state == MachineState.Q5;
    }

    private MachineState getFinalMachineState(String input) {
        MachineState state;

        for(char c : input.toCharArray()) {
            CharacterType type = getCharacterType(c);
            state = implementation.nextState(type);

            if(state == MachineState.ERROR)
                return MachineState.ERROR;
        }

        state = implementation.nextState(CharacterType.ENDWORD);

        return state;
    }

    private CharacterType getCharacterType(char c) {
        if(Character.isUpperCase(c))
            return CharacterType.LETTER;
        if(Character.isDigit(c))
            return CharacterType.DIGIT;
        if(c == '_')
            return CharacterType.UNDERSCORE;

        return CharacterType.ANY;
    }

}

package com.ksharovarsky.lab1.stateMachine;

/**
 * Created by kostya on 3/6/2017.
 */
public class FiniteStateMachine {
    private StateMachineImplementation implementation;

    public FiniteStateMachine(StateMachineImplementation implementation) {
        this.implementation = implementation;
    }

    public boolean scanString(String input) {
        MachineState state = getFinalMachineState(input);

        return state == MachineState.Q5;
    }

    private MachineState getFinalMachineState(String input) {
        MachineState state;

        for(char c : input.toCharArray()) {
            CharacterType type = CharacterType.fromCharacter(c);
            state = implementation.nextState(type);

            if(state == MachineState.ERROR)
                return MachineState.ERROR;
        }

        state = implementation.nextState(CharacterType.ENDWORD);

        return state;
    }

    public void reset() {
        implementation.reset();
    }

}

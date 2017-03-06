package com.ksharovarsky.Lab1.StateMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by kostya on 3/7/2017.
 */
public class TransitionStateMachine implements StateMachineImplementation {

    private Transition[] transitions;
    private MachineState state;

    public TransitionStateMachine() {
        reset();
    }
    @Override
    public MachineState nextState(CharacterType type) {
        Transition transition = Arrays.stream(transitions)
                .filter(t -> t.getState() == state && t.getTriggerer() == type)
                .findFirst().orElse(null);

        state = transition == null ? MachineState.ERROR : transition.getResulState();

        return state;
    }

    private Transition[] buildTransitionTable() {
        transitions = new Transition[] {
                new Transition(MachineState.Q0, CharacterType.LETTER, MachineState.Q1),
                new Transition(MachineState.Q0, CharacterType.UNDERSCORE, MachineState.Q2),
                new Transition(MachineState.Q0, CharacterType.DIGIT, MachineState.Q4),
                new Transition(MachineState.Q1, CharacterType.LETTER, MachineState.Q1),
                new Transition(MachineState.Q1, CharacterType.UNDERSCORE, MachineState.Q2),
                new Transition(MachineState.Q1, CharacterType.ENDWORD, MachineState.Q5),
                new Transition(MachineState.Q2, CharacterType.LETTER, MachineState.Q3),
                new Transition(MachineState.Q2, CharacterType.DIGIT, MachineState.Q4),
                new Transition(MachineState.Q3, CharacterType.LETTER, MachineState.Q3),
                new Transition(MachineState.Q3, CharacterType.ENDWORD, MachineState.Q5),
                new Transition(MachineState.Q4, CharacterType.DIGIT, MachineState.Q4),
                new Transition(MachineState.Q4, CharacterType.ENDWORD, MachineState.Q5)
        };

        return transitions;
    }

    @Override
    public void reset() {
        transitions = buildTransitionTable();
        state = MachineState.Q0;
    }
}

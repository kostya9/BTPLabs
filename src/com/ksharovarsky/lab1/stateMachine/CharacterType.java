package com.ksharovarsky.lab1.stateMachine;

/**
 * Created by kostya on 3/7/2017.
 */
public enum CharacterType {
    DIGIT, LETTER, UNDERSCORE, ENDWORD, ANY;

    public static CharacterType fromCharacter(char c) {
        if(Character.isUpperCase(c))
            return CharacterType.LETTER;
        if(Character.isDigit(c))
            return CharacterType.DIGIT;
        if(c == '_')
            return CharacterType.UNDERSCORE;

        return CharacterType.ANY;
    }
}

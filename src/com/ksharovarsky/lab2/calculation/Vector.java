package com.ksharovarsky.lab2.calculation;

import java.util.Arrays;

/**
 * Created by kostya on 4/10/2017.
 */
public class Vector extends Expression{

    private Number[] _numbers;

    public int getDimension() {
        return _numbers.length;
    }

    public Vector(Number[] numbers) {
            this._numbers = numbers;
    }

    @Override
    public String display() {
        String output = "";
        for (Number n: _numbers) {
            output += " " + n.display();
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return Arrays.deepEquals(_numbers, vector._numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(_numbers);
    }
}

package com.ksharovarsky.lab2.calculation;

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
}

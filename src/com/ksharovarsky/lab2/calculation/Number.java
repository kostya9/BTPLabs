package com.ksharovarsky.lab2.calculation;

/**
 * Created by kostya on 4/10/2017.
 */
public class Number extends Expression {
    private double _value;

    public Number(double value) {
        _value = value;
    }

    @Override
    public String display() {
        return String.format("%.2f", _value);
    }
}

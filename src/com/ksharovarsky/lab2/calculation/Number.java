package com.ksharovarsky.lab2.calculation;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.reflect.generics.tree.DoubleSignature;

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

    public Expression plus(Expression e) {
        if(e instanceof Number)
        {
            Number n = (Number)e;
            return new Number(_value + n._value);
        }
        throw new NotImplementedException();
    }

    public Expression minus(Expression e) {
        if(e instanceof Number)
        {
            Number n = (Number)e;
            return new Number(_value - n._value);
        }
        throw new NotImplementedException();
    }

    public Expression multiply(Expression e) {
        if(e instanceof Number)
        {
            Number n = (Number)e;
            return new Number(_value * n._value);
        }
        throw new NotImplementedException();
    }

    public Expression divide(Expression e) {
        if(e instanceof Number)
        {
            Number n = (Number)e;
            return new Number(_value / n._value);
        }
        throw new NotImplementedException();
    }

    public Expression transpose() {
        return this;
    }

    public Expression inverse() {
        return new Number(1 / _value);
    }

    public Expression rank() {
        return new Number(1);
    }

    public Expression determinant() {
        return this;
    };

    public Expression negative() {

        return new Number(- _value);
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return Double.compare(_value, number._value) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(_value);
        return (int) (temp ^ (temp >>> 32));
    }
}

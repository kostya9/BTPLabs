package com.ksharovarsky.lab2.calculation;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public Vector plus(Number n) {
        Number[] numbers = Arrays.stream(_numbers).map(curN -> curN.plus(n)).toArray(Number[]::new);
        return new Vector(numbers);
    }

    //region Expression
    @Override
    public Expression plus(Expression e) {
        return e.plus(this);
    }

    @Override
    public Expression minus(Expression e) {
        return e.negative().plus(this);
    }

    @Override
    public Expression multiply(Expression e) {
        return e.beMultiplied(this);
    }

    @Override
    public Expression divide(Expression e) {
        return e.beDivided(this);
    }
//endregion

    //region Number
    @Override
    public Expression multiply(Number n) {
        Number[] numbers = Arrays.stream(_numbers).map(curN -> curN.multiply(n)).toArray(Number[]::new);
        return new Vector(numbers);
    }

    public Expression beMultiplied(Number n) {
        return this.multiply(n);
    }

    public Expression beDivided(Number n) {
        return n.multiply(this.inverse());
    }

    //endregion

    //region Vector
    public Expression beMultiplied(Vector v) {
        if(v.getDimension() != this.getDimension())
            throw new IllegalArgumentException("Incorrect dimensions.");

        Number result = IntStream.range(0, getDimension())
                .mapToObj(i -> _numbers[i].multiply(v._numbers[i]))
                .collect(Collectors.reducing(Number::plus)).get();
        return result;
    }

    public Expression beDivided(Vector v) {
        return v.multiply(this.inverse());
    }

    //endregion

    //region unar
    public Expression transpose() {
        throw new IllegalArgumentException("Cannot transpose vectors");
    }

    public Expression inverse() {
        throw new IllegalArgumentException("Cannot inverse vectors");
    }

    public Expression rank() {
        return new Number(1);
    }

    public Expression determinant() {
        throw new IllegalArgumentException("Cannot find a determinant of a vector");
    };

    public Expression negative() {
        Number[] numbers = Arrays.stream(_numbers).map(Number::negative).toArray(Number[]::new);
        return new Vector(numbers);
    };
    //endregion

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

    public double[] toDoubleArray() {
        return Arrays.stream(_numbers).mapToDouble(Number::getValue).toArray();
    }
}

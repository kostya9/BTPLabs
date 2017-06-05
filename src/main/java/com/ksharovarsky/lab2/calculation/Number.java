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
    public Number plus(Number n) {
        return new Number(n._value + _value);
    }

    @Override
    public Number multiply(Number n) {
        return new Number(n._value * _value);
    }

    @Override
    public Expression beMultiplied(Number n) {
        return this.multiply(n);
    }

    @Override
    public Expression divide(Number n) {
        return new Number(_value / n._value);
    }

    @Override
    public Expression beDivided(Number n) { return n.divide(this); }
    //endregion

    //region Vector
    @Override
    public Expression beMultiplied(Vector v) {
        return v.multiply(this);
    }
    @Override
    public Expression beDivided(Vector v) {
        return v.multiply(this.inverse());
    }
    //endregion

    //region Matrix
    @Override
    public Expression beMultiplied(Matrix m) {
        return m.multiply(this);
    }
//endregion

    //region unar
    @Override
    public Expression transpose() {
        return this;
    }

    @Override
    public Expression inverse() {
        return new Number(1 / _value);
    }

    @Override
    public Expression rank() {
        return new Number(1);
    }

    @Override
    public Expression determinant() {
        return this;
    }

    @Override
    public Expression negative() {

        return new Number(- _value);
    }

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

    //endregion

    public double getValue() {
        return _value;
    }


}

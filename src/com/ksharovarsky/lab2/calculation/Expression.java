package com.ksharovarsky.lab2.calculation;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by kostya on 4/10/2017.
 */
public abstract class Expression {
    public Expression plus(Expression e) {
        throw new NotImplementedException();
    }

    public Expression minus(Expression e) {
        throw new NotImplementedException();
    }

    public Expression multiply(Expression e) {
        throw new NotImplementedException();
    }

    public Expression divide(Expression e) {
        throw new NotImplementedException();
    }

    public Expression transpose() {
        throw new NotImplementedException();
    }

    public Expression inverse() {
        throw new NotImplementedException();
    }

    public Expression rank() {
        throw new NotImplementedException();
    }

    public Expression determinant() {
        throw new NotImplementedException();
    };

    public Expression negative() {
        throw new NotImplementedException();
    };

    public abstract String display();
}

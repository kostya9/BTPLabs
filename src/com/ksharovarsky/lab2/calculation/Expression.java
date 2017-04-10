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

    public Expression transpose(Expression e) {
        throw new NotImplementedException();
    }

    public Expression inverse(Expression e) {
        throw new NotImplementedException();
    }

    public abstract String display();
}

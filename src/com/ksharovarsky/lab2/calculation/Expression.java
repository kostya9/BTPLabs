package com.ksharovarsky.lab2.calculation;

/**
 * Created by kostya on 4/10/2017.
 */
public abstract class Expression {

    //region Expression
    public Expression plus(Expression e) { throw new IllegalArgumentException(); }

    public Expression minus(Expression e) { throw new IllegalArgumentException(); }

    public Expression multiply(Expression e) { throw new IllegalArgumentException(); }

    public Expression divide(Expression e) { throw new IllegalArgumentException(); }

    public Expression beMultiplied(Expression e) { throw new IllegalArgumentException(); }

    public Expression beDivided(Expression e) {throw new IllegalArgumentException(); }
//endregion

    //region Number
    public Expression plus(Number e) { throw new IllegalArgumentException(); }

    public Expression minus(Number e) { throw new IllegalArgumentException(); }

    public Expression multiply(Number e) { throw new IllegalArgumentException(); }

    public Expression beMultiplied(Number e) { throw new IllegalArgumentException(); }

    public Expression divide(Number e) { throw new IllegalArgumentException(); }

    public Expression beDivided(Number e) {throw new IllegalArgumentException(); }
//endregion

    //region Matrix
    public Expression plus(Matrix e) { throw new IllegalArgumentException(); }

    public Expression minus(Matrix e) { throw new IllegalArgumentException(); }

    public Expression multiply(Matrix e) { throw new IllegalArgumentException(); }

    public Expression beMultiplied(Matrix e) { throw new IllegalArgumentException(); }

    public Expression divide(Matrix e) { throw new IllegalArgumentException(); }

    public Expression beDivided(Matrix e) {throw new IllegalArgumentException(); }
//endregion

    //region Vector
    public Expression plus(Vector e) { throw new IllegalArgumentException(); }

    public Expression minus(Vector e) { throw new IllegalArgumentException(); }

    public Expression multiply(Vector e) { throw new IllegalArgumentException(); }

    public Expression beMultiplied(Vector e) { throw new IllegalArgumentException(); }

    public Expression divide(Vector e) { throw new IllegalArgumentException(); }

    public Expression beDivided(Vector e) {throw new IllegalArgumentException(); }
//endregion

    //region unar
    public Expression transpose() { throw new IllegalArgumentException(); }

    public Expression inverse() { throw new IllegalArgumentException(); }

    public Expression rank() { throw new IllegalArgumentException(); }

    public Expression determinant() { throw new IllegalArgumentException(); };

    public Expression negative() { throw new IllegalArgumentException(); };
    //endregion

    public abstract String display();
}

package com.ksharovarsky.lab2.calculation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by kostya on 4/10/2017.
 */
public class Matrix extends Expression{

    private Vector[] _vectors;

    public Matrix(Vector[] vectors) {
        int size = vectors[0].getDimension();
        if(Stream.of(vectors).anyMatch(v -> v.getDimension() != size))
            throw new IllegalArgumentException("Incorrect vector dimensions in the matrix");

        this._vectors = vectors;
    }

    private static Jama.Matrix toJamaMatrix(Matrix m) {
        return new Jama.Matrix(Arrays.stream(m._vectors).map(Vector::toDoubleArray).toArray(double[][]::new));
    }

    private static Matrix toMatrix(Jama.Matrix m) {
        Vector[] vectors = Arrays.stream(m.getArray()).map(da -> new Vector(Arrays.stream(da).mapToObj(Number::new).toArray(Number[]::new))).toArray(Vector[]::new);
        return new Matrix(vectors);
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
    public Expression plus(Number n) {
        Vector[] vectors = Arrays.stream(_vectors).map(v -> v.plus(n)).toArray(Vector[]::new);

        return new Matrix(vectors);
    }

    public Expression multiply(Number n) {
        Vector[] vectors = Arrays.stream(_vectors).map(v -> v.multiply(n)).toArray(Vector[]::new);

        return new Matrix(vectors);
    }

    public Expression beMultiplied(Number n) {
        return this.multiply(n);
    }
    //endregion

    //region Matrix
    public Expression plus(Matrix m) {
        Jama.Matrix jamaMatrix = toJamaMatrix(this);
        Jama.Matrix jamaMatrixRight = toJamaMatrix(m);

        Jama.Matrix result = jamaMatrix.plus(jamaMatrixRight);

        return toMatrix(result);
    }

    public Expression multiply(Matrix m) {
        Jama.Matrix jamaMatrixLeft = toJamaMatrix(this);
        Jama.Matrix jamaMatrixRight = toJamaMatrix(m);

        Jama.Matrix jamaMatrixResult = jamaMatrixLeft.times(jamaMatrixRight);
        return toMatrix(jamaMatrixResult);
    }

    public Expression beMultiplied(Matrix m) {
        return m.multiply(this);
    }
//endregion

    //region unar
    public Expression transpose() {
        Jama.Matrix jamaMatrix = toJamaMatrix(this);

        return toMatrix(jamaMatrix.transpose());
    }

    public Expression inverse() {
        Jama.Matrix jamaMatrix = toJamaMatrix(this);

        Jama.Matrix result;
        try
        {
            result = jamaMatrix.inverse();
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("This matrix can't be inversed");
        }

        return  toMatrix(result);
    }

    public Expression rank() {
        Jama.Matrix jamaMatrix = toJamaMatrix(this);

        return  new Number(jamaMatrix.rank());
    }
    public Expression determinant() {
        Jama.Matrix jamaMatrix = toJamaMatrix(this);
        double result;
        try {
            result = jamaMatrix.det();
        }
        catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The matrix is not square.");
        }

        return new Number(result);
    };

    public Expression negative() {
        Vector[] vectors = Arrays.stream(this._vectors).map(Vector::negative).toArray(Vector[]::new);

        return new Matrix(vectors);
    };
    //endregion

    @Override
    public String display() {
        String output = "";
        for (Vector v: _vectors) {
            output += "\n" + v.display();
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        return Arrays.deepEquals(_vectors, matrix._vectors);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(_vectors);
    }
}

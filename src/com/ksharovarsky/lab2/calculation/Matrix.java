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

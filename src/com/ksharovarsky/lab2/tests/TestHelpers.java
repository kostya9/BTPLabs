package com.ksharovarsky.lab2.tests;

import com.ksharovarsky.lab2.calculation.Matrix;
import com.ksharovarsky.lab2.calculation.Number;
import com.ksharovarsky.lab2.calculation.Vector;

import java.util.Arrays;

/**
 * Created by kosty on 4/11/2017.
 */
public class TestHelpers {
    public static Vector fromNumbers(double ... numbers) {
        Number[] arr = Arrays.stream(numbers).mapToObj(Number::new).toArray(Number[]::new);

        return new Vector(arr);
    }

    public static Matrix fromVectors(Vector ... vectors) {
        Vector[] arr = Arrays.stream(vectors).toArray(Vector[]::new);

        return new Matrix(arr);
    }
}

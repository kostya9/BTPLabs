package com.ksharovarsky.lab2.tests;

import com.ksharovarsky.lab2.calculation.*;
import com.ksharovarsky.lab2.calculation.Expression;
import com.ksharovarsky.lab2.calculation.ExpressionCalculator;
import com.ksharovarsky.lab2.calculation.Number;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.ksharovarsky.lab2.tests.TestHelpers.fromNumbers;
import static com.ksharovarsky.lab2.tests.TestHelpers.fromVectors;
import static junit.framework.TestCase.assertEquals;



/**
 * Created by kosty on 4/11/2017.
 */
public class TestParse {

    private ExpressionCalculator _calculator;

    public TestParse() {

    }

    @Before
    public void initCalculator() {
        _calculator = new ExpressionCalculator();
    }

    @Test
    public void testNumeric() {
        Expression e = _calculator.calculate("1");

        assertEquals(e, new Number(1));
    }

    @Test
    public void testVector() {
        Expression e = _calculator.calculate("[1, 2, 3]");

        assertEquals(e, fromNumbers(1, 2, 3));
    }

    @Test
    public void testMatix() {
        Expression e = _calculator.calculate("[[1, 2], [1, 2], [1, 2]]");

        Vector v = fromNumbers(1, 2);
        assertEquals(e, fromVectors(v, v, v));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVectorInconsistent() {
        Expression e = _calculator.calculate("[1, 2, [3]]");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testVectorNotClosed() {
        Expression e = _calculator.calculate("[1, 2, [3]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOperationNotClosed() {
        Expression e = _calculator.calculate("1 + ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVectorNoComma() {
        Expression e = _calculator.calculate("[1 2 3]");
    }
}

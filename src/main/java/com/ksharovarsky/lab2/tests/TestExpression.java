package com.ksharovarsky.lab2.tests;

import com.ksharovarsky.lab2.calculation.Expression;
import com.ksharovarsky.lab2.calculation.ExpressionCalculator;
import com.ksharovarsky.lab2.calculation.Number;
import org.junit.Before;
import org.junit.Test;

import static com.ksharovarsky.lab2.tests.TestHelpers.fromNumbers;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by kosty on 4/11/2017.
 */
public class TestExpression {
    private ExpressionCalculator _calculator;

    public TestExpression() {

    }

    @Before
    public void initCalculator() {
        _calculator = new ExpressionCalculator();
    }

    @Test
    public void testPlusAndMinus() {
        Expression e = _calculator.calculate("1 + 1 + 1 + 1");
        Expression eMinus = e.minus((Expression) new Number(1));

        assertEquals(e, new Number(4));
        assertEquals(eMinus, new Number(3));
    }

    @Test
    public void testMultiplyAndDivide() {
        Expression e = _calculator.calculate("3 * 3");
        Expression eDivide = e.divide(new Number(3));

        assertEquals(e, new Number(9));
        assertEquals(eDivide, new Number(3));
    }

    @Test
    public void testExpressionsInVectors() {
        Expression e = _calculator.calculate("[3 * 3.3, 1, 2 + 2]");

        assertEquals(e, fromNumbers(3 * 3.3, 1, 4));
    }
}

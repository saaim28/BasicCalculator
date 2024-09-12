package com.bradteachescode.basiccalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    /* Initial test for TDD */
    @Test
    public void testDecimalPointAddition() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate("2.7 + 4.2");
        assertEquals(6.9, result, 0.0001);
    }
}
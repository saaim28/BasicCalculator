package com.bradteachescode.basiccalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5.0, calculator.calculate("2 + 3"), 0.0001);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.calculate("5 - 3"), 0.0001);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(15.0, calculator.calculate("5 * 3"), 0.0001);
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.calculate("6 / 3"), 0.0001);
    }
    }

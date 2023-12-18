package com.example.madt_3_lab_calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUnitTest {

    @Test
    public void addition_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(2,3,"+");
        assertEquals(5, result, 0.001);
    }

    @Test
    public void subtraction_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(5,2,"-");
        assertEquals(3, result, 0.001);
    }

    @Test
    public void multiplication_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(4,3,"*");
        assertEquals(12, result, 0.001);
    }

    @Test
    public void division_isCorrect() {
        Calculator calculator = new Calculator();
        double result = calculator.performOperation(10,2,"/");
        assertEquals(5, result, 0.001);
    }
}
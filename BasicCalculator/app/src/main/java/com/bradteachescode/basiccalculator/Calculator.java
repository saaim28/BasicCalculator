package com.bradteachescode.basiccalculator;

public class Calculator {
    public double calculate(String expression) {
        String[] parts = expression.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[2]);
        String operator = parts[1];

        return performOperation(num1, num2, operator);

        private double performOperation(double num1, double num2, String operator){
            switch (operator) {
                case "+":
                    return num1 + num2;
                // Add other cases for -, *, / later
                default:
                    throw new IllegalArgumentException("Unknown operator");
            }
        }

    }
}

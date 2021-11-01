package com.example.calculator;

public final class Calc {
    public static boolean isNumber(String s) {
        boolean bool = false;
        if (!s.equals("*") && !s.equals("/") && !s.equals("+") && !s.equals("-") && !s.equals("=") && !s.equals("(") && !s.equals(")")) {
            bool = true;
        }
        return bool;
    }
    public Double doMath(String operator, Double num1, Double num2) {
        Double result = 0.0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}

package com.venkat.challenges;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}


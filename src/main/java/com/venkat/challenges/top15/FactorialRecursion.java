package com.venkat.challenges.top15;

public class FactorialRecursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial: " + factorial(number)); // Output: 120
    }
}


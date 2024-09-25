package com.venkat.dsa.recursion;

public class IterativeFibonacci {
    // Iterative method to calculate Fibonacci number
    public static int fibonacci(int n) {
        // Handle base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;  // F(0)
        int b = 1;  // F(1)
        int result = 0;

        // Iteratively calculate Fibonacci up to n
        for (int i = 2; i <= n; i++) {
            result = a + b;  // F(n) = F(n-1) + F(n-2)
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6; // Example for calculating Fibonacci of 6
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}


package com.venkat.dsa.recursion;

public class RecursiveFibonacci {
    // Recursive method to calculate Fibonacci number
    public static int fibonacci(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6; // Example for calculating Fibonacci of 6
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}


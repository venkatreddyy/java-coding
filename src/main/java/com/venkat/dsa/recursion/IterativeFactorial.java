package com.venkat.dsa.recursion;
/*

 */
public class IterativeFactorial {
    // Iterative method to calculate factorial
    public static int factorial(int n) {
        int result = 1;

        // Multiply result by all integers from 1 to n
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}

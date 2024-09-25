package com.venkat.dsa.recursion;

/*

 */
public class RecursiveFactorial {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n * factorial(n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}


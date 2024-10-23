package com.venkat.challenges.top15;

public class FibonacciSeries {

    // Method to print Fibonacci series up to 'n' terms
    public static void printFibonacci(int n) {
        // Initialize the first two terms of the Fibonacci series
        int a = 0, b = 1, next;

        // Print the first two terms
        System.out.print(a + " " + b);

        // Loop starts from 2 because the first two terms are already printed
        for (int i = 2; i < n; i++) {
            // Calculate the next term by adding the previous two terms
            next = a + b;

            // Print the next term
            System.out.print(" " + next);

            // Update 'a' and 'b' for the next iteration
            a = b;  // Move 'b' to 'a'
            b = next;  // Move the new 'next' to 'b'
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Define the number of terms to print in the Fibonacci series
        int n = 10;

        // Call the method to print Fibonacci series up to 'n' terms
        printFibonacci(n); // Output: 0 1 1 2 3 5 8 13 21 34
    }
}


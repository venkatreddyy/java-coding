package com.venkat.dsa.patterns;

/*
Dynamic Programming (DP)
Dynamic Programming (DP) is an optimization technique used to solve problems by breaking them down into overlapping subproblems. It is particularly useful for problems that exhibit optimal substructure (the problem can be solved optimally by solving subproblems) and overlapping subproblems (the subproblems are reused multiple times).

DP solves each subproblem only once and stores its result, typically using a table (array or matrix). This avoids recalculating the results of overlapping subproblems, which drastically improves efficiency compared to naive recursive solutions.

Two Approaches in DP:
Top-down (Memoization): You solve the problem by recursively breaking it down and storing the solutions to subproblems in a cache to avoid redundant computations.
Bottom-up (Tabulation): You solve the problem by first solving all the smaller subproblems, and then combining them to solve the larger ones.
Common Problem Types:
Optimization problems (minimization, maximization)
Counting problems (count the number of ways)
Subsequence or substring problems

 */
public class FibonacciDP {

    // Method to calculate Fibonacci using bottom-up dynamic programming
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Create an array to store the Fibonacci numbers up to n
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        // Fill the array by solving subproblems
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2]; // DP relation: F(n) = F(n-1) + F(n-2)
        }

        // Return the nth Fibonacci number
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n)); // Output: 55
    }
}


package com.venkat.dsa.alg;

/*
o find the nth Fibonacci number using recursion, we can define a recursive function that follows the Fibonacci sequence formula:

Fibonacci Sequence Definition:
The Fibonacci sequence is defined as:
F(0) = 0
F(1) = 1
For n >= 2: F(n) = F(n-1) + F(n-2)
Recursive Approach:
We can create a recursive function that computes the Fibonacci number by repeatedly calling itself for the previous two Fibonacci numbers.

Explanation:
Base Case: The function stops recursion at two points:
If n == 0, it returns 0 (because the 0th Fibonacci number is 0).
If n == 1, it returns 1 (because the 1st Fibonacci number is 1).
Recursive Case: For values of n >= 2, the function recursively calls itself for the previous two Fibonacci numbers:
fibonacci(n - 1) computes the Fibonacci number at position n - 1.
fibonacci(n - 2) computes the Fibonacci number at position n - 2.
These two values are added together to compute the Fibonacci number at position n.
Example:
For n = 10, the recursive function will calculate the Fibonacci sequence as follows:

F(10) = F(9) + F(8)
F(9) = F(8) + F(7)
...
Recursively continues until the base cases F(1) and F(0) are reached.
Output:
For n = 10, the output will be:
The 10th Fibonacci number is: 55
Time Complexity:
The time complexity of this recursive solution is O(2^n) because it recalculates the same values many times,
making it inefficient for large n.
Optimization:
==========
To optimize, you could use memoization or dynamic programming to store intermediate results and
avoid redundant calculations. Let me know if you'd like to see an optimized version!

 */
public class FibonacciRecursion {

    // Recursive function to find the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;  // F(0) = 0
        } else if (n == 1) {
            return 1;  // F(1) = 1
        } else {
            // Recursive case: F(n) = F(n-1) + F(n-2)
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;  // Change this value to find the nth Fibonacci number
        int result = fibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}


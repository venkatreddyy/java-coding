package com.venkat.dsa;

/*
Here's how you can calculate the nth Fibonacci number using a for loop instead of recursion. This method is much more efficient because it avoids the overhead of repeated function calls and redundant calculations.

Fibonacci Sequence Using a For Loop
The Fibonacci sequence is defined as:

F(0) = 0
F(1) = 1
For n >= 2: F(n) = F(n-1) + F(n-2)
 */
public class FibonacciLoop {

    // Function to find the nth Fibonacci number using a for loop
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;  // F(0) = 0
        }
        if (n == 1) {
            return 1;  // F(1) = 1
        }

        int prev1 = 0;  // F(0)
        int prev2 = 1;  // F(1)
        int current = 0;

        // Calculate Fibonacci numbers from F(2) to F(n)
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;  // F(i) = F(i-1) + F(i-2)
            prev1 = prev2;  // Move F(i-1) to F(i-2)
            prev2 = current;  // Move F(i) to F(i-1)
        }

        return current;  // Return the nth Fibonacci number
    }

    public static void main(String[] args) {
        int n = 10;  // Change this value to find the nth Fibonacci number
        int result = fibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}

/*
Explanation:
Base Cases: The function checks if n is 0 or 1 and returns the corresponding Fibonacci numbers directly.

F(0) = 0
F(1) = 1
Loop: For n >= 2, the loop starts from i = 2 and calculates Fibonacci numbers by keeping track of the previous two Fibonacci numbers (prev1 and prev2). These values are updated in each iteration of the loop.

Variables:
prev1: Holds F(i-2) (the Fibonacci number two steps before the current one).
prev2: Holds F(i-1) (the Fibonacci number one step before the current one).
current: Holds F(i), the Fibonacci number for the current step.
Efficiency: The time complexity of this approach is O(n), which is significantly more efficient than the recursive approach.

Example:
For n = 10, the output will be:

csharp
Copy code
The 10th Fibonacci number is: 55
Time Complexity:
O(n): The algorithm only requires a single loop that iterates n times, so it's very efficient.
Space Complexity:
O(1): The algorithm uses a constant amount of memory (only a few variables to store the current and previous Fibonacci numbers).
Let me know if you need further explanation or modifications!
 */


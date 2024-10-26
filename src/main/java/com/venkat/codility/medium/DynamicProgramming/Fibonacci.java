package com.venkat.codility.medium.DynamicProgramming;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = fibonacci(10);
        System.out.println("Fibonacci(10): " + result); // Output: 55
    }
}

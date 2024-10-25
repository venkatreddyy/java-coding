package com.venkat.codility;

public class FibonacciNumbers {
    public int fibonacci(int N) {
        if (N == 0 || N == 1) return N;

        int[] fib = new int[N + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[N];
    }

    public static void main(String[] args) {
        FibonacciNumbers obj = new FibonacciNumbers();
        System.out.println(obj.fibonacci(10));  // Output: 55
    }
}


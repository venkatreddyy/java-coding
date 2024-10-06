package com.venkat.challenges;

public class Fibonacci {
    public static void fibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        fibonacci(10);  // Output: 0 1 1 2 3 5 8 13 21 34
    }
}


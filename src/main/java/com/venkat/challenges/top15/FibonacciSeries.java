package com.venkat.challenges.top15;

public class FibonacciSeries {
    public static void printFibonacci(int n) {
        int a = 0, b = 1, next;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n); // Output: 0 1 1 2 3 5 8 13 21 34
    }
}


package com.venkat.codility.easy.ArrayAndBasicIteration;

public class CountDiv {
    public static int countDivisible(int A, int B, int K) {
        // Calculate the number of integers divisible by K within range [A, B]
        return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        int result = countDivisible(6, 11, 2);
        System.out.println("Divisible Count: " + result); // Output: 3
    }
}


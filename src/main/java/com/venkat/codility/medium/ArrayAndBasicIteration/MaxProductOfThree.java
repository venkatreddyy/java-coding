package com.venkat.codility.medium.ArrayAndBasicIteration;

import java.util.Arrays;

public class MaxProductOfThree {
    public static int maxProduct(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        return Math.max(A[0] * A[1] * A[n - 1], A[n - 1] * A[n - 2] * A[n - 3]);
    }

    public static void main(String[] args) {
        int[] arr = {-10, -10, 1, 3, 2};
        int result = maxProduct(arr);
        System.out.println("Maximum Product of Three: " + result); // Output: 300
    }
}


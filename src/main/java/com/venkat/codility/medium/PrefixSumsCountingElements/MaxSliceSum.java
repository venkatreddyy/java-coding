package com.venkat.codility.medium.PrefixSumsCountingElements;

public class MaxSliceSum {
    public static int maxSliceSum(int[] A) {
        int maxEnding = A[0], maxSlice = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -6, 4, 0};
        int result = maxSliceSum(arr);
        System.out.println("Maximum Slice Sum: " + result); // Output: 5
    }
}


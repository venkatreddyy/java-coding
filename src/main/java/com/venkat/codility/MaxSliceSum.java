package com.venkat.codility;

public class MaxSliceSum {
    public int solution(int[] A) {
        int maxEnding = A[0];
        int maxSlice = A[0];

        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }

    public static void main(String[] args) {
        MaxSliceSum obj = new MaxSliceSum();
        int[] A = {3, 2, -6, 4, 0};
        System.out.println(obj.solution(A));  // Output: 5
    }
}


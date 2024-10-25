package com.venkat.codility;

public class MaxAbsSliceSum {
    public int solution(int[] A) {
        int maxEnding = A[0];
        int minEnding = A[0];
        int maxSlice = Math.abs(A[0]);

        for (int i = 1; i < A.length; i++) {
            maxEnding = Math.max(A[i], maxEnding + A[i]);
            minEnding = Math.min(A[i], minEnding + A[i]);
            maxSlice = Math.max(maxSlice, Math.max(Math.abs(maxEnding), Math.abs(minEnding)));
        }

        return maxSlice;
    }

    public static void main(String[] args) {
        MaxAbsSliceSum obj = new MaxAbsSliceSum();
        int[] A = {1, -2, 3, -4, 5};
        System.out.println(obj.solution(A));  // Output: 6
    }
}


package com.venkat.codility;

public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int N = A.length;
        int[] maxEndingHere = new int[N];
        int[] maxStartingHere = new int[N];

        for (int i = 1; i < N - 1; i++) {
            maxEndingHere[i] = Math.max(0, maxEndingHere[i - 1] + A[i]);
        }

        for (int i = N - 2; i > 0; i--) {
            maxStartingHere[i] = Math.max(0, maxStartingHere[i + 1] + A[i]);
        }

        int maxDoubleSliceSum = 0;
        for (int i = 1; i < N - 1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxEndingHere[i - 1] + maxStartingHere[i + 1]);
        }

        return maxDoubleSliceSum;
    }

    public static void main(String[] args) {
        MaxDoubleSliceSum obj = new MaxDoubleSliceSum();
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(obj.solution(A));  // Output: 17
    }
}


package com.venkat.codility;

public class MaxAverageSubarray {
    public double solution(int[] A, int K) {
        double maxSum = 0;
        for (int i = 0; i < K; i++) maxSum += A[i];

        double currentSum = maxSum;
        for (int i = K; i < A.length; i++) {
            currentSum += A[i] - A[i - K];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / K;
    }

    public static void main(String[] args) {
        MaxAverageSubarray obj = new MaxAverageSubarray();
        int[] A = {1, 12, -5, -6, 50, 3};
        System.out.println(obj.solution(A, 4));  // Output: 12.75
    }
}


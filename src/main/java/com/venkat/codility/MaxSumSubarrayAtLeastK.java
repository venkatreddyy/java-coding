package com.venkat.codility;

public class MaxSumSubarrayAtLeastK {
    public int solution(int[] A, int K) {
        int N = A.length;
        int[] maxEndingHere = new int[N];
        maxEndingHere[0] = A[0];

        for (int i = 1; i < N; i++) {
            maxEndingHere[i] = Math.max(A[i], maxEndingHere[i - 1] + A[i]);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) sum += A[i];

        int result = sum;
        for (int i = K; i < N; i++) {
            sum += A[i] - A[i - K];
            result = Math.max(result, sum);
            result = Math.max(result, sum + maxEndingHere[i - K]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSumSubarrayAtLeastK obj = new MaxSumSubarrayAtLeastK();
        int[] A = {1, 2, 3, -10, 4, 5, -6};
        System.out.println(obj.solution(A, 3));  // Output: 10
    }
}

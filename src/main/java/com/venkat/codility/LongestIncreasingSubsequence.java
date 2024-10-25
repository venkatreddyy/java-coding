package com.venkat.codility;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int solution(int[] A) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(obj.solution(A));  // Output: 6
    }
}


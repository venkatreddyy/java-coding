package com.venkat.codility.medium.DynamicProgramming;

public class CatalanNumber {
    public static int catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int result = catalan(5);
        System.out.println("5th Catalan Number: " + result); // Output: 42
    }
}


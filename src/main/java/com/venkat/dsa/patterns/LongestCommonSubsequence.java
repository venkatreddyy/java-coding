package com.venkat.dsa.patterns;

public class LongestCommonSubsequence {

    // Method to find the length of the longest common subsequence
    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match, take diagonal value + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the max of top or left cell
                }
            }
        }

        // Return the value in the bottom-right corner, which is the length of LCS
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("Length of LCS: " + lcs(s1, s2)); // Output: 3 (The LCS is "ace")
    }
}

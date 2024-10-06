package com.venkat.dsa.patterns;

public class LongestCommonSubsequence {

    // Method to find the length of the longest common subsequence
    public static int lcs(String s1, String s2) {
        // Get the length of the two input strings
        int m = s1.length();
        int n = s2.length();

        // Create a 2D DP table of size (m+1) x (n+1) initialized with zeros
        // dp[i][j] will store the length of LCS for the substrings s1[0..i-1] and s2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table in a bottom-up manner
        for (int i = 1; i <= m; i++) {  // Loop through the characters of the first string
            for (int j = 1; j <= n; j++) {  // Loop through the characters of the second string
                // If the characters from both strings match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Take the diagonal value and add 1, as we found a common character
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum value from the top or left cell (to carry forward LCS length)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value in dp[m][n] contains the length of the LCS of s1 and s2
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Example strings
        String s1 = "abcde";
        String s2 = "ace";

        // Call the lcs method and print the length of the LCS
        System.out.println("Length of LCS: " + lcs(s1, s2));  // Output: 3 (The LCS is "ace")
    }
}


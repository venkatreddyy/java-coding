package com.venkat.hundred;

import java.util.*;
/*
Explanation of Each Problem and Test Cases:
Nth Catalan Number: Computes the Nth Catalan number.

Output: 42 for n = 5
Minimum Operations: Calculates the minimum number of operations to reduce n to 1 using subtraction, division by 2, or division by 3.

Output: 3 for n = 10
Minimum Steps to Delete a String After Repeated Deletion of Palindrome Substrings: Determines the minimum number of steps to delete a string by repeatedly deleting palindrome substrings.

Output: 1 for the string "abcddcba"
Minimum Number of Coins: Finds the minimum number of coins required to make up a given amount using the provided denominations.

Output: 3 for amount = 11 with coins [1, 2, 5]
Maximum Product Cutting: Computes the maximum product obtainable by cutting a rope of length n into integer parts.

Output: 36 for n = 10
Ways to Cover a Distance: Calculates the number of ways to cover a distance d using steps of 1, 2, or 3 units.

Output: 7 for d = 4
Minimum Number of Deletions and Insertions to Transform One String into Another: Determines the minimum number of deletions and insertions to transform one string into another.

Output: 3 for transforming "heap" into "pea"
Minimum Sum Subsequence Such That at Least One of Every Four Consecutive Elements is Picked: Computes the minimum sum subsequence where at least one element from every four consecutive elements is picked.

Output: 10 for the array [1, 2, 3, 4, 5, 6, 7, 8]
 */
public class Level1DPProblems {

    // 1. Nth Catalan Number
    // Time Complexity: O(n^2), where n is the nth Catalan number
    // Space Complexity: O(n), for storing the computed values
    public static int catalanNumber(int n) {
        int[] catalan = new int[n + 1]; // Array to store Catalan numbers
        catalan[0] = catalan[1] = 1; // Base cases: C(0) = C(1) = 1

        for (int i = 2; i <= n; i++) { // Compute C(i) for i = 2 to n
            catalan[i] = 0;
            for (int j = 0; j < i; j++) { // Sum of products of pairs
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n]; // Return the nth Catalan number
    }

    // 2. Minimum Operations (reduce n to 1 using -1, /2, /3)
    // Time Complexity: O(n), where n is the target number
    // Space Complexity: O(n), for storing minimum steps
    public static int minOperations(int n) {
        int[] dp = new int[n + 1]; // DP array to store minimum steps
        dp[1] = 0; // Base case: 1 requires 0 steps

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // Step 1: Subtract 1
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // Step 2: Divide by 2
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // Step 3: Divide by 3
        }
        return dp[n]; // Return the minimum steps to reduce n to 1
    }

    // 3. Minimum Steps to Delete a String After Repeated Deletion of Palindrome Substrings
    // Time Complexity: O(n^2), where n is the length of the string
    // Space Complexity: O(n^2), for the DP table
    public static int minDeletionsForPalindromeSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // DP table to store minimum deletions

        for (int len = 1; len <= n; len++) { // Traverse all substrings
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = 1; // A single character is a palindrome
                } else if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1; // Two equal characters form a palindrome
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1]; // Expand palindrome if equal characters
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]); // Minimum deletions otherwise
                }
            }
        }
        return dp[0][n - 1]; // Return the minimum deletions for the whole string
    }

    // 4. Minimum Number of Coins (for a given amount)
    // Time Complexity: O(n * m), where n is the amount and m is the number of coins
    // Space Complexity: O(n), for the DP table
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // DP array to store minimum coins
        Arrays.fill(dp, amount + 1); // Initialize DP array with a high value
        dp[0] = 0; // Base case: 0 coins for 0 amount

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Minimum coins for current amount
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; // If no solution, return -1
    }

    // 5. Maximum Product Cutting (cut a rope of length n into k parts to maximize product)
    // Time Complexity: O(n^2), where n is the length of the rope
    // Space Complexity: O(n), for the DP table
    public static int maxProductCutting(int n) {
        if (n == 2 || n == 3) return n - 1; // Special cases: n = 2 or 3
        int[] dp = new int[n + 1]; // DP table to store maximum product
        dp[0] = dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])); // Max of product and cutting further
            }
        }
        return dp[n]; // Return the maximum product for length n
    }

    // 6. Ways to Cover a Distance (find the number of ways to cover a distance of d with 1, 2, or 3 steps)
    // Time Complexity: O(d), where d is the distance
    // Space Complexity: O(d), for the DP table
    public static int waysToCoverDistance(int d) {
        int[] dp = new int[d + 1]; // DP table to store the number of ways
        dp[0] = 1; // Base case: 1 way to cover distance 0
        if (d >= 1) dp[1] = 1; // 1 way to cover distance 1
        if (d >= 2) dp[2] = 2; // 2 ways to cover distance 2

        for (int i = 3; i <= d; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // Sum of ways to cover distance with 1, 2, or 3 steps
        }
        return dp[d]; // Return the number of ways to cover the distance
    }

    // 7. Minimum Number of Deletions and Insertions to Transform One String into Another
    // Time Complexity: O(n * m), where n is the length of the first string and m is the length of the second string
    // Space Complexity: O(n * m), for the DP table
    public static int minDeletionsAndInsertions(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1]; // DP table for LCS

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match, extend LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Otherwise, take the max
                }
            }
        }
        int lcsLength = dp[n][m]; // Length of the Longest Common Subsequence
        int deletions = n - lcsLength; // Number of deletions required
        int insertions = m - lcsLength; // Number of insertions required
        return deletions + insertions; // Total operations
    }

    // 8. Minimum Sum Subsequence Such That at Least One of Every Four Consecutive Elements is Picked
    // Time Complexity: O(n), where n is the number of elements in the array
    // Space Complexity: O(n), for the DP table
    public static int minSumSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n <= 3) return Arrays.stream(arr).min().getAsInt(); // If less than 4 elements, return the minimum

        int[] dp = new int[n]; // DP table to store minimum sum subsequences
        dp[0] = arr[0];
        dp[1] = arr[1];
        dp[2] = arr[2];
        dp[3] = arr[3] + Math.min(dp[0], Math.min(dp[0], dp[1]));

        // Fill the dp array such that dp[i] gives the minimum sum subsequence that includes at least one element from every four consecutive elements
        for (int i = 4; i < n; i++) {
            dp[i] = arr[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], Math.min(dp[i - 3], dp[i - 4])));
        }

        // Return the minimum sum subsequence value from the last four entries of dp array
        return Math.min(dp[n - 1], Math.min(dp[n - 2], Math.min(dp[n - 3], dp[n - 4])));
    }

    // Main method to test all the functions
    public static void main(String[] args) {
        // 1. Test Nth Catalan Number
        System.out.println("5th Catalan Number: " + catalanNumber(5)); // Expected: 42

        // 2. Test Minimum Operations to reduce n to 1
        System.out.println("Minimum operations to reduce 10 to 1: " + minOperations(10)); // Expected: 3

        // 3. Test Minimum Steps to Delete a String After Repeated Deletion of Palindrome Substrings
        System.out.println("Min deletions for palindrome substrings in 'abcddcba': " + minDeletionsForPalindromeSubstrings("abcddcba")); // Expected: 1

        // 4. Test Minimum Number of Coins
        int[] coins = {1, 2, 5};
        System.out.println("Minimum coins to make 11: " + minCoins(coins, 11)); // Expected: 3

        // 5. Test Maximum Product Cutting
        System.out.println("Maximum product by cutting rope of length 10: " + maxProductCutting(10)); // Expected: 36

        // 6. Test Ways to Cover a Distance
        System.out.println("Ways to cover distance of 4: " + waysToCoverDistance(4)); // Expected: 7

        // 7. Test Minimum Number of Deletions and Insertions to Transform One String into Another
        System.out.println("Min deletions and insertions to transform 'heap' into 'pea': " + minDeletionsAndInsertions("heap", "pea")); // Expected: 3

        // 8. Test Minimum Sum Subsequence such that at least one of every four consecutive elements is picked
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Min sum subsequence: " + minSumSubsequence(arr)); // Expected: 10 (picking 1, 5)
    }
}

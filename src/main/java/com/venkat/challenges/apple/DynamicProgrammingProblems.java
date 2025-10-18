package com.venkat.challenges.apple;

import java.util.*;

public class DynamicProgrammingProblems {

    // 1. 0/1 Knapsack
    public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    // 2. Coin Change (Min Coins)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i) dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 3. Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }

    // 4. Longest Common Subsequence
    public int lcs(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // 5. Edit Distance
    public int editDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        return dp[m][n];
    }

    // 6. Subset Sum
    public boolean subsetSum(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) dp[i][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum];
    }

    // 7. Matrix Chain Multiplication
    public int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    // 8. Rod Cutting
    public int cutRod(int[] prices, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    // 9. Egg Dropping Problem
    public int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                if (i == 1) dp[i][j] = j;
                else {
                    dp[i][j] = j;
                    for (int x = 1; x <= j; x++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]));
                    }
                }
            }
        }
        return dp[eggs][floors];
    }

    // 10. Wildcard Matching
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    // 11. Word Break Problem
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 12. Min Steps to Reduce to 1
    public int minStepsToOne(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        return dp[n];
    }

    // 13. Max Sum of Non-Adjacent Elements
    public int maxSumNonAdjacent(int[] nums) {
        int incl = 0, excl = 0;
        for (int num : nums) {
            int newIncl = excl + num;
            excl = Math.max(excl, incl);
            incl = newIncl;
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        DynamicProgrammingProblems dp = new DynamicProgrammingProblems();

        // 1. Knapsack
        System.out.println("Knapsack: " + dp.knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7));

        // 2. Coin Change
        System.out.println("Min Coins: " + dp.coinChange(new int[]{1, 2, 5}, 11));

        // 3. LIS
        System.out.println("LIS Length: " + dp.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        // 4. LCS
        System.out.println("LCS Length: " + dp.lcs("abcde", "ace"));

        // 5. Edit Distance
        System.out.println("Edit Distance: " + dp.editDistance("horse", "ros"));

        // 6. Subset Sum
        System.out.println("Subset Sum Exists: " + dp.subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));

        // 7. Matrix Chain Multiplication
        System.out.println("MCM Cost: " + dp.matrixChainOrder(new int[]{1, 2, 3, 4}));

        // 8. Rod Cutting
        System.out.println("Rod Cutting Max Profit: " + dp.cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));

        // 9. Egg Drop
        System.out.println("Egg Drop Min Attempts: " + dp.eggDrop(2, 10));

        // 10. Wildcard Match
        System.out.println("Wildcard Match: " + dp.isMatch("adceb", "*a*b"));

        // 11. Word Break
        System.out.println("Word Break: " + dp.wordBreak("leetcode", Arrays.asList("leet", "code")));

        // 12. Min Steps to 1
        System.out.println("Min Steps to 1: " + dp.minStepsToOne(10));

        // 13. Max Sum Non-Adjacent
        System.out.println("Max Sum Non-Adjacent: " + dp.maxSumNonAdjacent(new int[]{3, 2, 5, 10, 7}));
    }
}

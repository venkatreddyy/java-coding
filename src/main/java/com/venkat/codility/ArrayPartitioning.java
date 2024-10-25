package com.venkat.codility;

public class ArrayPartitioning {
    public boolean canPartition(int[] A) {
        int totalSum = 0;
        for (int num : A) totalSum += num;

        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : A) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        ArrayPartitioning obj = new ArrayPartitioning();
        int[] A = {1, 5, 11, 5};
        System.out.println(obj.canPartition(A));  // Output: true
    }
}


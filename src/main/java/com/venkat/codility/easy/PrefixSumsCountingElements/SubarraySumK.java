package com.venkat.codility.easy.PrefixSumsCountingElements;

public class SubarraySumK {
    public static boolean hasSubarraySumK(int[] arr, int K) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        int currentSum = 0;
        for (int value : arr) {
            currentSum += value;
            if (currentSum == K || set.contains(currentSum - K)) return true;
            set.add(currentSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        boolean result = hasSubarraySumK(arr, -10);
        System.out.println("Subarray with sum -10 exists: " + result);
    }
}
//Output: Subarray with sum -10 exists: true
package com.venkat.codility.easy.ArrayAndBasicIteration;

public class PermCheck {
    public static boolean isPermutation(int[] A) {
        int n = A.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        // Check for duplicates and calculate the actual sum
        for (int num : A) {
            if (!seen.add(num)) return false;
            actualSum += num;
        }
        return actualSum == expectedSum;
    }

    public static void main(String[] args) {
        boolean result = isPermutation(new int[]{4, 1, 3, 2});
        System.out.println("Is Permutation: " + result); // Output: true
    }
}


package com.venkat.codility.medium.ArrayAndBasicIteration;

public class TapeEquilibrium {
    public static int findMinDifference(int[] A) {
        int totalSum = 0, leftSum = 0, minDifference = Integer.MAX_VALUE;
        for (int num : A) totalSum += num;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            int rightSum = totalSum - leftSum;
            minDifference = Math.min(minDifference, Math.abs(leftSum - rightSum));
        }
        return minDifference;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 3};
        int result = findMinDifference(arr);
        System.out.println("Minimum Difference: " + result); // Output: 1
    }
}


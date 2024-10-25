package com.venkat.codility;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) totalSum += num;
        int leftSum = 0, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            int rightSum = totalSum - leftSum;
            minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
        }
        return minDiff;
    }

    public static void main(String[] args) {
        TapeEquilibrium obj = new TapeEquilibrium();
        int[] arr = {3, 1, 2, 4, 3};
        System.out.println(obj.solution(arr));  // Output: 1
    }
}

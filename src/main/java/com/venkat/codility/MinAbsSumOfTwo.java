package com.venkat.codility;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public int solution(int[] A) {
        Arrays.sort(A);

        int left = 0;
        int right = A.length - 1;
        int minSum = Integer.MAX_VALUE;

        while (left <= right) {
            int sum = A[left] + A[right];
            minSum = Math.min(minSum, Math.abs(sum));

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        MinAbsSumOfTwo obj = new MinAbsSumOfTwo();
        int[] A = {-8, 4, 5, -10, 3};
        System.out.println(obj.solution(A));  // Output: 1
    }
}


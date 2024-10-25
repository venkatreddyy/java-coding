package com.venkat.codility;

public class SmallestSubarrayWithSum {
    public int solution(int[] A, int S) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0, start = 0;

        for (int end = 0; end < A.length; end++) {
            sum += A[end];

            while (sum > S) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= A[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        SmallestSubarrayWithSum obj = new SmallestSubarrayWithSum();
        int[] A = {2, 3, 1, 2, 4, 3};
        System.out.println(obj.solution(A, 7));  // Output: 2
    }
}


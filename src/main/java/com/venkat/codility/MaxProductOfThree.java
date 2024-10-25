package com.venkat.codility;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        return Math.max(A[0] * A[1] * A[N - 1], A[N - 3] * A[N - 2] * A[N - 1]);
    }

    public static void main(String[] args) {
        MaxProductOfThree obj = new MaxProductOfThree();
        int[] A = {-3, 1, 2, -2, 5, 6};
        System.out.println(obj.solution(A));  // Output: 60
    }
}

package com.venkat.codility;

import java.util.Arrays;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle();
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(obj.solution(A));  // Output: 1
    }
}

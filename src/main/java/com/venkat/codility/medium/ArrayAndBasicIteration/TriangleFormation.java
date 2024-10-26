package com.venkat.codility.medium.ArrayAndBasicIteration;

import java.util.Arrays;

public class TriangleFormation {
    public static int canFormTriangle(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1; // Triangle can be formed
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 1, 8, 20};
        int result = canFormTriangle(arr);
        System.out.println("Can Form Triangle: " + result); // Output: 1
    }
}


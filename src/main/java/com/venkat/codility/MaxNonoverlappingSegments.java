package com.venkat.codility;

public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        if (A.length == 0) return 0;

        int count = 1;
        int end = B[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] > end) {
                count++;
                end = B[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxNonoverlappingSegments obj = new MaxNonoverlappingSegments();
        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};
        System.out.println(obj.solution(A, B));  // Output: 3
    }
}


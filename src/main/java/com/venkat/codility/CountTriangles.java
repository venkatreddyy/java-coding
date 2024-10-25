package com.venkat.codility;

import java.util.Arrays;

public class CountTriangles {
    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < A.length - 1; j++) {
                while (k < A.length && A[i] + A[j] > A[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTriangles obj = new CountTriangles();
        int[] A = {10, 2, 5, 1, 8, 12};
        System.out.println(obj.solution(A));  // Output: 4
    }
}


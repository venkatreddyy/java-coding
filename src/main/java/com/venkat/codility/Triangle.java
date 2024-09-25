package com.venkat.codility;

import java.util.Arrays;

public class Triangle {
    public static void main (String[] args) {
        int[] A = new int[] {10,2,5,1,8,20};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length < 3)
            return 0;
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            if ((long)A[i-2] + (long)A[i-1] > (long)A[i])
                return 1;
        }
        return 0;
    }
}

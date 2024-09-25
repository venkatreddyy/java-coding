package com.venkat.codility;

public class NumberOfDiscIntersection {
    public static void main (String[] args) {
        int[] A = new int[] {1, 5, 2, 1, 4, 0};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if ((long)A[i]+i >= j - (long)A[j]) {
                    x++;
                    if (x>10000000)
                        return -1;
                }
            }
        }
        return x;
    }
}

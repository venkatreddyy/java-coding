package com.venkat.codility;

import java.util.*;

public class DiscIntersections {
    public int solution(int[] A) {
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersections = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && upper[i] >= lower[j]) {
                intersections += j - i;
                j++;
                if (intersections > 10000000) return -1;
            }
        }

        return intersections;
    }

    public static void main(String[] args) {
        DiscIntersections obj = new DiscIntersections();
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(obj.solution(A));  // Output: 11
    }
}


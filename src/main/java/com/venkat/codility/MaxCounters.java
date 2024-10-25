package com.venkat.codility;

import java.util.*;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0, currentMax = 0;
        for (int val : A) {
            if (val >= 1 && val <= N) {
                counters[val - 1] = Math.max(counters[val - 1], maxCounter) + 1;
                currentMax = Math.max(currentMax, counters[val - 1]);
            } else if (val == N + 1) {
                maxCounter = currentMax;
            }
        }
        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], maxCounter);
        }
        return counters;
    }

    public static void main(String[] args) {
        MaxCounters obj = new MaxCounters();
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] result = obj.solution(5, A);
        for (int i : result) {
            System.out.print(i + " ");  // Output: 3 2 2 4 2
        }
    }
}


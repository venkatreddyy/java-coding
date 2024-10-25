package com.venkat.codility;

import java.util.HashMap;

public class Dominator {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(A[i], 0) + 1;
            map.put(A[i], count);
            if (count > n / 2) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Dominator obj = new Dominator();
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(obj.solution(A));  // Output: 7
    }
}


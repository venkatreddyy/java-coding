package com.venkat.codility;

import java.util.HashSet;

public class Distinct {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Distinct obj = new Distinct();
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(obj.solution(A));  // Output: 3
    }
}


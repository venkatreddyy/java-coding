package com.venkat.codility.medium.ArrayAndBasicIteration;

import java.util.HashSet;

public class MissingInteger {
    public static int findMissingInteger(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) if (num > 0) set.add(num);
        for (int i = 1; i <= A.length + 1; i++) if (!set.contains(i)) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};
        int result = findMissingInteger(arr);
        System.out.println("Smallest Missing Positive Integer: " + result); // Output: 5
    }
}


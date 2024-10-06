package com.venkat.challenges;

import java.util.HashSet;

public class DuplicateElements {
    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                System.out.println("Duplicate: " + num);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 6, 3};
        findDuplicates(arr);  // Output: Duplicate: 2, Duplicate: 3
    }
}

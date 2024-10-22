package com.venkat.challenges.top15;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {
    public static void findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicates: " + duplicates);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5, 6, 6};
        findDuplicates(arr); // Output: Duplicates: [3, 6]
    }
}

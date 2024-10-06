package com.venkat.challenges;

import java.util.HashSet;

public class FindDuplicateHashSet {
    public static int findDuplicate(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num; // Duplicate found
            }
            seen.add(num); // Add number to the set
        }
        return -1; // No duplicate found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number is: " + findDuplicate(arr));
    }
}


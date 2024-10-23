package com.venkat.challenges.top15;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {
    // Method to find duplicates in an array
    public static void findDuplicates(int[] arr) {
        // Set to store elements that we've already seen
        Set<Integer> seen = new HashSet<>();

        // Set to store elements that are found to be duplicates
        Set<Integer> duplicates = new HashSet<>();

        // Loop through each element in the input array
        for (int num : arr) {
            // Try to add the current element to the 'seen' set
            // If the element already exists in the set, it means it's a duplicate
            if (!seen.add(num)) {
                // Add the duplicate element to the 'duplicates' set
                duplicates.add(num);
            }
        }

        // Print out the set of duplicates
        System.out.println("Duplicates"+ duplicates);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5, 6, 6};
        findDuplicates(arr); // Output: Duplicates: [3, 6]
    }
}

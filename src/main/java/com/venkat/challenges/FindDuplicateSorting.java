package com.venkat.challenges;

import java.util.Arrays;

public class FindDuplicateSorting {
    public static int findDuplicate(int[] arr) {
        Arrays.sort(arr); // Sort the array first
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i]; // Duplicate found
            }
        }
        return -1; // No duplicate found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number is: " + findDuplicate(arr));
    }
}


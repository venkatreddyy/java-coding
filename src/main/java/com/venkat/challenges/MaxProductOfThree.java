package com.venkat.challenges;
import java.util.Arrays;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main (String[] args) {
        // Example array to test the solution
        int[] A = new int[] {-3, 1, 2, -2, 5, 6};

        // Call the solution method and print the result
        System.out.println(solution(A));  // Expected output: 60
    }

    // Method to find the maximum product of any three integers in the array
    public static int solution(int[] A) {
        // Sort the array
        Arrays.sort(A);

        // Print the sorted array (for debugging purposes)
        System.out.println("Sorted array: " + Arrays.toString(A));

        // Calculate two possible maximum products:
        // 1. Product of the three largest numbers (all at the end of the sorted array)
        int max1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        // 2. Product of the largest number and the two smallest numbers (could be negative)
        int max2 = A[A.length - 1] * A[0] * A[1];

        // Return the maximum of the two computed products using Math.max()
        return Math.max(max1, max2);
    }
}


package com.venkat.codility.easy.ArrayAndBasicIteration;

public class OddOccurrencesInArray {
    public static int findOddOccurrence(int[] A) {
        int result = 0;
        // XOR all elements to find the one with an odd occurrence
        for (int num : A) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = findOddOccurrence(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println("Odd Occurrence Element: " + result); // Output: 7
    }
}


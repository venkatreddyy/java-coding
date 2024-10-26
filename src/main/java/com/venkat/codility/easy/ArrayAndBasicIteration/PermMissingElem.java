package com.venkat.codility.easy.ArrayAndBasicIteration;

public class PermMissingElem {
    public static int missingElement(int[] A) {
        int n = A.length + 1;
        int total = n * (n + 1) / 2;
        // Subtract each element from the total to find the missing number
        for (int num : A) {
            total -= num;
        }
        return total;
    }

    public static void main(String[] args) {
        int result = missingElement(new int[]{2, 3, 1, 5});
        System.out.println("Missing Element: " + result); // Output: 4
    }
}


package com.venkat.codility.easy.searchsort;

public class SearchInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        // Start search from the top-right corner
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--; // Move left if greater
            else row++; // Move down if smaller
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = searchMatrix(matrix, 5);
        System.out.println("Element 5 found: " + result); // Output: true
    }
}


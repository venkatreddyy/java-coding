package com.venkat.challenges;

public class MatrixTranspose {

    // Method to transpose a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        // Get the number of rows and columns from the original matrix
        int rows = matrix.length;         // Number of rows in the original matrix
        int cols = matrix[0].length;      // Number of columns in the original matrix

        // Initialize the transposed matrix with dimensions cols x rows (flipped dimensions)
        int[][] transpose = new int[cols][rows];

        // Loop through the original matrix to populate the transposed matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Swap row and column indices to transpose the matrix
                transpose[j][i] = matrix[i][j];
            }
        }

        // Return the transposed matrix
        return transpose;
    }

    // Main method to test the transposeMatrix method
    public static void main(String[] args) {
        // Define a 3x2 matrix
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};

        // Call the method to transpose the matrix
        int[][] transpose = transposeMatrix(matrix);

        // Print the transposed matrix
        for (int[] row : transpose) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();  // Print a new line after each row
        }
    }
}


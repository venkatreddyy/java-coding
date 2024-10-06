package com.venkat.challenges;

public class MatrixAddition {
    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        // Get the number of rows and columns in the matrix
        int rows = a.length;       // Number of rows in matrix 'a'
        int cols = a[0].length;    // Number of columns in matrix 'a'

        // Initialize the result matrix with the same dimensions as the input matrices
        int[][] result = new int[rows][cols];

        // Iterate over every element in the matrices
        for (int i = 0; i < rows; i++) {        // Loop through each row
            for (int j = 0; j < cols; j++) {    // Loop through each column
                // Add corresponding elements of matrices 'a' and 'b'
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        // Return the resultant matrix after addition
        return result;
    }

    // Main method to test the matrix addition
    public static void main(String[] args) {
        // Define two 2x2 matrices
        /*
        Matrix A:
        1 2
        3 4

        Matrix B:
        5 6
        7 8

        Resultant Matrix:
        6 8
        10 12

         */
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        /*
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        Number of rows: 2
        Number of columns: 3 matrixA has two rows ({1, 2, 3} and {4, 5, 6}). matrixA[0].length . 3 columns
         */

        // Add the matrices and store the result
        int[][] result = addMatrices(matrixA, matrixB);

        // Print the resultant matrix
        for (int[] row : result) {         // Iterate through each row of the result matrix
            for (int elem : row) {         // Iterate through each element in the row
                System.out.print(elem + " ");  // Print the element followed by a space
            }
            System.out.println();          // Print a newline after each row
        }
    }
}


package com.venkat.challenges;

/*
result[0][0] = (1*5) + (2*7) = 5 + 14 = 19
result[0][1] = (1*6) + (2*8) = 6 + 16 = 22
result[1][0] = (3*5) + (4*7) = 15 + 28 = 43
result[1][1] = (3*6) + (4*8) = 18 + 32 = 50
The resulting matrix will be:
Result=[19 22
        43  50]
Output:
19 22
43 50
 */
public class MatrixMultiplication {

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        // Get the number of rows and columns for matrix A and matrix B
        int rowsA = a.length;         // Number of rows in matrix A
        int colsA = a[0].length;      // Number of columns in matrix A (also number of rows in matrix B)
        int colsB = b[0].length;      // Number of columns in matrix B

        // Initialize the result matrix with dimensions rowsA x colsB
        int[][] result = new int[rowsA][colsB];

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {           // Loop through rows of matrix A
            for (int j = 0; j < colsB; j++) {       // Loop through columns of matrix B
                for (int k = 0; k < colsA; k++) {   // Loop through columns of matrix A and rows of matrix B
                    // Multiply and accumulate values
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;  // Return the result matrix
    }

    // Main method to test matrix multiplication
    public static void main(String[] args) {
        // Define two matrices
        int[][] matrixA = {{1, 2}, {3, 4}};    // 2x2 matrix
        int[][] matrixB = {{5, 6}, {7, 8}};    // 2x2 matrix

        // Call the method to multiply the matrices
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // Print the result matrix
        for (int[] row : result) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();  // Print a new line after each row
        }
    }
}


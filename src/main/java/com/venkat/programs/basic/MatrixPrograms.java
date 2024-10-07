package com.venkat.programs.basic;

import java.util.Arrays;
/*
Explanation of Comments:
addMatrices(): Loops through the matrix and adds corresponding elements.
subtractMatrices(): Loops through the matrix and subtracts corresponding elements.
multiplyMatrices(): Performs standard matrix multiplication.
areMatricesEqual(): Checks whether two matrices are identical by comparing row by row.
printLowerTriangularMatrix(): Prints only the lower triangular part of a matrix.
printUpperTriangularMatrix(): Prints only the upper triangular part of a matrix.
findOddEvenFrequency(): Counts the number of odd and even numbers in the matrix.
findProductOfMatrices(): Calls multiplyMatrices() to compute the product of two matrices.
sumOfRowsAndColumns(): Computes and prints the sum of each row and each column.
transposeMatrix(): Computes and returns the transpose of a given matrix.
isIdentityMatrix(): Checks if the given matrix is an identity matrix.
isSparseMatrix(): Checks if the matrix is sparse (more than half of its elements are zero).
transposeMatrixRepeated(): Reuses the transposeMatrix() method.
printMatrix(): Helper method to print the matrix row by row.
Example Output:
yaml
Copy code
Addition of Matrices:
[10, 10, 10]
[10, 10, 10]
[10, 10, 10]
Subtraction of Matrices:
[-8, -6, -4]
[-2, 0, 2]
[4, 6, 8]
Multiplication of Matrices:
[30, 24, 18]
[84, 69, 54]
[138, 114, 90]
Are Matrices Equal? false
Lower Triangular Matrix:
1 0 0
4 5 0
7 8 9
Upper Triangular Matrix:
1 2 3
0 5 6
0 0 9
Odd numbers: 5
Even numbers: 4
Product of Matrices:
[30, 24, 18]
[84, 69, 54]
[138, 114, 90]
Sum of Rows and Columns:
Sum of row 0: 6
Sum of row 1: 15
Sum of row 2: 24
Sum of column 0: 12
Sum of column 1: 15
Sum of column 2: 18
Transpose of Matrix A:
[1, 4, 7]
[2, 5, 8]
[3, 6, 9]
Is Matrix A Identity Matrix? false
Is Matrix A Sparse Matrix? false
This class contains each method with a detailed comment, explaining each line of code for matrix operations.
 */
public class MatrixPrograms {

    // 1) Java Program to Add Two Matrices
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length; // Get the number of rows
        int cols = matrixA[0].length; // Get the number of columns
        int[][] result = new int[rows][cols]; // Create a result matrix of the same size

        // Loop through each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j]; // Add corresponding elements
            }
        }
        return result; // Return the result matrix
    }

    // 2) Java Program to Subtract Two Matrices
    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length; // Get the number of rows
        int cols = matrixA[0].length; // Get the number of columns
        int[][] result = new int[rows][cols]; // Create a result matrix of the same size

        // Loop through each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j]; // Subtract corresponding elements
            }
        }
        return result; // Return the result matrix
    }

    // 3) Java Program to Multiply Two Matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length; // Get the number of rows in matrix A
        int colsA = matrixA[0].length; // Get the number of columns in matrix A
        int colsB = matrixB[0].length; // Get the number of columns in matrix B
        int[][] result = new int[rowsA][colsB]; // Create a result matrix with rowsA x colsB size

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j]; // Multiply and sum up products
                }
            }
        }
        return result; // Return the result matrix
    }

    // 4) Java Program to Check if Two Matrices are Equal
    public static boolean areMatricesEqual(int[][] matrixA, int[][] matrixB) {
        // Check if dimensions are different, return false
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            return false; // If dimensions don't match, matrices are not equal
        }

        // Compare each row of matrix A and matrix B
        for (int i = 0; i < matrixA.length; i++) {
            if (!Arrays.equals(matrixA[i], matrixB[i])) { // Compare rows using Arrays.equals()
                return false; // Return false if any row is not equal
            }
        }
        return true; // Return true if all rows are equal
    }

    // 5) Java Program to Display the Lower Triangular Matrix
    public static void printLowerTriangularMatrix(int[][] matrix) {
        // Loop through each element of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i >= j) {
                    System.out.print(matrix[i][j] + " "); // Print elements on or below diagonal
                } else {
                    System.out.print("0 "); // Print 0 for elements above diagonal
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 6) Java Program to Display the Upper Triangular Matrix
    public static void printUpperTriangularMatrix(int[][] matrix) {
        // Loop through each element of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i <= j) {
                    System.out.print(matrix[i][j] + " "); // Print elements on or above diagonal
                } else {
                    System.out.print("0 "); // Print 0 for elements below diagonal
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // 7) Java Program to Find the Frequency of Odd & Even Numbers in a Matrix
    public static void findOddEvenFrequency(int[][] matrix) {
        int oddCount = 0, evenCount = 0; // Initialize counters

        // Loop through each element of the matrix
        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 == 0) {
                    evenCount++; // Increment even count for even numbers
                } else {
                    oddCount++; // Increment odd count for odd numbers
                }
            }
        }

        // Print the frequencies
        System.out.println("Odd numbers: " + oddCount);
        System.out.println("Even numbers: " + evenCount);
    }

    // 8) Java Program to Find the Product of Two Matrices (Same as multiplication)
    public static int[][] findProductOfMatrices(int[][] matrixA, int[][] matrixB) {
        return multiplyMatrices(matrixA, matrixB); // Reusing multiplyMatrices() method
    }

    // 9) Java Program to Find the Sum of Each Row and Each Column of a Matrix
    public static void sumOfRowsAndColumns(int[][] matrix) {
        int rows = matrix.length; // Get the number of rows
        int cols = matrix[0].length; // Get the number of columns

        // Calculate the sum of each row
        for (int i = 0; i < rows; i++) {
            int rowSum = 0; // Initialize row sum
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j]; // Add elements of the current row
            }
            System.out.println("Sum of row " + i + ": " + rowSum); // Print row sum
        }

        // Calculate the sum of each column
        for (int j = 0; j < cols; j++) {
            int colSum = 0; // Initialize column sum
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j]; // Add elements of the current column
            }
            System.out.println("Sum of column " + j + ": " + colSum); // Print column sum
        }
    }

    // 10) Java Program to Find the Transpose of a Given Matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length; // Get the number of rows
        int cols = matrix[0].length; // Get the number of columns
        int[][] transpose = new int[cols][rows]; // Create transpose matrix with swapped dimensions

        // Loop through each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j]; // Swap rows and columns
            }
        }
        return transpose; // Return the transpose matrix
    }

    // 11) Java Program to Determine Whether a Matrix is an Identity Matrix
    public static boolean isIdentityMatrix(int[][] matrix) {
        // Check if matrix is square
        if (matrix.length != matrix[0].length) {
            return false; // An identity matrix must be square
        }

        // Check if it satisfies identity matrix conditions
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false; // Diagonal elements must be 1
                }
                if (i != j && matrix[i][j] != 0) {
                    return false; // Non-diagonal elements must be 0
                }
            }
        }
        return true; // Return true if the matrix is an identity matrix
    }

    // 12) Java Program to Determine Whether a Matrix is a Sparse Matrix
    public static boolean isSparseMatrix(int[][] matrix) {
        int zeroCount = 0; // Initialize counter for zero elements
        int totalElements = matrix.length * matrix[0].length; // Calculate the total number of elements

        // Loop through each element of the matrix
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) {
                    zeroCount++; // Increment zero count if element is 0
                }
            }
        }

        // Check if the number of zeros is more than half of the total elements
        return zeroCount > totalElements / 2; // Return true if it's a sparse matrix
    }

    // 13) Java Program to Transpose Matrix (Repeated method for clarity)
    public static int[][] transposeMatrixRepeated(int[][] matrix) {
        return transposeMatrix(matrix); // Reusing the transposeMatrix() method
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)); // Print each row of the matrix
        }
    }

    // Main method to test all matrix programs
    public static void main(String[] args) {
        // Define two sample matrices for testing
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrixB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        // Test Addition of Matrices
        System.out.println("Addition of Matrices:");
        printMatrix(addMatrices(matrixA, matrixB));

        // Test Subtraction of Matrices
        System.out.println("Subtraction of Matrices:");
        printMatrix(subtractMatrices(matrixA, matrixB));

        // Test Multiplication of Matrices
        System.out.println("Multiplication of Matrices:");
        printMatrix(multiplyMatrices(matrixA, matrixB));

        // Test Equality of Matrices
        System.out.println("Are Matrices Equal? " + areMatricesEqual(matrixA, matrixB));

        // Test Lower Triangular Matrix
        System.out.println("Lower Triangular Matrix:");
        printLowerTriangularMatrix(matrixA);

        // Test Upper Triangular Matrix
        System.out.println("Upper Triangular Matrix:");
        printUpperTriangularMatrix(matrixA);

        // Test Frequency of Odd & Even Numbers in the Matrix
        findOddEvenFrequency(matrixA);

        // Test Product of Matrices
        System.out.println("Product of Matrices:");
        printMatrix(findProductOfMatrices(matrixA, matrixB));

        // Test Sum of Rows and Columns
        System.out.println("Sum of Rows and Columns:");
        sumOfRowsAndColumns(matrixA);

        // Test Transpose of Matrix
        System.out.println("Transpose of Matrix A:");
        printMatrix(transposeMatrix(matrixA));

        // Test if Matrix is an Identity Matrix
        System.out.println("Is Matrix A Identity Matrix? " + isIdentityMatrix(matrixA));

        // Test if Matrix is a Sparse Matrix
        System.out.println("Is Matrix A Sparse Matrix? " + isSparseMatrix(matrixA));
    }
}


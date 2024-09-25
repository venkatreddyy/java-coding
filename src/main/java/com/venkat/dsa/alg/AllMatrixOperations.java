package com.venkat.dsa.alg;

import java.util.Arrays;
/*
Explanation:
printMatrix(): Prints the matrix.
addMatrices(): Adds two matrices.
multiplyMatrices(): Multiplies two matrices.
subtractMatrices(): Subtracts matrix B from matrix A.
areMatricesEqual(): Checks if two matrices are equal.
displayLowerTriangularMatrix(): Displays the lower triangular matrix.
displayUpperTriangularMatrix(): Displays the upper triangular matrix.
findOddEvenFrequency(): Finds the frequency of odd and even numbers in a matrix.
productOfMatrices(): Same as multiplication.
 */
class AllMatrixOperations {

    // 1) Method to print a matrix
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 2) Add two matrices
    public int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    // 3) Multiply two matrices
    public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // 4) Subtract two matrices
    public int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    // 5) Check if two matrices are equal
    public boolean areMatricesEqual(int[][] matrixA, int[][] matrixB) {
        return Arrays.deepEquals(matrixA, matrixB);
    }

    // 6) Display lower triangular matrix
    public void displayLowerTriangularMatrix(int[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i >= j) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // 7) Display upper triangular matrix
    public void displayUpperTriangularMatrix(int[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i <= j) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // 8) Find the frequency of odd and even numbers in the matrix
    public void findOddEvenFrequency(int[][] matrix) {
        int oddCount = 0;
        int evenCount = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }
        System.out.println("Odd numbers: " + oddCount);
        System.out.println("Even numbers: " + evenCount);
    }

    // 9) Find the product of two matrices (same as multiplication)
    public int[][] productOfMatrices(int[][] matrixA, int[][] matrixB) {
        return multiplyMatrices(matrixA, matrixB);
    }

    // 10) Find the sum of each row and column of a matrix
    public void sumOfRowsAndColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + ": " + rowSum);
        }

        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of column " + (j + 1) + ": " + colSum);
        }
    }

    // 11) Transpose of a given matrix
    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // 12) Check if a given matrix is an identity matrix
    public boolean isIdentityMatrix(int[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 13) Check if a given matrix is a sparse matrix (majority elements are zero)
    public boolean isSparseMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int zeroCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) {
                    zeroCount++;
                }
            }
        }
        return zeroCount > (rows * cols) / 2;
    }

    // Driver code to test all methods
    public static void main(String[] args) {
        AllMatrixOperations operations = new AllMatrixOperations();

        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        System.out.println("Matrix A:");
        operations.printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        operations.printMatrix(matrixB);

        System.out.println("\n2) Addition of Matrices:");
        operations.printMatrix(operations.addMatrices(matrixA, matrixB));

        System.out.println("\n3) Multiplication of Matrices:");
        operations.printMatrix(operations.multiplyMatrices(matrixA, matrixB));

        System.out.println("\n4) Subtraction of Matrices:");
        operations.printMatrix(operations.subtractMatrices(matrixA, matrixB));

        System.out.println("\n5) Are matrices A and B equal: " + operations.areMatricesEqual(matrixA, matrixB));

        System.out.println("\n6) Lower Triangular Matrix of A:");
        operations.displayLowerTriangularMatrix(matrixA);

        System.out.println("\n7) Upper Triangular Matrix of A:");
        operations.displayUpperTriangularMatrix(matrixA);

        System.out.println("\n8) Frequency of odd and even numbers in Matrix A:");
        operations.findOddEvenFrequency(matrixA);

        System.out.println("\n9) Product of Matrices (A * B):");
        operations.printMatrix(operations.productOfMatrices(matrixA, matrixB));

        System.out.println("\n10) Sum of rows and columns of Matrix A:");
        operations.sumOfRowsAndColumns(matrixA);

        System.out.println("\n11) Transpose of Matrix A:");
        operations.printMatrix(operations.transposeMatrix(matrixA));

        System.out.println("\n12) Is Matrix A an identity matrix: " + operations.isIdentityMatrix(matrixA));

        System.out.println("\n13) Is Matrix A a sparse matrix: " + operations.isSparseMatrix(matrixA));
    }
}


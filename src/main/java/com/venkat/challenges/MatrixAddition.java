package com.venkat.challenges;

public class MatrixAddition {
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        int[][] result = addMatrices(matrixA, matrixB);
        for (int[] row : result) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}


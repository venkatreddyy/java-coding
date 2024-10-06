package com.venkat.challenges;

public class MatrixTranspose {
    public static int[][] transposeMatrix(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        int[][] transpose = transposeMatrix(matrix);
        for (int[] row : transpose) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}

package com.venkat.hundred;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Inputs and Outputs:
Transpose of a Matrix:

Input: {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
Output:
Copy code
1 4 7
2 5 8
3 6 9
Rotate a Matrix by 90 Degrees:

Input: {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
Output:
Copy code
7 4 1
8 5 2
9 6 3
Determinant of a Matrix:

Input: {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}}
Output: 1
Sum of Diagonals:

Input: {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}
Output: 25
Print Spiral Order:

Input: {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}
Output: 7 4 1 2 3 6 9 8 5
Longest Path in a Matrix:

Input: {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}
Output: 4
Number of Islands:

Input: {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 1}}
Output: 2
Search an Element in a Sorted Matrix:

Input: {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}}, target 9
Output: true
Set Matrix Zeroes:

Input: {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}
Output:
Copy code
1 0 1
0 0 0
1 0 1
Shortest Path in a Maze:

Input: {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}}, start (0, 0), end (2, 2)
Output: 4
 */
public class MatrixPrograms {

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // 1. Find the Transpose of a Matrix
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;  // Number of rows
        int cols = matrix[0].length;  // Number of columns
        int[][] transposed = new int[cols][rows];  // Create new matrix with swapped dimensions

        // Transpose: swap rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];  // Swap elements
            }
        }
        return transposed;
    }

    // 2. Rotate a Matrix by 90 Degrees
    public static void rotateMatrix90Degrees(int[][] matrix) {
        int n = matrix.length;  // Size of the matrix (assuming square matrix)

        // First step is to transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // 3. Find the Determinant of a Matrix (Recursively for square matrices)
    public static int determinant(int[][] matrix) {
        int n = matrix.length;

        // Base case: 2x2 matrix
        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        int det = 0;
        for (int i = 0; i < n; i++) {
            int[][] minor = getMinor(matrix, 0, i);
            det += matrix[0][i] * determinant(minor) * (i % 2 == 0 ? 1 : -1);  // Cofactor expansion
        }
        return det;
    }

    // Helper method to get minor matrix
    private static int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];

        for (int i = 0, r = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, c = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }

    // 4. Find the Sum of Diagonals of a Matrix
    public static int sumOfDiagonals(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];  // Primary diagonal
            if (i != n - i - 1) {  // Secondary diagonal (avoid double-counting center in odd-size matrices)
                sum += matrix[i][n - i - 1];
            }
        }
        return sum;
    }

    // 5. Print a Matrix in Spiral Order
    public static void printSpiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // Traverse downwards
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            // Traverse upwards
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    // 6. Find the Longest Path in a Matrix (DP + DFS)
    public static int longestPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];  // DP array for caching results
        int longest = 0;

        // Compute longest path for each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, dp));
            }
        }
        return longest;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];  // Return cached result

        int[] rowDirs = {-1, 1, 0, 0};
        int[] colDirs = {0, 0, -1, 1};
        int maxPath = 1;

        // Explore all 4 directions
        for (int d = 0; d < 4; d++) {
            int newRow = i + rowDirs[d];
            int newCol = j + colDirs[d];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, newRow, newCol, dp));
            }
        }
        dp[i][j] = maxPath;  // Store the result in DP table
        return maxPath;
    }

    // 7. Find the Number of Islands in a Matrix (DFS)
    public static int numIslands(int[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfsIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private static void dfsIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;  // Mark the cell as visited
        dfsIsland(grid, i - 1, j);  // Up
        dfsIsland(grid, i + 1, j);  // Down
        dfsIsland(grid, i, j - 1);  // Left
        dfsIsland(grid, i, j + 1);  // Right
    }

    // 8. Search an Element in a Sorted Matrix
    public static boolean searchInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }
        return false;
    }

    // 9. Set Matrix Zeroes (Row/Column if an Element is 0)
    public static void setMatrixZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if first row or first column has zeroes
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // Mark the first row and column for zeroing
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows and columns to zero based on marks
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle the first row and column separately
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 10. Find Shortest Path in a Maze (BFS)
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int shortestPathInMaze(int[][] maze, Point start, Point end) {
        if (maze[start.x][start.y] == 0 || maze[end.x][end.y] == 0) return -1;

        int[] rowDirs = {-1, 1, 0, 0};
        int[] colDirs = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int pathLength = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.x == end.x && current.y == end.y) {
                    return pathLength;
                }

                for (int d = 0; d < 4; d++) {
                    int newRow = current.x + rowDirs[d];
                    int newCol = current.y + colDirs[d];

                    if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                            && maze[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        queue.add(new Point(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
            pathLength++;
        }

        return -1;  // No path found
    }

    public static void main(String[] args) {
        // Example inputs and outputs for each function:

        // 1. Transpose of a matrix
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Transpose of matrix:");
        printMatrix(transpose(matrix));

        // 2. Rotate a matrix by 90 degrees
        System.out.println("\nMatrix after 90-degree rotation:");
        rotateMatrix90Degrees(matrix);
        printMatrix(matrix);

        // 3. Determinant of a matrix
        int[][] detMatrix = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        System.out.println("\nDeterminant of matrix: " + determinant(detMatrix));

        // 4. Sum of diagonals
        System.out.println("\nSum of diagonals: " + sumOfDiagonals(matrix));

        // 5. Print spiral order
        System.out.println("\nSpiral order of matrix:");
        printSpiralOrder(matrix);

        // 6. Longest path in matrix
        int[][] pathMatrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println("\nLongest path in matrix: " + longestPath(pathMatrix));

        // 7. Number of islands
        int[][] islandMatrix = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 1}};
        System.out.println("\nNumber of islands: " + numIslands(islandMatrix));

        // 8. Search an element in sorted matrix
        int[][] sortedMatrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        System.out.println("\nElement 9 found: " + searchInSortedMatrix(sortedMatrix, 9));

        // 9. Set matrix zeroes
        int[][] zeroMatrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setMatrixZeroes(zeroMatrix);
        System.out.println("\nMatrix after setting zeroes:");
        printMatrix(zeroMatrix);

        // 10. Shortest path in a maze
        int[][] maze = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        System.out.println("\nShortest path in maze: " + shortestPathInMaze(maze, new Point(0, 0), new Point(2, 2)));
    }
}


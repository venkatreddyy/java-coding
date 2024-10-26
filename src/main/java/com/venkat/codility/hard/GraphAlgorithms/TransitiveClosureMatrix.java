package com.venkat.codility.hard.GraphAlgorithms;

import java.util.Arrays;
/*
4. Transitive Closure Matrix
Problem: Compute the transitive closure matrix for a directed graph. The transitive closure matrix T has T[i][j] = 1 if there is a path from i to j.

Approach:

Use Floyd-Warshall algorithm to fill in reachability between nodes.
Initialize T[i][j] = 1 if there is a direct edge from i to j.

Explanation:
Floyd-Warshall is used to determine reachability, updating reachability matrix based on intermediate nodes.
Example Output:

csharp
Copy code
Transitive Closure Matrix:
[1, 1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1]
[0, 0, 0, 1]
 */
public class TransitiveClosureMatrix {

    public static int[][] transitiveClosure(int[][] graph) {
        int n = graph.length;
        int[][] reach = new int[n][n];

        // Initialize reachability matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, reach[i], 0, n);
            reach[i][i] = 1; // Each node is reachable to itself
        }

        // Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    reach[i][j] = reach[i][j] | (reach[i][k] & reach[k][j]);
                }
            }
        }

        return reach;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0}
        };

        int[][] transitiveClosure = transitiveClosure(graph);
        System.out.println("Transitive Closure Matrix:");
        for (int[] row : transitiveClosure) {
            System.out.println(Arrays.toString(row));
        }
    }
}


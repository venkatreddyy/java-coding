package com.venkat.dsa.javaCollections;

import java.util.Scanner;

/*
Explanation:
The GraphAdjacencyMatrix class has an adjacency matrix (int[][] adjacencyMatrix) that represents the graph.
The addEdge() method adds an edge between two vertices by setting the corresponding positions in the matrix to 1.
For example, if there is an edge between vertex 0 and vertex 1, adjacencyMatrix[0][1] and adjacencyMatrix[1][0] will be set to 1 (for an undirected graph).
The removeEdge() method removes an edge by setting the corresponding positions in the matrix to 0.
The displayMatrix() method prints out the adjacency matrix.

Adjacency Matrix:
0 1 0 0 1
1 0 1 1 1
0 1 0 1 0
0 1 1 0 1
1 1 0 1 0

After removing the edge between 0 and 4:
Adjacency Matrix:
0 1 0 0 0
1 0 1 1 1
0 1 0 1 0
0 1 1 0 1
0 1 0 1 0

 */
public class GraphAdjacencyMatrix {
    private int vertices;          // Number of vertices in the graph
    private int[][] adjacencyMatrix;  // 2D array to represent the adjacency matrix

    // Constructor to initialize the graph with the given number of vertices
    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        // Since this is an undirected graph, set both adjacencyMatrix[source][destination] and adjacencyMatrix[destination][source] to 1
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;  // For directed graph, remove this line
    }

    // Remove an edge between two vertices
    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;  // For directed graph, remove this line
    }

    // Print the adjacency matrix
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a graph with 5 vertices
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);

        // Add edges
        graph.addEdge(0, 1);  // Edge between vertex 0 and vertex 1
        graph.addEdge(0, 4);  // Edge between vertex 0 and vertex 4
        graph.addEdge(1, 2);  // Edge between vertex 1 and vertex 2
        graph.addEdge(1, 3);  // Edge between vertex 1 and vertex 3
        graph.addEdge(1, 4);  // Edge between vertex 1 and vertex 4
        graph.addEdge(2, 3);  // Edge between vertex 2 and vertex 3
        graph.addEdge(3, 4);  // Edge between vertex 3 and vertex 4

        // Display the adjacency matrix
        graph.displayMatrix();

        // Remove an edge
        graph.removeEdge(0, 4);
        System.out.println("\nAfter removing the edge between 0 and 4:");
        graph.displayMatrix();

        scanner.close();
    }
}


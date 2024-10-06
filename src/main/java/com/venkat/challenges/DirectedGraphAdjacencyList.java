package com.venkat.challenges;

import java.util.ArrayList;
import java.util.List;
/*
Problem Overview:
An adjacency list is used to represent graphs. For every vertex in the graph, the adjacency list contains a list of all the other vertices to which it has a directed edge.

Problem:
Given the number of vertices V and the list of edges in a directed graph, construct the adjacency list for the graph.

Example Input:
Number of vertices (V): 3
Edges: edges[][] = {{0, 1}, {1, 2}, {2, 0}}
Visual Representation of the Graph:
The image shows a directed graph where:

Vertex 0 points to vertex 1.
Vertex 1 points to vertex 2.
Vertex 2 points back to vertex 0.
Output (Adjacency List Representation):
For the given input, the adjacency list should look like:

rust
Copy code
0 -> 1
1 -> 2
2 -> 0
This adjacency list indicates the directed edges between the vertices in the graph.

Explanation:
Vertex 0 has a directed edge to Vertex 1.
Vertex 1 has a directed edge to Vertex 2.
Vertex 2 has a directed edge to Vertex 0.
This completes the representation of the graph as an adjacency list for the directed edges given in the input.
 */
public class DirectedGraphAdjacencyList {

    // Method to create and print the adjacency list for the directed graph
    public static void createAdjacencyList(int V, int[][] edges) {
        // Create an array of lists for adjacency list representation
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        for (int[] edge : edges) {
            int u = edge[0]; // Start vertex
            int v = edge[1]; // End vertex
            adjList.get(u).add(v); // Directed edge from u to v
        }

        // Print the adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}}; // Directed edges

        // Create and print the adjacency list
        createAdjacencyList(V, edges);
    }
}


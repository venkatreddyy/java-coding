package com.venkat.dsa.patterns;

import java.util.*;

public class TopologicalSortKahn {

    // Function to perform Topological Sort using Kahn's Algorithm
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adjList) {
        int[] inDegree = new int[V]; // Array to store in-degree of each vertex
        List<Integer> result = new ArrayList<>(); // List to store the topological order
        Queue<Integer> queue = new LinkedList<>(); // Queue for vertices with zero in-degree

        // Calculate in-degree for each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Add vertices with zero in-degree to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process vertices in queue
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Remove a vertex with zero in-degree
            result.add(current); // Add to the topological sort order

            // Decrease the in-degree of its neighbors
            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;
                // If in-degree becomes zero, add the neighbor to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If all vertices are processed, return the result
        if (result.size() == V) {
            return result;
        } else {
            return new ArrayList<>(); // Return an empty list if the graph has a cycle
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Integer>> adjList = new ArrayList<>(); // Adjacency list for the graph

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Example graph:
        // 5 → 0, 5 → 2, 4 → 0, 4 → 1, 2 → 3, 3 → 1
        adjList.get(5).add(0);
        adjList.get(5).add(2);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        // Perform Topological Sort
        List<Integer> result = topologicalSort(V, adjList);

        // Print the Topological Sort result
        if (!result.isEmpty()) {
            System.out.println("Topological Sort:");
            for (int node : result) {
                System.out.print(node + " ");
            }
        } else {
            System.out.println("Graph has a cycle, no topological ordering possible.");
        }
    }
}


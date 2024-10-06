package com.venkat.dsa.patterns;

import java.util.*;

public class TopologicalSortKahns {

    // Function to perform Kahn's Algorithm for topological sorting
    public List<Integer> topologicalSort(int numVertices, Map<Integer, List<Integer>> graph) {
        int[] inDegree = new int[numVertices];
        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Calculate in-degree for each vertex
        for (int vertex : graph.keySet()) {
            for (int neighbor : graph.get(vertex)) {
                inDegree[neighbor]++;
            }
        }

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topoOrder.add(vertex);  // Add the vertex to the topological order

            // For each neighbor, reduce its in-degree
            if (graph.get(vertex) != null) {
                for (int neighbor : graph.get(vertex)) {
                    inDegree[neighbor]--;

                    // If in-degree becomes 0, enqueue the neighbor
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // If all vertices are processed, return the topological order
        if (topoOrder.size() == numVertices) {
            return topoOrder;
        } else {
            return new ArrayList<>();  // Return an empty list if the graph contains a cycle
        }
    }

    public static void main(String[] args) {
        TopologicalSortKahns topoSort = new TopologicalSortKahns();

        // Example directed graph (as an adjacency list)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList());

        // Perform topological sorting using Kahn's algorithm
        List<Integer> topoOrder = topoSort.topologicalSort(5, graph);

        // Print the topological order
        System.out.println("Topological Sort Order: " + topoOrder);
        // Output: Topological Sort Order: [0, 1, 2, 4, 3]
    }
}


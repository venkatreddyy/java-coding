package com.venkat.dsa.patterns;

import java.util.*;

public class GraphDFS {

    // Perform DFS on a graph starting from a given node
    public void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        // Mark the node as visited
        visited.add(node);
        System.out.print(node + " "); // Process the current node (print or any other operation)

        // Explore all the neighbors of the current node
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited); // Recursive DFS call
            }
        }
    }

    public static void main(String[] args) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 3));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(0, 1, 4));
        graph.put(4, Arrays.asList(3));

        GraphDFS gdfs = new GraphDFS();
        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal starting from node 0: ");
        gdfs.dfs(0, graph, visited);  // Output: 0 1 2 3 4
    }
}


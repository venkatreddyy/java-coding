package com.venkat.dsa.patterns;

import java.util.*;

import java.util.*;

public class GraphDFS {

    // Perform DFS on a graph starting from a given node
    public void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(node);
        System.out.print(node + " "); // Process the current node (print it)

        // Explore all the neighbors of the current node
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            // If the neighbor has not been visited yet
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited); // Recursive DFS call for the unvisited neighbor
            }
        }
    }

    public static void main(String[] args) {
        // Create an adjacency list to represent the graph
        // Graph structure:
        //     0
        //    / \
        //   1   3
        //  / \   \
        // 2   3   4
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Node 0 has edges to 1 and 3
        graph.put(0, Arrays.asList(1, 3));

        // Node 1 has edges to 0, 2, and 3
        graph.put(1, Arrays.asList(0, 2, 3));

        // Node 2 has an edge to 1
        graph.put(2, Arrays.asList(1));

        // Node 3 has edges to 0, 1, and 4
        graph.put(3, Arrays.asList(0, 1, 4));

        // Node 4 has an edge to 3
        graph.put(4, Arrays.asList(3));

        // Create a GraphDFS object and a set to keep track of visited nodes
        GraphDFS gdfs = new GraphDFS();
        Set<Integer> visited = new HashSet<>();

        // Start DFS traversal from node 0
        System.out.print("DFS Traversal starting from node 0: ");
        gdfs.dfs(0, graph, visited);  // Expected Output: 0 1 2 3 4
    }
}



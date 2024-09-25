package com.venkat.dsa.patterns;

import java.util.*;

public class GraphBFS {

    // Perform BFS on the graph starting from the given source node
    public void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        // Queue to process the nodes
        Queue<Integer> queue = new LinkedList<>();
        // Set to mark visited nodes
        Set<Integer> visited = new HashSet<>();

        // Start with the source node
        queue.add(startNode);
        visited.add(startNode);

        // BFS traversal
        while (!queue.isEmpty()) {
            // Dequeue the front node
            int node = queue.poll();
            System.out.print(node + " "); // Print or process the node

            // Visit all the neighbors of the current node
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creating an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 3));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(0, 1, 4));
        graph.put(4, Arrays.asList(3));

        GraphBFS g = new GraphBFS();
        System.out.print("BFS Traversal starting from node 0: ");
        g.bfs(0, graph);  // Output: BFS Traversal starting from node 0: 0 1 3 2 4
    }
}


package com.venkat.dsa.patterns;

import java.util.*;
/*
Explanation of Key Concepts:
Graph Representation:

The graph is represented as an adjacency list, where each node is mapped to a list of its neighbors.
In this example, the graph is:
lua
Copy code
0 -- 1 -- 2
|  \ |
3 -- 4
BFS Algorithm:

Queue: BFS uses a queue to explore nodes level by level. We process a node, then enqueue all its unvisited neighbors.
Set: A Set is used to track visited nodes to prevent revisiting the same node.
Dequeuing: The front node is removed from the queue, processed, and all its unvisited neighbors are added to the queue for future processing.
Main Function:

The graph is created using a Map of node-to-neighbors (List<Integer>).
The BFS traversal starts from node 0, and the output is printed as nodes are visited in BFS order.
Traversal Order:
Starting from node 0, the BFS traversal visits the nodes in the following order:

First, it visits node 0, then its neighbors 1 and 3.
From node 1, it visits its unvisited neighbor 2.
From node 3, it visits its unvisited neighbor 4.
 */
public class GraphBFS {

    // Perform BFS on the graph starting from the given source node
    public void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        // Queue to process the nodes during BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        // Set to keep track of visited nodes to avoid revisiting
        Set<Integer> visited = new HashSet<>();

        // Start the traversal by adding the source node to the queue
        queue.add(startNode);
        // Mark the source node as visited
        visited.add(startNode);

        // Perform BFS while there are still nodes to process in the queue
        while (!queue.isEmpty()) {
            // Dequeue the front node from the queue
            int node = queue.poll();
            // Print or process the current node
            System.out.print(node + " ");

            // Visit all the neighbors of the current node
            // graph.getOrDefault(node, new ArrayList<>()) returns the neighbors list of the node,
            // or an empty list if the node has no neighbors
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                // If the neighbor hasn't been visited yet
                if (!visited.contains(neighbor)) {
                    // Add the neighbor to the queue for future processing
                    queue.add(neighbor);
                    // Mark the neighbor as visited
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create an adjacency list to represent the graph
        // Example graph:
        //     0----1
        //    / \  / \
        //   3   4-2
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

        // Instantiate the GraphBFS class
        GraphBFS g = new GraphBFS();
        // Perform BFS traversal starting from node 0
        System.out.print("BFS Traversal starting from node 0: ");
        g.bfs(0, graph);  // Expected Output: BFS Traversal starting from node 0: 0 1 3 2 4
    }
}



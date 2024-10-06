package com.venkat.dsa.javaCollections;

import java.util.*;
/*
Breadth-First Search (BFS) Algorithm
Breadth-First Search (BFS) is a graph traversal algorithm that explores all the vertices at the present level (breadth) before moving to the next level (depth). BFS is commonly used for finding the shortest path in unweighted graphs and for exploring all vertices that are reachable from the source vertex.

BFS Algorithm Steps:
Start from a source node (often called the "start" node).
Mark the source node as visited and enqueue it.
Dequeue a node from the front of the queue and explore all its unvisited neighbors.
Mark the neighbors as visited and enqueue them.
Repeat steps 3-4 until the queue is empty.
Graph Representation:
We will represent the graph using an Adjacency List (which is an efficient way of representing graphs, especially sparse graphs).

   0 --- 1
   |    / \
   |   /   \
   2  3 --- 4
       \   /
         5
The BFS traversal starting from vertex 0 will visit 0, 1, 2 in the first layer, followed by 3, 4, and finally 5.


Time Complexity:
Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
Each vertex is visited once.
Each edge is explored once.
Space Complexity:
Space Complexity: O(V) for storing the visited set and the queue.
We store up to V vertices in the queue and visited set.
Use Cases of BFS:
Shortest Path in an Unweighted Graph: BFS guarantees the shortest path (in terms of the number of edges) in an unweighted graph. This is why BFS is often used in shortest path algorithms for unweighted graphs.
Level-Order Traversal: In tree structures, BFS is used to traverse levels (e.g., level-order traversal of binary trees).
Connectivity in Graphs: BFS can be used to determine if all vertices in a graph are reachable from a given vertex (i.e., if the graph is connected).
Advantages of BFS:
Shortest Path Guarantee: BFS always finds the shortest path in an unweighted graph, making it useful for shortest path algorithms.
Layered Exploration: BFS explores vertices level by level, which is useful in problems where exploring neighbors is more important than depth.
Example of BFS on the Following Graph:
lua
Copy code
   0 --- 1
   |    / \
   |   /   \
   2  3 --- 4
       \   /
         5
The BFS traversal starting from vertex 0 will visit 0, 1, 2 in the first layer, followed by 3, 4, and finally 5.


Code Implementation: BFS Algorithm in Java
We'll implement BFS using Java with a Graph class that uses an adjacency list and performs BFS traversal.


Explanation:
Graph Representation:

We use an adjacency list to represent the graph. The adjacencyList is a HashMap where each key is a vertex, and the value is a list of its neighbors (adjacent vertices).
BFS Algorithm:

The BFS algorithm uses a queue to traverse the graph level by level.
We start at the startVertex, mark it as visited, and enqueue it.
Then, we dequeue a vertex, explore all of its unvisited neighbors, mark them as visited, and enqueue them.
The process repeats until the queue is empty, ensuring that all vertices at one level are explored before moving to the next level.
Visited Set:

A Set is used to track the visited nodes to avoid revisiting and getting stuck in cycles.
Sample Output:
BFS Traversal starting from vertex 0: 0 1 2 3 4 5
Explanation of Output:
The BFS starts at vertex 0, explores its neighbors 1 and 2, and then proceeds to the neighbors of 1 (i.e., 3 and 4), and finally explores the neighbors of 2 (i.e., 5).
BFS explores all vertices at the current level before moving to the next level. Therefore, all the vertices connected to the source vertex 0 are visited in the order of their levels.


 */
public class GraphBFS {
    private Map<Integer, List<Integer>> adjacencyList;  // Adjacency list to store the graph

    // Constructor to initialize the graph
    public GraphBFS() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices (undirected graph)
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);    // Add destination to source's list
        adjacencyList.get(destination).add(source);    // Add source to destination's list (undirected graph)
    }

    // BFS traversal from a given start vertex
    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();  // Set to keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue to manage the BFS traversal order

        // Start the BFS traversal from the start vertex
        visited.add(startVertex); // Mark the start vertex as visited
        queue.offer(startVertex); // Enqueue the start vertex

        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // Dequeue the front element
            System.out.print(currentVertex + " "); // Print the current vertex

            // Explore all unvisited adjacent vertices
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);   // Mark the neighbor as visited
                    queue.offer(neighbor);   // Enqueue the neighbor
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // Add vertices to the graph
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges between the vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Perform BFS starting from vertex 0
        System.out.print("BFS Traversal starting from vertex 0: ");
        graph.bfs(0);
    }
}


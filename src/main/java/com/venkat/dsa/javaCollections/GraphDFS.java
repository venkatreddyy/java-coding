package com.venkat.dsa.javaCollections;

import java.util.*;
/*
DFS Traversal starting from vertex 0: 0 1 3 4 5 2
The Depth First Search (DFS) algorithm is a graph traversal technique that explores as far as possible along each branch before backtracking. DFS is commonly used for tasks like finding connected components, detecting cycles, and performing topological sorts on directed acyclic graphs (DAGs).

DFS Algorithm Steps:
Start from a node (often called the "source" or "root" node).
Mark the node as visited to avoid revisiting it.
Explore all unvisited adjacent nodes (neighbors) recursively, moving deeper into the graph.
Backtrack once all the neighbors of a node are explored.
Graph Representation:
We'll represent the graph using an Adjacency List (a common and efficient way of representing graphs). Each node will have a list of adjacent nodes.


Example of DFS on the Following Graph:
0 --- 1
   |    / \
   |   /   \
   2  3 --- 4
       \   /
         5

 */
public class GraphDFS {
    private Map<Integer, List<Integer>> adjacencyList;  // Adjacency list to store the graph

    // Constructor to initialize the graph
    public GraphDFS() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices (undirected graph)
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);    // Add destination to source's list
        adjacencyList.get(destination).add(source);    // Add source to destination's list (since it's undirected)
    }

    // DFS helper method to perform DFS recursively
    private void dfsUtil(int vertex, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(vertex);
        System.out.print(vertex + " ");  // Print the visited node

        // Recur for all adjacent vertices that haven't been visited
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal of the vertices reachable from a given vertex
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();  // Set to keep track of visited nodes
        dfsUtil(startVertex, visited);  // Start DFS from the given start vertex
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();

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

        // Perform DFS starting from vertex 0
        System.out.print("DFS Traversal starting from vertex 0: ");
        graph.dfs(0);
    }
}


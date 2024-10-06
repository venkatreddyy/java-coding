package com.venkat.dsa.patterns;

import java.util.*;
/*

Topological Sorting
Topological Sorting is an algorithm used to order the vertices of a Directed Acyclic Graph (DAG) such that for every directed edge
𝑢
→
𝑣
u→v, vertex
𝑢
u comes before vertex
𝑣
v in the ordering. This sorting is used in scenarios where a set of tasks must be performed in a specific order, such as scheduling jobs, building dependencies in software, or determining the order of compilation in programming languages.

Key Points:
Directed Acyclic Graph (DAG): Topological sorting can only be performed on DAGs (graphs with directed edges and no cycles).
Ordering: Vertices are arranged so that for every directed edge
𝑢
→
𝑣
u→v,
𝑢
u appears before
𝑣
v in the sorted order.
Multiple Solutions: A DAG can have multiple valid topological sorts.
Applications:
Task Scheduling
Course prerequisite problem
Determining compilation order in programming
Resolving dependencies
Approach:
There are two popular algorithms for topological sorting:

Kahn's Algorithm (using in-degree)
Depth-First Search (DFS) based approach
1. Kahn’s Algorithm (BFS-based):
This approach works by maintaining the in-degree of each vertex (the number of incoming edges to the vertex). It repeatedly removes vertices with zero in-degree (vertices that have no prerequisites) from the graph and reduces the in-degree of their neighbors.

Steps:
Calculate the in-degree (number of incoming edges) for each vertex.
Initialize a queue and add all vertices with an in-degree of zero.
Process each vertex from the queue by removing it and reducing the in-degree of its neighbors. If any neighbor’s in-degree becomes zero, add it to the queue.
Repeat until the queue is empty. If all vertices are processed, the topological sort is complete.

Topological Sort (DFS):
5 4 2 3 1 0
 */
public class TopologicalSortDFS {

    // Function to perform Topological Sort using DFS
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V]; // Array to keep track of visited nodes
        Stack<Integer> stack = new Stack<>(); // Stack to store the topological order

        // Perform DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }

        // Retrieve the topological order from the stack
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // DFS helper function to visit nodes
    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true; // Mark the node as visited

        // Visit all the neighbors of the node
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, stack);
            }
        }

        // Once all neighbors are visited, push this node onto the stack
        stack.push(node);
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
        System.out.println("Topological Sort (DFS):");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}


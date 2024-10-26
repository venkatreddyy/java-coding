package com.venkat.codility.hard.GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;
/*
1. Cycle Detection in Undirected Graph
Problem: Detect if there is a cycle in an undirected graph.

Approach:
Use DFS to traverse the graph.
For each node, check all adjacent nodes:
If an adjacent node is visited and is not the parent, a cycle exists.

Explanation:
DFS with Cycle Detection: For each node, traverse its neighbors recursively. If a visited neighbor isn’t the parent, it indicates a cycle.
Example Output:
Graph has a cycle: true
 */
public class CycleDetectionUndirectedGraph {

    static class Graph {
        private final int vertices;
        private final List<List<Integer>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since the graph is undirected
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && dfs(i, visited, -1)) {
                    return true;
                }
            }
            return false;
        }

        private boolean dfs(int v, boolean[] visited, int parent) {
            visited[v] = true;
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    if (dfs(neighbor, visited, v)) return true;
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // This creates a cycle

        System.out.println("Graph has a cycle: " + graph.hasCycle()); // Expected Output: true
    }
}


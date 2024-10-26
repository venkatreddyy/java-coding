package com.venkat.codility.medium.GraphAlgorithms;

import java.util.*;

public class GraphTraversal {
    static class Graph {
        private final int vertices;
        private final LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest) {
            adjList[src].add(dest);
        }

        void DFS(int start) {
            boolean[] visited = new boolean[vertices];
            DFSUtil(start, visited);
        }

        private void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for (int adj : adjList[vertex]) {
                if (!visited[adj]) DFSUtil(adj, visited);
            }
        }

        void BFS(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");
                for (int adj : adjList[vertex]) {
                    if (!visited[adj]) {
                        visited[adj] = true;
                        queue.add(adj);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("DFS starting from vertex 2: ");
        graph.DFS(2);  // Output: 2 0 1 3
        System.out.println();
        System.out.print("BFS starting from vertex 2: ");
        graph.BFS(2);  // Output: 2 0 3 1
    }
}

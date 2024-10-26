package com.venkat.codility.medium.GraphAlgorithms;

import java.util.*;

public class ShortestPathUnweighted {
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
            adjList[dest].add(src); // For undirected graph
        }

        int[] shortestPath(int start) {
            int[] distance = new int[vertices];
            Arrays.fill(distance, -1);
            Queue<Integer> queue = new LinkedList<>();
            distance[start] = 0;
            queue.add(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                for (int adj : adjList[vertex]) {
                    if (distance[adj] == -1) {
                        distance[adj] = distance[vertex] + 1;
                        queue.add(adj);
                    }
                }
            }
            return distance;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        int[] distances = graph.shortestPath(0);
        System.out.println("Shortest path distances from vertex 0: " + Arrays.toString(distances));
        // Output: [0, 1, 1, 2, 3, 4]
    }
}

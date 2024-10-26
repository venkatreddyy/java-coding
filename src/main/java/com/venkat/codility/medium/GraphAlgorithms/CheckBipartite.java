package com.venkat.codility.medium.GraphAlgorithms;

import java.util.*;

public class CheckBipartite {
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
            adjList[dest].add(src);
        }

        boolean isBipartite() {
            int[] colors = new int[vertices];
            Arrays.fill(colors, -1);

            for (int i = 0; i < vertices; i++) {
                if (colors[i] == -1 && !bipartiteBFS(i, colors)) {
                    return false;
                }
            }
            return true;
        }

        private boolean bipartiteBFS(int start, int[] colors) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            colors[start] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int adj : adjList[node]) {
                    if (colors[adj] == -1) {
                        colors[adj] = 1 - colors[node];
                        queue.add(adj);
                    } else if (colors[adj] == colors[node]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.println("Is Bipartite: " + graph.isBipartite()); // Output: true
    }
}


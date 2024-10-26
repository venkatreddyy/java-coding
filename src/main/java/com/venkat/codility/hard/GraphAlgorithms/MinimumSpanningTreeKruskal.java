package com.venkat.codility.hard.GraphAlgorithms;

import java.util.*;
/*
3. Minimum Spanning Tree (using Kruskal's algorithm)
Problem: Find the minimum spanning tree (MST) of a connected undirected graph.

Approach:
Use Kruskal’s algorithm with Union-Find to select edges with the smallest weights, avoiding cycles.
Sort edges by weight and iteratively add the smallest edge that doesn’t form a cycle.

Explanation:
Union-Find is used to avoid cycles.
Edges are added in increasing order of weight, constructing the MST.
Example Output:
MST edges:
From 1 to 2 with weight 2
From 0 to 1 with weight 4
From 1 to 3 with weight 6

 */
public class MinimumSpanningTreeKruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class UnionFind {
        private final int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    public static List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (uf.find(edge.src) != uf.find(edge.dest)) {
                uf.union(edge.src, edge.dest);
                mst.add(edge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 6));
        edges.add(new Edge(2, 3, 8));

        List<Edge> mst = kruskalMST(edges, 4);
        System.out.println("MST edges:");
        for (Edge edge : mst) {
            System.out.println("From " + edge.src + " to " + edge.dest + " with weight " + edge.weight);
        }
    }
}


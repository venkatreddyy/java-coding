package com.venkat.hundred;

import java.util.*;
/*
Detailed Explanation of Each Problem:
Print Adjacency List:

Description: Prints the adjacency list representation of a graph.
Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
Space Complexity: O(V + E) for storing the adjacency list.
BFS of Graph:

Description: Performs breadth-first search (BFS) starting from node 0.
Time Complexity: O(V + E) as BFS visits each vertex and edge once.
Space Complexity: O(V) for storing the visited array and queue.
DFS of Graph:

Description: Performs depth-first search (DFS) to visit all nodes in the graph.
Time Complexity: O(V + E) for visiting each vertex and edge once.
Space Complexity: O(V) for storing the visited array and recursion stack.
Transitive Closure of a Graph:

Description: Uses the Floyd-Warshall algorithm to compute the transitive closure of a graph.
Time Complexity: O(V^3) due to three nested loops.
Space Complexity: O(V^2) for storing the transitive closure matrix.
Union-Find Algorithm:

Description: Implements the union-find algorithm with path compression and union by rank.
Time Complexity: O(log V) for each union or find operation.
Space Complexity: O(V) for storing parent and rank arrays.
Detect Cycle using DSU:

Description: Detects if a graph has a cycle using the disjoint set union (DSU) algorithm.
Time Complexity: O(E log V) where E is the number of edges and V is the number of vertices.
Space Complexity: O(V) for storing parent and rank arrays.
Test Cases in main:
Test Adjacency List: Prints the adjacency list for a sample graph.
Test BFS: Performs BFS starting from vertex 0 and prints the traversal.
Test DFS: Performs DFS starting from vertex 0 and prints the traversal.
Test Transitive Closure: Computes and prints the transitive closure matrix of a graph.
Test Union-Find: Demonstrates the working of union-find operations.
Test Cycle Detection using DSU: Checks if a given graph has a cycle using DSU.
 */
// Class to solve Level 1 graph problems
public class Level1GraphProblems {

    // 1. Print Adjacency List of a Graph
    // Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges
    // Space Complexity: O(V + E), for storing the adjacency list
    public static void printAdjacencyList(int V, List<List<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // 2. Breadth First Search (BFS) of a Graph
    // Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges
    // Space Complexity: O(V), for storing the visited array and the queue
/*    public static void bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V]; // To track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        queue.add(0); // Start BFS from node 0 (can be any node)
        visited[0] = true; // Mark the starting node as visited

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Remove and get the front of the queue
            System.out.print(node + " "); // Print the current node
            // Traverse all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) { // If neighbor hasn't been visited yet
                    queue.add(neighbor); // Add it to the queue
                    visited[neighbor] = true; // Mark it as visited
                }
            }
        }
        System.out.println();
    }*/

    // 3. Depth First Search (DFS) of a Graph
    // Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges
    // Space Complexity: O(V), for storing the visited array and recursion stack
    public static void dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V]; // To track visited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsHelper(i, adj, visited); // Call helper for each unvisited node
            }
        }
        System.out.println();
    }

    // Helper function for DFS
    private static void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true; // Mark the current node as visited
        System.out.print(node + " "); // Print the current node
        // Recur for all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) { // If neighbor hasn't been visited
                dfsHelper(neighbor, adj, visited); // Recursively visit the neighbor
            }
        }
    }

    // 4. Transitive Closure of a Graph (using Floyd-Warshall Algorithm)
    // Time Complexity: O(V^3), where V is the number of vertices
    // Space Complexity: O(V^2), for storing the transitive closure matrix
    public static int[][] transitiveClosure(int V, int[][] graph) {
        int[][] reach = new int[V][V]; // Initialize transitive closure matrix
        // Initialize the reach matrix as the given graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                reach[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall algorithm to compute transitive closure
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach[i][j] = (reach[i][j] != 0 || (reach[i][k] != 0 && reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }
        return reach; // Return the transitive closure matrix
    }

    // 5. Union-Find Algorithm
    // Time Complexity: O(log V), for union-find operations with path compression
    // Space Complexity: O(V), for storing parent and rank arrays
    static class UnionFind {
        int[] parent, rank;

        // Constructor to initialize Union-Find structure
        public UnionFind(int n) {
            parent = new int[n]; // Array to store parent of each node
            rank = new int[n]; // Array to store the rank of each node
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Initially, each node is its own parent
                rank[i] = 0; // Initial rank is 0 for all nodes
            }
        }

        // Find function with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union function with union by rank
        public void union(int x, int y) {
            int rootX = find(x); // Find root of x
            int rootY = find(y); // Find root of y
            if (rootX != rootY) { // If they are in different sets
                if (rank[rootX] > rank[rootY]) { // Union by rank
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    // 6. Detect Cycle using Disjoint Set Union (DSU)
    // Time Complexity: O(E log V), where E is the number of edges and V is the number of vertices
    // Space Complexity: O(V), for storing parent and rank arrays
    public static boolean detectCycle(int V, int[][] edges) {
        UnionFind uf = new UnionFind(V); // Initialize Union-Find structure
        // Iterate through all edges in the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // If u and v are already in the same set, a cycle is detected
            if (uf.find(u) == uf.find(v)) return true;
            uf.union(u, v); // Union the two vertices
        }
        return false; // No cycle detected
    }

    // Main method to test all functions
    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        int V = 4; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example edges for an undirected graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        // 1. Test Adjacency List
        System.out.println("Adjacency List:");
        printAdjacencyList(V, adj); // Expected: 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0

        // 2. Test BFS
        System.out.println("BFS of Graph:");
     //   bfsOfGraph(V, adj); // Expected: 0 1 2 3

        // 3. Test DFS
        System.out.println("DFS of Graph:");
        dfsOfGraph(V, adj); // Expected: 0 1 2 3

        // 4. Test Transitive Closure
        System.out.println("Transitive Closure of the Graph:");
        int[][] graph = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1}
        };
        int[][] tc = transitiveClosure(V, graph);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println(); // Expected transitive closure matrix
        }

        // 5. Test Union-Find (No output, but shows union-find is working)
        UnionFind uf = new UnionFind(V);
        uf.union(0, 1);
        uf.union(1, 2);
        System.out.println("Find(2): " + uf.find(2)); // Expected: 0 or 1, depending on union implementation

        // 6. Test Cycle Detection using DSU
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        boolean hasCycle = detectCycle(V, edges);
        System.out.println("Does the graph have a cycle? " + hasCycle); // Expected: true
    }
}

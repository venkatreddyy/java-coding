package com.venkat.hundred;

import java.util.*;

public class GraphPrograms {

    // 1. Implement Depth First Search (DFS)
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;  // Mark the current node as visited
        System.out.print(node + " ");  // Process the current node

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);  // Recursively visit unvisited neighbors
            }
        }
    }

    // 2. Implement Breadth First Search (BFS)
    public static void bfs(int startNode, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = (Queue<Integer>) new LinkedList();
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");  // Process the current node

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);  // Add unvisited neighbors to the queue
                }
            }
        }
        System.out.println();
    }

    // 3. Detect Cycle in a Graph using DFS
    public static boolean detectCycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;  // Mark the current node as visited

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (detectCycleDFS(neighbor, node, visited, graph)) {
                    return true;  // If a cycle is detected in the recursion, return true
                }
            } else if (neighbor != parent) {
                return true;  // If a visited neighbor is not the parent, there's a cycle
            }
        }
        return false;
    }

    // 4. Find Shortest Path in an Unweighted Graph using BFS
    public static void shortestPathUnweightedGraph(int startNode, int endNode, List<List<Integer>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, -1);  // Initialize distances with -1 (unreachable)
        distance[startNode] = 0;  // Distance to the start node is 0

        Queue<Integer> queue = (Queue<Integer>) new LinkedList();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (distance[neighbor] == -1) {  // If the neighbor hasn't been visited
                    distance[neighbor] = distance[node] + 1;  // Update the distance
                    queue.add(neighbor);

                    if (neighbor == endNode) {
                        System.out.println("Shortest path length: " + distance[endNode]);
                        return;
                    }
                }
            }
        }
        System.out.println("No path found.");
    }

    // 5. Find Shortest Path in a Weighted Graph (Dijkstra's Algorithm)
    public static void dijkstra(int startNode, List<List<int[]>> graph, int vertices) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);  // Initialize distances to infinity
        distance[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));  // Min-heap based on distance
        pq.add(new int[]{startNode, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) continue;  // Skip if a shorter path is already known

            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];
                int newDist = distance[node] + weight;

                if (newDist < distance[neighbor]) {  // Found a shorter path
                    distance[neighbor] = newDist;
                    pq.add(new int[]{neighbor, newDist});  // Add the neighbor to the priority queue
                }
            }
        }

        // Print the shortest distances from the start node
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + " distance: " + (distance[i] == Integer.MAX_VALUE ? "Infinity" : distance[i]));
        }
    }

    // 6. Topological Sorting of a Directed Acyclic Graph (DAG) using DFS
    public static void topologicalSortDFS(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;  // Mark the node as visited

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                topologicalSortDFS(neighbor, visited, stack, graph);  // Visit unvisited neighbors
            }
        }
        stack.push(node);  // Add the node to the stack after visiting all its neighbors
    }

    public static void topologicalSort(List<List<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortDFS(i, visited, stack, graph);  // Perform DFS for each unvisited node
            }
        }

        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // 7. Find Connected Components in a Graph
    public static void findConnectedComponents(List<List<Integer>> graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        int componentCount = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                componentCount++;
                System.out.print("Component " + componentCount + ": ");
                dfs(i, visited, graph);
                System.out.println();
            }
        }
    }

    // 8. Find Bridges in a Graph (DFS-based)
    static int time = 0;
    public static void findBridgesDFS(int node, int parent, boolean[] visited, int[] discovery, int[] low, List<List<Integer>> graph) {
        visited[node] = true;
        discovery[node] = low[node] = ++time;  // Initialize discovery time and low value

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                findBridgesDFS(neighbor, node, visited, discovery, low, graph);

                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > discovery[node]) {
                    System.out.println("Bridge found: " + node + " - " + neighbor);
                }
            } else if (neighbor != parent) {
                low[node] = Math.min(low[node], discovery[neighbor]);
            }
        }
    }

    // 9. Check if a Graph is Bipartite using BFS
    public static boolean isBipartite(List<List<Integer>> graph, int vertices) {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1);  // Initialize all vertices as uncolored

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                if (!bipartiteBFS(i, graph, colors)) {
                    return false;  // If any component is not bipartite, return false
                }
            }
        }
        return true;  // All components are bipartite
    }

    private static boolean bipartiteBFS(int start, List<List<Integer>> graph, int[] colors) {
        Queue<Integer> queue = (Queue<Integer>) new LinkedList();
        queue.add(start);
        colors[start] = 0;  // Color the start node with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node];  // Assign alternate color to the neighbor
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false;  // If neighbor has the same color, it's not bipartite
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Graph representation: adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        graph.get(0).add(1); graph.get(1).add(0);
        graph.get(0).add(2); graph.get(2).add(0);
        graph.get(1).add(3); graph.get(3).add(1);
        graph.get(2).add(3); graph.get(3).add(2);
        graph.get(3).add(4); graph.get(4).add(3);

        // 1. DFS
        System.out.println("DFS Traversal:");
        dfs(0, new boolean[5], graph);  // Output: 0 1 3 2 4
        System.out.println();

        // 2. BFS
        System.out.println("BFS Traversal:");
        //bfs(0, graph);  // Output: 0 1 2 3 4

        // 3. Cycle Detection (DFS)
        System.out.println("Cycle Detection:");
        boolean hasCycle = detectCycleDFS(0, -1, new boolean[5], graph);
        System.out.println("Graph contains a cycle: " + hasCycle);  // Output: true

        // 4. Shortest Path in Unweighted Graph (BFS)
        System.out.println("Shortest Path (Unweighted Graph):");
        //shortestPathUnweightedGraph(0, 4, graph);  // Output: Shortest path length: 3

        // 5. Dijkstra's Algorithm for Shortest Path in Weighted Graph
        List<List<int[]>> weightedGraph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            weightedGraph.add(new ArrayList<>());
        }
        // Adding edges with weights (directed graph)
        weightedGraph.get(0).add(new int[]{1, 10});
        weightedGraph.get(0).add(new int[]{2, 3});
        weightedGraph.get(2).add(new int[]{3, 2});
        weightedGraph.get(3).add(new int[]{4, 1});
        weightedGraph.get(1).add(new int[]{4, 6});

        System.out.println("Dijkstra's Algorithm:");
        dijkstra(0, weightedGraph, 5);  // Output: Shortest distances from node 0

        // 6. Topological Sorting
        List<List<Integer>> dag = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            dag.add(new ArrayList<>());
        }
        dag.get(5).add(2);
        dag.get(5).add(0);
        dag.get(4).add(0);
        dag.get(4).add(1);
        dag.get(2).add(3);
        dag.get(3).add(1);

        System.out.println("Topological Sort:");
        topologicalSort(dag, 6);  // Output: 5 4 2 3 1 0

        // 7. Find Connected Components
        System.out.println("Connected Components:");
        findConnectedComponents(graph, 5);  // Output: Component 1: 0 1 3 2 4

        // 8. Find Bridges in a Graph
        System.out.println("Bridges in the Graph:");
        findBridgesDFS(0, -1, new boolean[5], new int[5], new int[5], graph);  // Output: Bridges found

        // 9. Check if a Graph is Bipartite
        //System.out.println("Is the graph bipartite? " + isBipartite(graph, 5));  // Output: false
    }
}


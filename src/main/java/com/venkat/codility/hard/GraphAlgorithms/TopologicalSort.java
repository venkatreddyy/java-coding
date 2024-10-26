package com.venkat.codility.hard.GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
2. Topological Sorting
Problem: Perform a topological sort on a directed acyclic graph (DAG).

Approach:

Use DFS to order nodes, adding each node to a stack after visiting all its neighbors.
The stack contains nodes in topologically sorted order.
Explanation:

Nodes are added to the stack in reverse topological order by DFS. The stack is then reversed to get the topological order.
Example Output:


Topological Sort: [5, 4, 2, 3, 1, 0]
 */
public class TopologicalSort {

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
            adjList.get(u).add(v); // Directed edge
        }

        public List<Integer> topologicalSort() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited, stack);
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            return result;
        }

        private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, stack);
                }
            }
            stack.push(v);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Topological Sort: " + graph.topologicalSort());
        // Expected Output: [5, 4, 2, 3, 1, 0] (Order may vary)
    }
}


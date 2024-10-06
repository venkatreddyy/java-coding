package com.venkat.dsa.javaCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
Explanation:
Vertices and Adjacency List:

The graph has a given number of vertices. For each vertex, there's a corresponding list that holds its adjacent vertices (neighbors).
adjacencyList.get(source).add(destination) adds the destination vertex to the list of the source vertex.
Add an Edge:

addEdge(int source, int destination) adds an edge between the two vertices. In the case of an undirected graph, it adds the edge in both directions.
Remove an Edge:

removeEdge(int source, int destination) removes an edge by removing the corresponding vertices from each other's adjacency list.
Display the Adjacency List:

displayGraph() prints out each vertex followed by its adjacent vertices.


Graph Adjacency List:
Vertex 0: -> 1 -> 4
Vertex 1: -> 0 -> 2 -> 3 -> 4
Vertex 2: -> 1 -> 3
Vertex 3: -> 1 -> 2 -> 4
Vertex 4: -> 0 -> 1 -> 3

After removing edge 0-4:
Vertex 0: -> 1
Vertex 1: -> 0 -> 2 -> 3 -> 4
Vertex 2: -> 1 -> 3
Vertex 3: -> 1 -> 2 -> 4
Vertex 4: -> 1 -> 3
 */
public class GraphAdjacencyList {
    private int vertices; // Number of vertices in the graph
    private List<List<Integer>> adjacencyList; // Adjacency list to store graph

    // Constructor to initialize the graph with the given number of vertices
    public GraphAdjacencyList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        // Initialize the adjacency list with empty lists for each vertex
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        // Since this is an undirected graph, add an edge in both directions
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For directed graph, remove this line
    }

    // Remove an edge between two vertices
    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        adjacencyList.get(destination).remove(Integer.valueOf(source)); // For directed graph, remove this line
    }

    // Display the adjacency list of the graph
    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer adj : adjacencyList.get(i)) {
                System.out.print(" -> " + adj);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        GraphAdjacencyList graph = new GraphAdjacencyList(5);

        // Add edges between the vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Display the graph's adjacency list
        System.out.println("Graph Adjacency List:");
        graph.displayGraph();

        // Remove an edge and display the updated adjacency list
        graph.removeEdge(0, 4);
        System.out.println("\nAfter removing edge 0-4:");
        graph.displayGraph();
    }
}


package com.venkat.dsa.ds.graph;

class UndirectedGraph {
    private int[][] adjacencyMatrix;  // Stores the edges between vertices
    private char[] vertexLabels;      // Stores the labels (data) of vertices
    private int numberOfVertices;     // Total number of vertices

    // Constructor to initialize the graph with the number of vertices
    public UndirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        this.vertexLabels = new char[numberOfVertices];
    }

    // Method to add an undirected edge between two vertices
    public void addEdge(int u, int v) {
        if (u >= 0 && u < numberOfVertices && v >= 0 && v < numberOfVertices) {
            adjacencyMatrix[u][v] = 1;  // Add edge from u to v
            adjacencyMatrix[v][u] = 1;  // Add edge from v to u (since it's undirected)
        }
    }

    // Method to assign a label (data) to a vertex
    public void addVertexLabel(int vertex, char label) {
        if (vertex >= 0 && vertex < numberOfVertices) {
            vertexLabels[vertex] = label;  // Set the label of the vertex
        }
    }

    // Method to display the adjacency matrix and vertex labels
    public void displayGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nVertex Labels:");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println("Vertex " + i + ": " + vertexLabels[i]);
        }
    }
}

public class UnDirectedGraphDemo {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(4);

        // Adding labels to vertices
        graph.addVertexLabel(0, 'A');
        graph.addVertexLabel(1, 'B');
        graph.addVertexLabel(2, 'C');
        graph.addVertexLabel(3, 'D');

        // Adding edges between vertices
        graph.addEdge(0, 1);  // A - B
        graph.addEdge(0, 2);  // A - C
        graph.addEdge(0, 3);  // A - D
        graph.addEdge(1, 2);  // B - C

        // Display the graph
        graph.displayGraph();
    }
}

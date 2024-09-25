package com.venkat.dsa.ds.graph;

class DirectedWeightedGraph {
    private Integer[][] adjMatrix; // Adjacency matrix to store edge weights
    private char[] vertices;       // Array to store data for each vertex
    private int size;              // Number of vertices

    // Constructor to initialize the graph with the number of vertices
    public DirectedWeightedGraph(int size) {
        this.size = size;
        this.adjMatrix = new Integer[size][size];
        this.vertices = new char[size];
    }

    // Method to add a directed edge with weight between two vertices
    public void addEdge(int source, int destination, int weight) {
        if (source >= 0 && source < size && destination >= 0 && destination < size) {
            adjMatrix[source][destination] = weight; // Set weight for the edge
        }
    }

    // Method to add data to a vertex (e.g., labeling vertices as A, B, C, etc.)
    public void addVertexLabel(int vertex, char label) {
        if (vertex >= 0 && vertex < size) {
            vertices[vertex] = label;
        }
    }

    // Method to print the adjacency matrix and vertex labels
    public void displayGraph() {
        System.out.println("Adjacency Matrix (Edge Weights):");
        for (Integer[] row : adjMatrix) {
            for (Integer cell : row) {
                System.out.print((cell != null ? cell : 0) + " ");
            }
            System.out.println();
        }

        System.out.println("\nVertex Labels:");
        for (int i = 0; i < size; i++) {
            System.out.println("Vertex " + i + ": " + vertices[i]);
        }
    }
}

public class DirectedGraphDemo {
    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph(4);

        // Adding vertex labels
        graph.addVertexLabel(0, 'A');
        graph.addVertexLabel(1, 'B');
        graph.addVertexLabel(2, 'C');
        graph.addVertexLabel(3, 'D');

        // Adding edges with weights
        graph.addEdge(0, 1, 3); // A -> B with weight 3
        graph.addEdge(0, 2, 2); // A -> C with weight 2
        graph.addEdge(3, 0, 4); // D -> A with weight 4
        graph.addEdge(2, 1, 1); // C -> B with weight 1

        // Display the graph
        graph.displayGraph();
    }
}


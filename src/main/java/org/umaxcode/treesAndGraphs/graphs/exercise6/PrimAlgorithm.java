package org.umaxcode.treesAndGraphs.graphs.exercise6;

import java.util.List;

public class PrimAlgorithm {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Add cities
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");
        graph.addCity("E");

        // Add connections (edges with costs)
        graph.addConnection("A", "B", 4);
        graph.addConnection("A", "C", 2);
        graph.addConnection("B", "C", 1);
        graph.addConnection("B", "D", 5);
        graph.addConnection("C", "D", 8);
        graph.addConnection("C", "E", 10);
        graph.addConnection("D", "E", 2);

        // Display the graph
        graph.displayGraph();

        // Find MST using Prim's algorithm
        System.out.println("\nMinimum Spanning Tree (MST):");
        List<Edge> mst = graph.primMST("A");
        for (Edge edge : mst) {
            System.out.println(edge.vertex + " (" + edge.weight + ")");
        }
    }
}

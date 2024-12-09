package org.umaxcode.treesAndGraphs.graphs.exercise5;

import java.util.Map;

public class Dijkstra {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Add vertices
        for (int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        // Add edges (road network)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        // Display the graph
        graph.displayGraph();

        // Find shortest paths from vertex 0
        int startVertex = 0;
        Map<Integer, Integer> distances = graph.dijkstra(startVertex);

        System.out.println("\nShortest paths from vertex " + startVertex + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> Distance: " + entry.getValue());
        }
    }

}

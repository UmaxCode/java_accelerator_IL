package org.umaxcode.treesAndGraphs.graphs.exercise4;

public class GraphDemo {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(4, 0);

        // Display the graph
        graph.displayGraph();

        // Perform DFS traversal
        graph.dfs(2);
    }
}

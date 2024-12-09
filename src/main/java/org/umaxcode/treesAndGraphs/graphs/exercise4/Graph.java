package org.umaxcode.treesAndGraphs.graphs.exercise4;

import java.util.*;

public class Graph {

    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge to the graph (directed)
    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>()); // Ensure both vertices exist
        adjacencyList.get(source).add(destination);
    }

    // Get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    // Perform Depth-First Search (DFS)
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from vertex " + startVertex + ":");
        dfsHelper(startVertex, visited);
    }

    // Helper method for DFS
    private void dfsHelper(int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) {
            return;
        }

        // Mark the current vertex as visited and process it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all the neighbors
        for (int neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Display the graph
    public void displayGraph() {
        System.out.println("Graph Adjacency List:");
        for (int vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }
}

package org.umaxcode.treesAndGraphs.graphs.exercise5;

import java.util.*;

public class Graph {

    private final Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add a weighted edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // For undirected graph
    }

    // Get neighbors of a vertex
    public List<Edge> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    // Implement Dijkstra's Algorithm
    public Map<Integer, Integer> dijkstra(int start) {
        // Priority queue to select the vertex with the smallest distance
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize distances
        for (int vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Add the starting vertex to the priority queue
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            // Skip if the vertex has already been processed
            if (visited.contains(current.vertex)) {
                continue;
            }
            visited.add(current.vertex);

            // Update distances for all neighbors
            for (Edge neighbor : getNeighbors(current.vertex)) {
                if (!visited.contains(neighbor.vertex)) {
                    int newDist = distances.get(current.vertex) + neighbor.weight;
                    if (newDist < distances.get(neighbor.vertex)) {
                        distances.put(neighbor.vertex, newDist);
                        pq.offer(new Edge(neighbor.vertex, newDist));
                    }
                }
            }
        }

        return distances;
    }

    // Display the graph
    public void displayGraph() {
        System.out.println("Graph (Adjacency List):");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            for (Edge edge : adjacencyList.get(vertex)) {
                System.out.print(edge.vertex + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}

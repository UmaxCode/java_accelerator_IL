package org.umaxcode.treesAndGraphs.graphs.exercise6;

import java.util.*;

public class Graph {

    private final Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a city (vertex) to the graph
    public void addCity(String city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
    }

    // Add a connection (edge) between cities with a cost (weight)
    public void addConnection(String city1, String city2, int cost) {
        adjacencyList.putIfAbsent(city1, new ArrayList<>());
        adjacencyList.putIfAbsent(city2, new ArrayList<>());
        adjacencyList.get(city1).add(new Edge(city2, cost));
        adjacencyList.get(city2).add(new Edge(city1, cost)); // Undirected graph
    }

    // Get neighbors of a city
    public List<Edge> getNeighbors(String city) {
        return adjacencyList.getOrDefault(city, new ArrayList<>());
    }

    // Implement Prim's Algorithm
    public List<Edge> primMST(String startCity) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Set<String> visited = new HashSet<>();
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        // Add all edges of the starting city to the priority queue
        visited.add(startCity);
        pq.addAll(getNeighbors(startCity));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            // Skip if the destination city is already in the MST
            if (visited.contains(current.vertex)) {
                continue;
            }

            // Add the edge to the MST
            mst.add(current);
            visited.add(current.vertex);
            totalCost += current.weight;

            // Add edges of the newly added city to the priority queue
            for (Edge neighbor : getNeighbors(current.vertex)) {
                if (!visited.contains(neighbor.vertex)) {
                    pq.offer(neighbor);
                }
            }
        }

        System.out.println("Total cost of MST: " + totalCost);
        return mst;
    }

    // Display the graph
    public void displayGraph() {
        System.out.println("Graph (Adjacency List):");
        for (String city : adjacencyList.keySet()) {
            System.out.print(city + " -> ");
            for (Edge edge : adjacencyList.get(city)) {
                System.out.print(edge.vertex + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}

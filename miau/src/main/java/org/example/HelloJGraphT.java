package org.example;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class HelloJGraphT {
    public static void main(String[] args) {
        DefaultDirectedGraph<String, DefaultEdge> directedGraph =
                new DefaultDirectedGraph<>(DefaultEdge.class);

        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("B", "C");

        // Find shortest path
        DijkstraShortestPath<String, DefaultEdge> dijkstra = new DijkstraShortestPath<>(directedGraph);
        System.out.println("Shortest path from A to C: " + dijkstra.getPath("A", "C"));    }
}

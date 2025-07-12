package com.CollectionFrameWorks.Graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 2);

        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.printGraph();
        System.out.println(graph.getNeighbours(0));
        System.out.println(graph.getNeighbours(1));
        System.out.println(graph.getNeighbours(2));
        System.out.println(graph.getNeighbours(3));

    }
}


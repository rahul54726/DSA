package com.CollectionFrameWorks.Graphs.DijkstrasAlgorith;

import com.CollectionFrameWorks.Graphs.DFS.Graph;

public class Main {
    public static void main(String[] args) {
        DijkstraAlgorithm graph=new DijkstraAlgorithm(6);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,2);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,7);
        graph.addEdge(2,4,3);
        graph.addEdge(4,3,2);
        graph.addEdge(4,5,5);
        graph.addEdge(3,5,1);
        graph.dijkstra(0);
    }
}

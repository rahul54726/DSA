package com.CollectionFrameWorks.Graphs.graph;

import java.util.LinkedList;

public class Graph {
    private  int numVertices;
    private  LinkedList<Integer>[] adjacencyList;
    public Graph(int size) {
        this.numVertices = size;
        adjacencyList=new LinkedList[size];
        for (int i=0;i<size;i++){
            adjacencyList[i]=new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
//        for bi-directional graph
        adjacencyList[destination].add(source);
    }
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer vertex : adjacencyList[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }
    public LinkedList<Integer> getNeighbours(int source){
        return adjacencyList[source];

    }
    private class Edge{
        int des,src;
        public Edge(int src,int destination){
            this.des=destination;
            this.src=src;
        }
    }
}




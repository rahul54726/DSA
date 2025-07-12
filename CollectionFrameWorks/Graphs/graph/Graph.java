package com.CollectionFrameWorks.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private  int numVertices;
    private LinkedList<Integer>[] adjacencyList;
    public Graph(int size) {
        this.numVertices = size;
        adjacencyList=new LinkedList[size];
        for (int i=0;i<size;i++){
            adjacencyList[i]=new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
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
        int destination,weight;
        public Edge(int destination,int weight){
            this.destination=destination;
            this.weight=weight;
        }
    }
}




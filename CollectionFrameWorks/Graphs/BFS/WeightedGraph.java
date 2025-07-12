package com.CollectionFrameWorks.Graphs.BFS;

import com.CollectionFrameWorks.Graphs.WtGraph;

import java.util.LinkedList;
import java.util.Queue;

public class WeightedGraph {
    private int vertecies;
    LinkedList<Edge>[] adjList;
    public WeightedGraph(int size){
        this.vertecies=size;
        adjList=new LinkedList[size];
        for (int i=0;i<size;i++){
            adjList[i]=new LinkedList<>();
        }
    }
     public void addEdge(int src,int destination,int weight){
        Edge edge=new Edge(destination,weight);
        adjList[src].add(edge);
     }
     public void bfs(int start){

     }
    private class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int des,int weight){
            this.destination=des;
            this.weight=weight;
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph=new WeightedGraph(4);
        graph.addEdge(0,0,100);
        graph.addEdge(0,2,10);

        graph.addEdge(1,2,20);
        graph.addEdge(1,3,30);

        graph.addEdge(2,0,60);
        graph.addEdge(2,1,40);
        graph.addEdge(2,3,50);

        graph.addEdge(3,1,80);
        graph.addEdge(3,2,70);
//        graph.bfs();

    }
}

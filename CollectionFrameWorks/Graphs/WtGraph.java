package com.CollectionFrameWorks.Graphs.wtgraph;
import java.util.ArrayList;
import java.util.LinkedList;

public class WtGraph {
    private int vertices;
    private LinkedList<Edge>[] adjlist;
    private class Edge{
        int source, destination,weight;
        public Edge(int destination,int weight){
            this.destination=destination;
            this.weight=weight;
        }
    }
    public WtGraph(int size){
        this.vertices =size;
        adjlist=new LinkedList[size];
        for (int i=0;i<size;i++){
            adjlist[i]=new LinkedList<Edge>();
        }
    }
    public void addaEdge(int source,int destinaltion,int weight){
        Edge edge=new Edge(destinaltion,weight);
        adjlist[source].add(edge);
    }
    public void display(){
        for (int i =0;i< vertices;i++){
            LinkedList<Edge> list =adjlist[i];
            System.out.print("Vertex " + i +":");
            for (Edge edge : adjlist[i]){
                System.out.print( " -> " + edge.destination +"( with Weight of : "+ edge.weight+")");
            }
            System.out.println();
        }
    }
public ArrayList<Integer> getne(int source){
        ArrayList<Integer> list =new ArrayList<>();
        for (Edge edge :adjlist[source]){
            list.add(edge.destination);
        }
    return list;
}

}

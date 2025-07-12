package com.CollectionFrameWorks.Graphs.AdjMatrix;

public class WtGraph {
    private int vertices;
    private int[][] adjMat;
    public WtGraph(int size){
        this.vertices=size;
        adjMat=new int[size][size];
    }
    public void addEdge(int source,int destination,int weight){
        adjMat[source][destination]=weight;
        adjMat[destination][source]=weight;
    }
    public void display() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMat[i][j] + " ");
            } System.out.println(); }
    }

    public static void main(String[] args) {
        WtGraph graph=new WtGraph(4);
        graph.addEdge(0,2,10);

        graph.addEdge(1,2,20);
        graph.addEdge(1,3,30);

        graph.addEdge(2,0,60);
        graph.addEdge(2,1,40);
        graph.addEdge(2,3,50);

        graph.addEdge(3,1,80);
        graph.addEdge(3,2,70);
        graph.display();
    }
}

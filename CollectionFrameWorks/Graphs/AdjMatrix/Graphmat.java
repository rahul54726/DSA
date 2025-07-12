package com.CollectionFrameWorks.Graphs.AdjMatrix;

public class Graphmat {
    private int vertcies;
    private int[][] adjMatrix;
    public Graphmat(int size){
        this.vertcies=size;
        adjMatrix=new int[size][size];
    }
    public void addEdge(int source,int destination){
        adjMatrix[source][destination]=1;
        adjMatrix[destination][source]=1;
    }
    public void display() {
        for (int i = 0; i < vertcies; i++) {
            for (int j = 0; j < vertcies; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            } System.out.println(); }
    }


    public static void main(String[] args) {
        Graphmat graph=new Graphmat(4);
        graph.addEdge(0, 2);

        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.display();
    }
}

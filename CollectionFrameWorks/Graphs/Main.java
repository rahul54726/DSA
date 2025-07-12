package com.CollectionFrameWorks.Graphs;

public class Main {
    public static void main(String[] args) {
        WtGraph graph=new WtGraph(4);
        graph.addaEdge(0,0,100);
        graph.addaEdge(0,2,10);

        graph.addaEdge(1,2,20);
        graph.addaEdge(1,3,30);

        graph.addaEdge(2,0,60);
        graph.addaEdge(2,1,40);
        graph.addaEdge(2,3,50);

        graph.addaEdge(3,1,80);
        graph.addaEdge(3,2,70);
        graph.display();
        System.out.println(graph.getne(0));
        System.out.println(graph.getne(1));
        System.out.println(graph.getne(2));
        System.out.println(graph.getne(3));
    }
}
